package br.com.zupedu.olucas.mlivre.security;

public class SecurityConstants {
    public static final String SECRET = "90dba4d60ea4a564c83f724563bb5c81";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/api/users";
}
