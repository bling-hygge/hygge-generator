package org.hygge.generator.domain.exception;

import lombok.Getter;

import java.util.Objects;

public class TemplateException extends GeneratorException {
    @Getter
    private final String template;

    public TemplateException(String template) {
        super((String) null);
        this.template = template;
    }

    public TemplateException(String template, String reason) {
        super(reason);
        this.template = template;
    }

    public String getReason() {
        return super.getMessage();
    }

    @Override
    public String getMessage() {
        if (Objects.isNull(this.template)) {
            return this.getReason();
        }
        StringBuilder sb = new StringBuilder(this.template);
        if (this.getReason() != null) {
            sb.append(": ");
            sb.append(this.getReason());
        }
        return sb.toString();
    }
}
