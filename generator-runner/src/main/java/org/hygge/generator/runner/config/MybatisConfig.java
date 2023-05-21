package org.hygge.generator.runner.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan(basePackages = {"org.hygge.generator.infrastructure.mapper"})
@Configuration
public class MybatisConfig {
}
