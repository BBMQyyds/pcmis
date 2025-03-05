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

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTProvider jwtProvider;

    @Autowired
    private RedisUtils redisUtils;

    @Value("${jwt.prefix}")
    private String prefix;

    @RequestMapping("/login")
    public HttpResponseEntity login(@RequestBody HttpRequestEntity httpRequestEntity, HttpServletResponse response) {
        String json = httpRequestEntity.getData();
        UserEntity userEntity = new Gson().fromJson(json, UserEntity.class);
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userEntity.getUsername());
        UserEntity user = userService.getOne(queryWrapper);
        if (user == null) {
            return HttpResponseEntity.code404();
        }
        if (!user.getPassword().equals(userEntity.getPassword())) {
            return HttpResponseEntity.code401();
        }
        String token = jwtProvider.generateToken(user.getUsername());
        redisUtils.set(user.getUsername(), token,60*60*24);
        response.setHeader("Authorization", prefix + token);
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        httpResponseEntity.setCode(HttpResponseEntity.code200().getCode());
        httpResponseEntity.setData(AESUtils.encode(new Gson().toJson(user), AESUtils.KEY));
        httpResponseEntity.setMessage(HttpResponseEntity.code200().getMessage());
        return httpResponseEntity;
    }

    @RequestMapping("/register")
    public HttpResponseEntity register(@RequestBody HttpRequestEntity httpRequestEntity) {
        String json = httpRequestEntity.getData();
        UserEntity userEntity = new Gson().fromJson(json, UserEntity.class);
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userEntity.getUsername());
        UserEntity user = userService.getOne(queryWrapper);
        if (user != null) {
            return HttpResponseEntity.code400();
        }
        userService.save(userEntity);
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        httpResponseEntity.setCode(HttpResponseEntity.code200().getCode());
        httpResponseEntity.setData(AESUtils.encode(new Gson().toJson(userEntity), AESUtils.KEY));
        httpResponseEntity.setMessage(HttpResponseEntity.code200().getMessage());
        return httpResponseEntity;
    }

    @RequestMapping("/getUserInfo")
    public HttpResponseEntity getUserInfo(@RequestBody HttpRequestEntity httpRequestEntity) {
        String json = httpRequestEntity.getData();
        UserEntity userEntity = new Gson().fromJson(json, UserEntity.class);
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userEntity.getUsername());
        UserEntity user = userService.getOne(queryWrapper);
        if (user == null) {
            return HttpResponseEntity.code404();
        }
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        httpResponseEntity.setCode(HttpResponseEntity.code200().getCode());
        httpResponseEntity.setData(AESUtils.encode(new Gson().toJson(user), AESUtils.KEY));
        httpResponseEntity.setMessage(HttpResponseEntity.code200().getMessage());
        return httpResponseEntity;
    }

    @RequestMapping("/updateUserInfo")
    public HttpResponseEntity updateUserInfo(@RequestBody HttpRequestEntity httpRequestEntity) {
        String json = httpRequestEntity.getData();
        UserEntity userEntity = new Gson().fromJson(json, UserEntity.class);
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userEntity.getUsername());
        UserEntity user = userService.getOne(queryWrapper);
        if (user == null) {
            return HttpResponseEntity.code404();
        }
        userService.update(userEntity, queryWrapper);
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        httpResponseEntity.setCode(HttpResponseEntity.code200().getCode());
        httpResponseEntity.setData(AESUtils.encode(new Gson().toJson(userEntity), AESUtils.KEY));
        httpResponseEntity.setMessage(HttpResponseEntity.code200().getMessage());
        return httpResponseEntity;
    }

}
