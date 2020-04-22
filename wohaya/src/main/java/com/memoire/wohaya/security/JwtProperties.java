package com.memoire.wohaya.security;

public class JwtProperties {
    public static final String SECRET = "AZ#47:Ddg5*";
    public static final int EXPIRATION_TIME = 864000000; //10 days in seconds
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
