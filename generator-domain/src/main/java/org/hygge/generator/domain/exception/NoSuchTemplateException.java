package org.hygge.generator.domain.exception;

public class NoSuchTemplateException extends TemplateException {

    public NoSuchTemplateException(Long templateId) {
        super(String.format("template(id: %s)", templateId), "template maybe not create or be delete");
    }

    public NoSuchTemplateException(String template, String reason) {
        super(template, reason);
    }
}
