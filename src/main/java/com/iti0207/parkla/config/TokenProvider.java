package com.iti0207.parkla.config;

import com.google.gson.JsonSyntaxException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.DecodingException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Configuration
public class TokenProvider {
    private static final String AUTHORITIES_KEY = "auth";


    public Authentication getAuthentication(String token) {

        Claims claims = Jwts.parser().setSigningKey(JwtTokenProvider.key).parseClaimsJws(token).getBody();

        Collection<? extends GrantedAuthority> authorities = Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                .map(SimpleGrantedAuthority::new).collect(Collectors.toList());

        User principal = new User(claims.getSubject(), "", authorities);

        return new UsernamePasswordAuthenticationToken(principal, "", authorities);
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JwtTokenProvider.key).parseClaimsJws(authToken);
        } catch (DecodingException | SignatureException | JsonSyntaxException e) {
            return false;
        }

        return true;
    }
}
