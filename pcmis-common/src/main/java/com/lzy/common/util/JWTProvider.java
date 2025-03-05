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

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public static void main(String[] args) {
        Date date = new Date(System.currentTimeMillis() + 604800 * 1000);
        String s = LocalDateUtils.dateToString(date, "yyyy-MM-dd HH:mm:ss");
        log.info("{}", s);
    }

    public String generateToken(String userName) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("CLAIM_KEY_USERNAME", userName);
        claims.put("CLAIM_KEY_CREATED", new Date());
        return generateToken(claims);
    }

    public String getUserNameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFormToken(token);
//            username = claims.getSubject();
            username = claims.get("CLAIM_KEY_USERNAME").toString();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    public boolean validateToken(String token, String userName) {
        String username = getUserNameFromToken(token);
        return username.equals(userName) && isTokenExpired(token);
    }

    public boolean canRefresh(String token) {
        return isTokenExpired(token);
    }

    public String refreshToken(String token) {
        Claims claims = getClaimsFormToken(token);
        claims.put("CLAIM_KEY_CREATED", new Date());
        return generateToken(claims);
    }

    private boolean isTokenExpired(String token) {
        Date expireDate = getExpiredDateFromToken(token);
        return !expireDate.before(new Date());
    }

    public Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFormToken(token);
        return claims.getExpiration();
    }

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

    private String generateToken(Map<String, Object> claims) {
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .claims(claims)
                .subject(claims.get("CLAIM_KEY_USERNAME").toString())
                .expiration(generateExpirationDate())
                .signWith(key)
                .compact();
    }

    private Date generateExpirationDate() {
        // 向后推7天
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

}


