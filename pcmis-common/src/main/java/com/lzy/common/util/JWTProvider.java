package com.lzy.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Component
@Slf4j
public class JWTProvider {

    // 从配置文件中注入JWT密钥
    @Value("${jwt.secret}")
    private String secret;

    // 从配置文件中注入JWT过期时间
    @Value("${jwt.expiration}")
    private Long expiration;

    // 主函数用于测试JWT生成和解析功能
    public static void main(String[] args) {
        Date date = new Date(System.currentTimeMillis() + 604800 * 1000);
        String s = LocalDateUtils.dateToString(date, "yyyy-MM-dd HH:mm:ss");
        log.info("{}", s);
    }

    /**
     * 生成JWT令牌
     * @param userName 用户名，用于生成令牌的用户名
     * @return 生成的JWT令牌
     */
    public String generateToken(String userName) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("CLAIM_KEY_USERNAME", userName);
        claims.put("CLAIM_KEY_CREATED", new Date());
        return generateToken(claims);
    }

    /**
     * 从令牌中获取用户名
     * @param token JWT令牌
     * @return 令牌中的用户名，如果解析失败则返回null
     */
    public String getUserNameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFormToken(token);
            username = claims.get("CLAIM_KEY_USERNAME").toString();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * 验证令牌是否有效
     * @param token JWT令牌
     * @param userName 从请求或其他方式获取的用户名，用于和令牌中的用户名对比
     * @return 如果令牌有效且未过期则返回true，否则返回false
     */
    public boolean validateToken(String token, String userName) {
        String username = getUserNameFromToken(token);
        return username.equals(userName) && isTokenExpired(token);
    }

    /**
     * 检查令牌是否可以刷新
     * @param token JWT令牌
     * @return 如果令牌未过期则返回true，否则返回false
     */
    public boolean canRefresh(String token) {
        return isTokenExpired(token);
    }

    /**
     * 刷新令牌
     * @param token 原始JWT令牌
     * @return 刷新后的JWT令牌
     */
    public String refreshToken(String token) {
        Claims claims = getClaimsFormToken(token);
        claims.put("CLAIM_KEY_CREATED", new Date());
        return generateToken(claims);
    }

    /**
     * 检查令牌是否过期
     * @param token JWT令牌
     * @return 如果令牌过期则返回true，否则返回false
     */
    private boolean isTokenExpired(String token) {
        Date expireDate = getExpiredDateFromToken(token);
        return !expireDate.before(new Date());
    }

    /**
     * 从令牌中获取过期日期
     * @param token JWT令牌
     * @return 令牌的过期日期
     */
    public Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFormToken(token);
        return claims.getExpiration();
    }

    /**
     * 从令牌中获取声明
     * @param token JWT令牌
     * @return 解析后的声明，如果解析失败则返回null
     */
    private Claims getClaimsFormToken(String token) {
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        try {
            return Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (Exception e) {
            log.error("JWT格式验证失败:{}", token, e);
            return null;
        }
    }

    /**
     * 生成JWT令牌
     * @param claims JWT中的声明
     * @return 生成的JWT令牌
     */
    private String generateToken(Map<String, Object> claims) {
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .claims(claims)
                .subject(claims.get("CLAIM_KEY_USERNAME").toString())
                .expiration(generateExpirationDate())
                .signWith(key)
                .compact();
    }

    /**
     * 生成令牌的过期日期
     * @return 令牌的过期日期，这里设置为当前时间向后推7天
     */
    private Date generateExpirationDate() {
        // 向后推7天
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

}
