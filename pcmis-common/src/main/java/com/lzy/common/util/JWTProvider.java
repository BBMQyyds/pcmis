package com.lzy.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            log.error("JWT格式验证失败:{}", token);
        }
        return claims;
    }

    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setSubject(claims.get("CLAIM_KEY_USERNAME").toString())
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    private Date generateExpirationDate() {
        // 向后推7天
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

}


