package org.hygge.generator.domain.template;

public class UnmodifiableTemplateException extends TemplateException {

    public UnmodifiableTemplateException(Long templateId) {
        super(String.format("template(id: %s)", templateId), "template can not modify");
    }

    public UnmodifiableTemplateException(String template, String reason) {
        super(template, reason);
    }
}
