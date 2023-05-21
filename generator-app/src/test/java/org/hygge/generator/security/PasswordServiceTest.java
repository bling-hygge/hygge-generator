package org.hygge.generator.security;

import org.hygge.generator.security.impl.PasswordServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PasswordServiceTest {
    @InjectMocks
    private PasswordServiceImpl passwordService;

    @Test
    void test_password_fail_with_length_less_than_8() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> passwordService.generateRandomPassword(6));
        assertEquals("length(6) must >= 8", exception.getMessage());
    }

    @Test
    void test_password_success() {
        String password = passwordService.generateRandomPassword(10);
        assertEquals(password.length(), 10);
        assertLinesMatch(new ArrayList<>() {{
            add(".*\\p{Lower}+.*");
            add(".*\\p{Upper}+.*");
            add(".*\\d+.*");
            add(".*\\p{Punct}+.*");
        }}, new ArrayList<>() {{
            add(password);
            add(password);
            add(password);
            add(password);
        }});
    }
}
