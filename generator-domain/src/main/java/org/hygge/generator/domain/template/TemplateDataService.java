package org.hygge.generator.domain.template;

import org.hygge.generator.domain.request.TemplateAddRequest;
import org.hygge.generator.domain.request.TemplateListRequest;
import org.hygge.generator.domain.request.TemplateModifyRequest;
import org.hygge.generator.domain.vo.PageVo;

public interface TemplateDataService {

    TemplateDomain templateGet(Long templateId);

    PageVo<TemplateDomain> templateList(TemplateListRequest request);

    Boolean templateAdd(TemplateAddRequest request);

    Boolean templateModify(TemplateModifyRequest request);
}
