package com.example.security.springsecurity;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

public class JwtUtils {
    private String jwtSecret = "a-string-secret-at-least-256-bits-long";
    private int jwtExpirationMs=172800000;

    public String generateJwtFromHeader(){
        return "";
    }
    public String generateTokenFromUserName(String userName){
        return Jwts.builder()
                .subject(userName)
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime()+jwtExpirationMs))
                .signWith(key())
                .compact();
    }

    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public boolean validateJwtToken(){
        return true;
    }
}
