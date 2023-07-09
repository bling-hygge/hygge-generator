package org.hygge.generator.code.impl;

import org.hygge.generator.code.CodeService;
import org.hygge.generator.domain.common.GlobalConstants;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;

import java.util.HashMap;
import java.util.Locale;

@Service
public class CodeServiceImpl implements CodeService {
    private final TemplateEngine templateEngine;

    public CodeServiceImpl(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }


    @Override
    public String preview(Long templateId) {
        IContext context = new Context(Locale.CHINA, new HashMap<>());
        return templateEngine.process(GlobalConstants.DATABASE_TEMPLATE_RESOLVER_PATTERN + templateId, context);
    }
}
