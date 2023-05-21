package org.hygge.generator.template;

import org.hygge.generator.domain.request.TemplateAddRequest;
import org.hygge.generator.domain.request.TemplateListRequest;
import org.hygge.generator.domain.request.TemplateModifyRequest;
import org.hygge.generator.domain.vo.PageVo;
import org.hygge.generator.domain.vo.TemplateGetVo;
import org.hygge.generator.domain.vo.TemplateListVo;

public interface TemplateService {


    TemplateGetVo templateGet(Long templateId);

    PageVo<TemplateListVo> templateList(TemplateListRequest request);

    Boolean templateModify(TemplateModifyRequest request);

    Boolean templateAddPublic(TemplateAddRequest request);

    Boolean templateAddPrivate(TemplateAddRequest request);
}