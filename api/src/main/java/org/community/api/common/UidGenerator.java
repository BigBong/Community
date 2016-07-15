package org.community.api.common;

import org.springframework.security.oauth2.common.util.RandomValueStringGenerator;

import java.util.UUID;

public class UidGenerator {

    private static RandomValueStringGenerator defaultClientSecretGenerator = new RandomValueStringGenerator(32);

    /**
     * private constructor
     */
    private UidGenerator() {
    }

    public static String generate() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


    public static String generateClientSecret() {
        return defaultClientSecretGenerator.generate();
    }
}