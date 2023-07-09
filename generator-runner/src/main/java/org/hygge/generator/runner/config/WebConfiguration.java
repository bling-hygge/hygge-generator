package org.hygge.generator.runner.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.hygge.generator.domain.common.GlobalConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
                .indentOutput(true)
                .simpleDateFormat(GlobalConstants.DATE_FORMAT)
                .timeZone(GlobalConstants.TIME_ZONE)
                .serializationInclusion(JsonInclude.Include.NON_NULL)
                .modulesToInstall(new ParameterNamesModule());
        converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
    }
}
