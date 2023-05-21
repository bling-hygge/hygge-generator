package org.hygge.generator.runner.config;

import lombok.extern.slf4j.Slf4j;
import org.hygge.generator.domain.constants.GlobalConstants;
import org.hygge.generator.domain.exception.GeneratorException;
import org.hygge.generator.domain.response.Response;
import org.springframework.context.annotation.Profile;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @Profile(GlobalConstants.ACTIVE_INTEGRATION)
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public Response<Object> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
        return Response.fail(exception.getMessage());
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public Response<Object> illegalArgumentExceptionHandle(IllegalArgumentException exception) {
        return Response.fail(exception.getMessage());
    }

    @ExceptionHandler(value = GeneratorException.class)
    public Response<Object> generatorExceptionHandle(GeneratorException exception) {
        return Response.fail(exception.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public Response<Object> exceptionHandle(Exception exception) {
        log.info("", exception);
        return Response.fail("please try again later");
    }
}