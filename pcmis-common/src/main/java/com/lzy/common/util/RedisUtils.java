package com.lzy.common.util;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 * 提供了一系列操作Redis的方法，包括但不限于：设置键值对、获取值、删除键、设置过期时间等
 */
@Getter
@Component
public class RedisUtils {

    // 日志记录器
    private static final Logger log = LoggerFactory.getLogger(RedisUtils.class);

    // Redis模板，用于执行Redis操作
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 发布消息到指定频道
     *
     * @param channel 频道名
     * @param message 消息内容
     */
    public void convertAndSend(String channel, Object message) {
        redisTemplate.convertAndSend(channel, message);
    }

    /**
     * 设置键的过期时间
     *
     * @param key  键
     * @param time 过期时间（秒）
     */
    public void expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
        } catch (Exception e) {
            log.error("设置过期时间失败", e);
        }
    }

    /**
     * 获取键的过期时间
     *
     * @param key 键
     * @return 过期时间（秒）
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 判断键是否存在
     *
     * @param key 键
     * @return 存在返回true，不存在返回false
     */
    public boolean hasKey(String key) {
        try {
            return Boolean.TRUE.equals(redisTemplate.hasKey(key));
        } catch (Exception e) {
            log.error("查询key失败", e);
            return false;
        }
    }

    /**
     * 删除键
     *
     * @param key 键
     */
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /**
     * 获取值
     *
     * @param key 键
     * @return 值
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 设置值
     *
     * @param key   键
     * @param value 值
     * @return 设置成功返回true，设置失败返回false
     */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            log.error("设置key失败", e);
            return false;
        }
    }

    /**
     * 设置值并设置过期时间
     *
     * @param key   键
     * @param value 值
     * @param time  过期时间（秒）
     * @return 设置成功返回true，设置失败返回false
     */
    public boolean set(String key, Object value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            log.error("设置key失败", e);
            return false;
        }
    }

    /**
     * 递增键的值
     *
     * @param key   键
     * @param delta 递增因子，必须大于0
     * @return 递增后的值
     */
    public long incr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 递减键的值
     *
     * @param key   键
     * @param delta 递减因子，必须大于0
     * @return 递减后的值
     */
    public long decr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, -delta);
    }

    /**
     * 获取哈希表中的值
     *
     * @param key  键
     * @param item 项
     * @return 值
     */
    public Object hget(String key, String item) {
        return redisTemplate.opsForHash().get(key, item);
    }

    /**
     * 获取哈希表中的所有值
     *
     * @param key 键
     * @return 所有值
     */
    public Map<String, Object> hmget(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 设置哈希表中的所有值
     *
     * @param key 键
     * @param map 值
     * @return 设置成功返回true，设置失败返回false
     */
    public boolean hmset(String key, Map<String, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            log.error("设置key失败", e);
            return false;
        }
    }

    /**
     * 设置哈希表中的所有值，并设置过期时间
     *
     * @param key  键
     * @param map  值
     * @param time 过期时间（秒）
     * @return 设置成功返回true，设置失败返回false
     */
    public boolean hmset(String key, Map<String, Object> map, long time) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            log.error("设置key失败", e);
            return false;
        }
    }

    /**
     * 设置哈希表中的值
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @return 设置成功返回true，设置失败返回false
     */
    public boolean hset(String key, String item, Object value) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            return true;
        } catch (Exception e) {
            log.error("设置key失败", e);
            return false;
        }
    }

    /**
     * 设置哈希表中的值，并设置过期时间
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @param time  过期时间（秒）
     * @return 设置成功返回true，设置失败返回false
     */
    public boolean hset(String key, String item, Object value, long time) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            log.error("设置key失败", e);
            return false;
        }
    }

    /**
     * 删除哈希表中的项
     *
     * @param key  键
     * @param item 项
     */
    public void hdel(String key, Object... item) {
        redisTemplate.opsForHash().delete(key, item);
    }

    /**
     * 判断哈希表中项是否存在
     *
     * @param key  键
     * @param item 项
     * @return 存在返回true，不存在返回false
     */
    public boolean hHasKey(String key, String item) {
        return redisTemplate.opsForHash().hasKey(key, item);
    }

    /**
     * 递增哈希表中的值
     *
     * @param key  键
     * @param item 项
     * @param by   递增因子
     * @return 递增后的值
     */
    public double hincr(String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item, by);
    }

    /**
     * 递减哈希表中的值
     *
     * @param key  键
     * @param item 项
     * @param by   递减因子
     * @return 递减后的值
     */
    public double hdecr(String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item, -by);
    }
    // ============================set=============================

    /**
     * 获取集合中的所有值
     *
     * @param key 键
     * @return 所有值
     */
    public Set<Object> sGet(String key) {
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            log.error("获取key失败", e);
            return null;
        }
    }

    /**
     * 判断集合中值是否存在
     *
     * @param key   键
     * @param value 值
     * @return 存在返回true，不存在返回false
     */
    public boolean sHasKey(String key, Object value) {
        try {
            return redisTemplate.opsForSet().isMember(key, value);
        } catch (Exception e) {
            log.error("获取key失败", e);
            return false;
        }
    }

    /**
     * 设置集合中的值
     *
     * @param key    键
     * @param values 值
     * @return 设置成功的值的数量
     */
    public long sSet(String key, Object... values) {
        try {
            return redisTemplate.opsForSet().add(key, values);
        } catch (Exception e) {
            log.error("设置key失败", e);
            return 0;
        }
    }

    /**
     * 设置集合中的值并设置过期时间
     *
     * @param key    键
     * @param time   过期时间（秒）
     * @param values 值
     * @return 设置成功的值的数量
     */
    public long sSetAndTime(String key, long time, Object... values) {
        try {
            Long count = redisTemplate.opsForSet().add(key, values);
            if (time > 0) {
                expire(key, time);
            }
            return count;
        } catch (Exception e) {
            log.error("设置key失败", e);
            return 0;
        }
    }

    /**
     * 获取集合的大小
     *
     * @param key 键
     * @return 集合的大小
     */
    public long sGetSetSize(String key) {
        try {
            return redisTemplate.opsForSet().size(key);
        } catch (Exception e) {
            log.error("获取key失败", e);
            return 0;
        }
    }

    /**
     * 从集合中删除值
     *
     * @param key    键
     * @param values 值
     * @return 删除成功的值的数量
     */
    public long setRemove(String key, Object... values) {
        try {
            return redisTemplate.opsForSet().remove(key, values);
        } catch (Exception e) {
            log.error("删除key失败", e);
            return 0;
        }
    }

