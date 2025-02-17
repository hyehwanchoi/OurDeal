package org.buy.loginservice.adapter.in.web.filter;

import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Slf4j
@Getter
@Component
public class JwtKeyProvider {

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Getter
    private SecretKey key;

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));

        log.info("key {}", this.key);
    }

}
