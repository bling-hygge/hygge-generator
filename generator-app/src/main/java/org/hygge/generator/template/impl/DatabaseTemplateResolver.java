package org.hygge.generator.template.impl;

import org.hygge.generator.domain.constants.GlobalConstants;
import org.hygge.generator.domain.exception.NoSuchTemplateException;
import org.hygge.generator.domain.template.TemplateDataService;
import org.hygge.generator.domain.template.TemplateDomain;
import org.springframework.stereotype.Component;
import org.thymeleaf.IEngineConfiguration;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.StringTemplateResolver;
import org.thymeleaf.templateresource.ITemplateResource;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

@Component
public class DatabaseTemplateResolver extends StringTemplateResolver {

    private final TemplateDataService templateDataService;

    public DatabaseTemplateResolver(TemplateDataService templateDataService) {
        this.templateDataService = templateDataService;
        this.setTemplateMode(TemplateMode.TEXT);
        this.setResolvablePatterns(Collections.singleton(GlobalConstants.DATABASE_TEMPLATE_RESOLVER_PATTERN + "*"));
        this.setCacheTTLMs(5 * 60 * 1000L);
        this.setCacheable(true);
    }

    @Override
    protected ITemplateResource computeTemplateResource(IEngineConfiguration configuration, String ownerTemplate, String template, Map<String, Object> templateResolutionAttributes) {
        long templateId = Long.parseLong(template.replaceFirst(GlobalConstants.DATABASE_TEMPLATE_RESOLVER_PATTERN, ""));
        TemplateDomain templateDomain = templateDataService.templateGet(templateId);
        if (Objects.isNull(templateDomain)) {
            throw new NoSuchTemplateException(templateId);
        }
        return super.computeTemplateResource(configuration, ownerTemplate, templateDomain.getContent(), templateResolutionAttributes);
    }
}
