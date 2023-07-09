package org.hygge.generator.domain.template;

import org.hygge.generator.domain.common.PageVo;

public interface TemplateDataService {

    TemplateDomain templateGet(Long templateId);

    PageVo<TemplateDomain> templateList(TemplateListRequest request);

    Boolean templateAdd(TemplateAddRequest request);

    Boolean templateModify(TemplateModifyRequest request);
}
