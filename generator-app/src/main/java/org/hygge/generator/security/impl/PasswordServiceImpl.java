package org.hygge.generator.security.impl;

import org.hygge.generator.security.PasswordService;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.regex.Pattern;

@Service
public class PasswordServiceImpl implements PasswordService {
    private final static int RANDOM_BATCH_SIZE = 256;
    private final static int MIN_LENGTH = 8;

    private final static SecureRandom secureRandom = new SecureRandom();
    private final static Pattern lowercasePattern = Pattern.compile(".*\\p{Lower}+.*");
    private final static Pattern uppercasePattern = Pattern.compile(".*\\p{Upper}+.*");
    private final static Pattern numberPattern = Pattern.compile(".*\\d+.*");
    private final static Pattern symbolPattern = Pattern.compile(".*\\p{Punct}+.*");
    private final static String PASSWORD_CHARACTER_POOL = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()+_-=}{[]|:;\"/?.><,`~";

    @Override
    public String generateRandomPassword(Integer length) {
        if (length < MIN_LENGTH) {
            throw new IllegalArgumentException("length(%s) must >= 8".formatted(length));
        }
        StringBuilder passwordBuilder = new StringBuilder();
        int randomIndex = 0;
        byte[] randomByte = new byte[RANDOM_BATCH_SIZE];
        int poolLength = PASSWORD_CHARACTER_POOL.length();
        secureRandom.nextBytes(randomByte);
        String password;
        int randomLoc;
        int tempLength;
        do {
            tempLength = length;
            while (tempLength-- > 0) {
                if (randomIndex >= randomByte.length) {
                    randomIndex = 0;
                    secureRandom.nextBytes(randomByte);
                }
                randomLoc = randomByte[randomIndex];
                randomIndex++;
                passwordBuilder.append(PASSWORD_CHARACTER_POOL.charAt(Math.abs(randomLoc) % poolLength));
            }
            password = passwordBuilder.toString();
            passwordBuilder.delete(0, length);
        } while (!lowercasePattern.matcher(password).matches() || !uppercasePattern.matcher(password).matches()
                || !numberPattern.matcher(password).matches() || !symbolPattern.matcher(password).matches());
        return password;
    }
}
