package com.lzy.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.Gson;
import com.lzy.common.entity.db.UserEntity;
import com.lzy.common.entity.http.HttpRequestEntity;
import com.lzy.common.entity.http.HttpResponseEntity;
import com.lzy.common.util.AESUtils;
import com.lzy.common.util.JWTProvider;
import com.lzy.common.util.RedisUtils;
import com.lzy.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
// 用户控制器，处理与用户相关的HTTP请求
@RestController
@RequestMapping("/user")
public class UserController {

    // 用户服务，用于处理用户相关的业务逻辑
    @Autowired
    private UserService userService;

    // JWT提供者，用于生成JWT令牌
    @Autowired
    private JWTProvider jwtProvider;

    // Redis工具类，用于操作Redis数据库
    @Autowired
    private RedisUtils redisUtils;

    // JWT前缀，从配置文件中获取
    @Value("${jwt.prefix}")
    private String prefix;

    // 用户登录接口
    @RequestMapping("/login")
    public HttpResponseEntity login(@RequestBody HttpRequestEntity httpRequestEntity, HttpServletResponse response) {
        // 解析请求体中的用户数据
        String json = httpRequestEntity.getData();
        UserEntity userEntity = new Gson().fromJson(json, UserEntity.class);

        // 查询用户是否存在
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userEntity.getUsername());
        UserEntity user = userService.getOne(queryWrapper);
        if (user == null) {
            return HttpResponseEntity.code404();
        }

        // 验证用户密码
        if (!user.getPassword().equals(userEntity.getPassword())) {
            return HttpResponseEntity.code401();
        }

        // 生成JWT令牌并存入Redis
        String token = jwtProvider.generateToken(user.getUsername());
        redisUtils.set(user.getUsername(), token,60*60*24);

        // 设置响应头中的Authorization字段
        response.setHeader("Authorization", prefix + token);

        // 构建响应实体并返回
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        httpResponseEntity.setCode(HttpResponseEntity.code200().getCode());
        httpResponseEntity.setData(AESUtils.encode(new Gson().toJson(user), AESUtils.KEY));
        httpResponseEntity.setMessage(HttpResponseEntity.code200().getMessage());
        return httpResponseEntity;
    }

    // 用户注册接口
    @RequestMapping("/register")
    public HttpResponseEntity register(@RequestBody HttpRequestEntity httpRequestEntity) {
        // 解析请求体中的用户数据
        String json = httpRequestEntity.getData();
        UserEntity userEntity = new Gson().fromJson(json, UserEntity.class);

        // 检查用户是否已存在
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userEntity.getUsername());
        UserEntity user = userService.getOne(queryWrapper);
        if (user != null) {
            return HttpResponseEntity.code400();
        }

        // 保存新用户
        userService.save(userEntity);

        // 构建响应实体并返回
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        httpResponseEntity.setCode(HttpResponseEntity.code200().getCode());
        httpResponseEntity.setData(AESUtils.encode(new Gson().toJson(userEntity), AESUtils.KEY));
        httpResponseEntity.setMessage(HttpResponseEntity.code200().getMessage());
        return httpResponseEntity;
    }

    // 获取用户信息接口
    @RequestMapping("/getUserInfo")
    public HttpResponseEntity getUserInfo(@RequestBody HttpRequestEntity httpRequestEntity) {
        // 解析请求体中的用户数据
        String json = httpRequestEntity.getData();
        UserEntity userEntity = new Gson().fromJson(json, UserEntity.class);

        // 查询用户信息
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userEntity.getUsername());
        UserEntity user = userService.getOne(queryWrapper);
        if (user == null) {
            return HttpResponseEntity.code404();
        }

        // 构建响应实体并返回
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        httpResponseEntity.setCode(HttpResponseEntity.code200().getCode());
        httpResponseEntity.setData(AESUtils.encode(new Gson().toJson(user), AESUtils.KEY));
        httpResponseEntity.setMessage(HttpResponseEntity.code200().getMessage());
        return httpResponseEntity;
    }

    // 更新用户信息接口
    @RequestMapping("/updateUserInfo")
    public HttpResponseEntity updateUserInfo(@RequestBody HttpRequestEntity httpRequestEntity) {
        // 解析请求体中的用户数据
        String json = httpRequestEntity.getData();
        UserEntity userEntity = new Gson().fromJson(json, UserEntity.class);

        // 查询用户是否存在
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userEntity.getUsername());
        UserEntity user = userService.getOne(queryWrapper);
        if (user == null) {
            return HttpResponseEntity.code404();
        }

        // 更新用户信息
        userService.update(userEntity, queryWrapper);

        // 构建响应实体并返回
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        httpResponseEntity.setCode(HttpResponseEntity.code200().getCode());
        httpResponseEntity.setData(AESUtils.encode(new Gson().toJson(userEntity), AESUtils.KEY));
        httpResponseEntity.setMessage(HttpResponseEntity.code200().getMessage());
        return httpResponseEntity;
    }

}

