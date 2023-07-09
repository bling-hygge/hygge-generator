package org.hygge.generator.runner.config;

import org.hygge.generator.domain.common.GlobalConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.Arrays;
import java.util.HashMap;

public class GlobalSwitchByProcessorConfig implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        String[] activeProfileArray = environment.getActiveProfiles();
        if (Arrays.stream(activeProfileArray).noneMatch(s -> s.equals(GlobalConstants.ACTIVE_INTEGRATION))) {
            environment.getPropertySources().addFirst(new MapPropertySource("swagger-switch", new HashMap<>() {{
                put("springdoc.swagger-ui.enabled", "false");
                put("springdoc.api-docs.enabled", "false");
            }}));
        }
    }
}
