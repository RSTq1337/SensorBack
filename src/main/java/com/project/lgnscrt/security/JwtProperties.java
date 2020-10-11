package com.project.lgnscrt.security;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class JwtProperties {
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String SECRET = "MySecret";
    public static final int EXPIRATION_TIME = 7200000;

}
