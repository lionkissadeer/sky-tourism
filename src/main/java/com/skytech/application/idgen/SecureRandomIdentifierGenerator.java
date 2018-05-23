package com.skytech.application.idgen;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

/**
 * Created by Lianhong_ on 2018/05/18 15:01
 */
@Component(value = "identityGenerator")
public class SecureRandomIdentifierGenerator implements IdentityGenerator{

    private static SecureRandom random = new SecureRandom();

    public static String gen() {
        return Long.toHexString(random.nextLong());
    }

    @Override
    public String generate() {
        return Long.toHexString(random.nextLong());
    }

}
