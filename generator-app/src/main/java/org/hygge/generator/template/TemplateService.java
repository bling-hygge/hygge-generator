package org.hygge.generator.template;

import org.hygge.generator.domain.template.TemplateAddRequest;
import org.hygge.generator.domain.template.TemplateListRequest;
import org.hygge.generator.domain.template.TemplateModifyRequest;
import org.hygge.generator.domain.common.PageVo;
import org.hygge.generator.domain.template.TemplateGetVo;
import org.hygge.generator.domain.template.TemplateListVo;

public interface TemplateService {


    TemplateGetVo templateGet(Long templateId);

    PageVo<TemplateListVo> templateList(TemplateListRequest request);

    Boolean templateModify(TemplateModifyRequest request);

    Boolean templateAddPublic(TemplateAddRequest request);

    Boolean templateAddPrivate(TemplateAddRequest request);
}