//事务示例
@Override
@Transactional
public int likeTale(PairIds pairIds) {
    try {
        int like = taleActionMapper.likeTale(pairIds);
        int increase = taleMapper.increaseLike(pairIds.getToId());
        if (like == 1 && increase == 1) {
            return 1;
        } else {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    } catch (Exception e) {
        logger.error("insert data into database error: " + e.getMessage());
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return 0;
    }
}

//多级缓存示例
@Override
@Cacheable(value = CacheKey.USER_CACHE_KEY, keyGenerator = "selfKeyGenerate")
public User login(User user) throws NullCacheException {
    try {
        User redisUser = redisUtil.get("user:" + user.getUsername(), User.class);
        logger.info("get data from redis cache: " + redisUser);
        return redisUser;
    } catch (NullCacheException e) {
        throw new NullCacheException("redis cache " + "'user:" + user.getUsername() + "' is null");
    } catch (Exception e) {
        logger.error("get data from redis cache error: " + e.getMessage());
    }
    try {
        User userFromDatabase = userMapper.login(user);
        if (userFromDatabase != null) {
            redisUtil.set("user:" + user.getUsername(), userFromDatabase, CacheExpire.USER_CACHE_EXPIRE * 2);
        } else {
            redisUtil.set("user:" + user.getUsername(), "null", CacheExpire.USER_CACHE_EXPIRE);
        }
        return userFromDatabase;
    } catch (Exception e) {
        logger.error("get data from database error: " + e.getMessage());
        return null;
    }
}

//CompletableFuture示例
private HttpResponseEntity selectUserList(String json) {
    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    Page page = new Gson().fromJson(json, Page.class);
    CompletableFuture<List<User>> selectHotUserList = CompletableFuture.supplyAsync(() -> {
        logger.info("Async task started in thread: " + Thread.currentThread().getName());
        try {
            return userService.selectUserList(page);
        } catch (NullCacheException e) {
            logger.error("NullCacheException: " + e.getMessage());
            throw new CacheException(e.getMessage(), e);
        }
    }, executor);

    try {
        List<User> result = selectHotUserList.join();
        if (result != null) {
            httpResponseEntity.setCode(HttpResponseEntity.code200().getCode());
            httpResponseEntity.setData(AESUtil.encode(new Gson().toJson(result), AESUtil.KEY));
            httpResponseEntity.setMessage(AESUtil.encode("查询成功", AESUtil.KEY));
        } else {
            httpResponseEntity.setCode(HttpResponseEntity.code500().getCode());
            httpResponseEntity.setData(null);
            httpResponseEntity.setMessage(AESUtil.encode("服务器内部错误", AESUtil.KEY));
        }
    } catch (CacheException e) {
        logger.error("CacheException: " + e.getMessage());
        return HttpResponseEntity.code200Null();
    }
    return httpResponseEntity;
}