// ===============================list=================================

    /**
     * 从列表中获取指定范围的元素
     *
     * @param key   Redis键
     * @param start 开始索引，从0开始
     * @param end   结束索引，如果为-1，则表示获取从start到列表的末尾
     * @return 返回指定范围内的元素列表，如果key不存在或出错则返回null
     */
    public List<Object> lGet(String key, long start, long end) {
        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            log.error("获取key失败", e);
            return null;
        }
    }

    /**
     * 获取列表的大小
     *
     * @param key Redis键
     * @return 如果key存在，则返回列表的大小；如果key不存在或出错，则返回0
     */
    public long lGetListSize(String key) {
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            log.error("获取key失败", e);
            return 0;
        }
    }

    /**
     * 根据索引获取列表中的元素
     *
     * @param key   Redis键
     * @param index 元素的索引，从0开始
     * @return 如果索引有效且key存在，则返回指定索引的元素；否则返回null
     */
    public Object lGetIndex(String key, long index) {
        try {
            return redisTemplate.opsForList().index(key, index);
        } catch (Exception e) {
            log.error("获取key失败", e);
            return null;
        }
    }

    /**
     * 向列表的尾部添加一个元素
     *
     * @param key   Redis键
     * @param value 要添加的元素
     * @return 添加成功返回true，否则返回false
     */
    public boolean lSet(String key, Object value) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e) {
            log.error("设置key失败", e);
            return false;
        }
    }

    /**
     * 向列表的尾部添加一个元素，并设置key的过期时间
     *
     * @param key   Redis键
     * @param value 要添加的元素
     * @param time  key的过期时间（秒），如果大于0，则设置过期时间
     * @return 添加成功返回true，否则返回false
     */
    public boolean lSet(String key, Object value, long time) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            log.error("设置key失败", e);
            return false;
        }
    }

    /**
     * 向列表的尾部批量添加多个元素
     *
     * @param key   Redis键
     * @param value 要添加的元素列表
     * @return 添加成功返回true，否则返回false
     */
    public boolean lSet(String key, List<Object> value) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            return true;
        } catch (Exception e) {
            log.error("设置key失败", e);
            return false;
        }
    }

    /**
     * 向列表的尾部批量添加多个元素，并设置key的过期时间
     *
     * @param key   Redis键
     * @param value 要添加的元素列表
     * @param time  key的过期时间（秒），如果大于0，则设置过期时间
     * @return 添加成功返回true，否则返回false
     */
    public boolean lSet(String key, List<Object> value, long time) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            log.error("设置key失败", e);
            return false;
        }
    }

    /**
     * 更新列表中指定索引位置的元素值
     *
     * @param key   Redis键
     * @param index 元素的索引，从0开始
     * @param value 新的元素值
     * @return 更新成功返回true，否则返回false
     */
    public boolean lUpdateIndex(String key, long index, Object value) {
        try {
            redisTemplate.opsForList().set(key, index, value);
            return true;
        } catch (Exception e) {
            log.error("设置key失败", e);
            return false;
        }
    }

    /**
     * 从列表中移除指定值的元素
     *
     * @param key   Redis键
     * @param count 要移除的数量，如果为0，则移除所有匹配的元素
     * @param value 要移除的元素值
     * @return 返回成功移除的元素数量
     */
    public long lRemove(String key, long count, Object value) {
        try {
            return redisTemplate.opsForList().remove(key, count, value);
        } catch (Exception e) {
            log.error("删除key失败", e);
            return 0;
        }
    }
}
