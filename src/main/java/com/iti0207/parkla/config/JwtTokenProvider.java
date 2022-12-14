package com.iti0207.parkla.config;

import java.security.Key;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public class JwtTokenProvider {
    private static final byte[] keyBytes = Decoders.BASE64
            .decode("d9d37aa3a148a5e588f9f07f6129963d744172c144dc238c4d8bb4b31208e1cb=");
    public static final Key key = Keys.hmacShaKeyFor(keyBytes);

}


