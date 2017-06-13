package nz.co.midori.frontend.security;

import org.springframework.beans.factory.annotation.Value;

public class Crypto{
    @Value("${crypto.algorithm}")
    public static final String ALGORITHM = "";
    @Value("${crypto.api-var}")
    public static final String KEY = "";
}