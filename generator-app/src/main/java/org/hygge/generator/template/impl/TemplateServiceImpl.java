package org.hygge.generator.template.impl;

import org.hygge.generator.domain.constants.GlobalConstants;
import org.hygge.generator.domain.enums.TemplateTypeEnum;
import org.hygge.generator.domain.exception.NoSuchTemplateException;
import org.hygge.generator.domain.exception.UnmodifiableTemplateException;
import org.hygge.generator.domain.request.TemplateAddRequest;
import org.hygge.generator.domain.request.TemplateListRequest;
import org.hygge.generator.domain.request.TemplateModifyRequest;
import org.hygge.generator.domain.template.TemplateDataService;
import org.hygge.generator.domain.template.TemplateDomain;
import org.hygge.generator.domain.vo.PageVo;
import org.hygge.generator.domain.vo.TemplateGetVo;
import org.hygge.generator.domain.vo.TemplateListVo;
import org.hygge.generator.template.TemplateService;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TemplateServiceImpl implements TemplateService {

    private final TemplateEngine templateEngine;

    private final TemplateDataService templateDataService;


    public TemplateServiceImpl(TemplateEngine templateEngine, TemplateDataService templateDataService) {
        this.templateEngine = templateEngine;
        this.templateDataService = templateDataService;
    }

    @Override
    public TemplateGetVo templateGet(Long templateId) {
        TemplateDomain templateDomain = templateDataService.templateGet(templateId);
        if (Objects.isNull(templateDomain)) {
            throw new NoSuchTemplateException(templateId);
        }
        TemplateGetVo templateGetVo = new TemplateGetVo();
        templateGetVo.setTemplateId(templateDomain.getTemplateId());
        templateGetVo.setTemplateTypeCode(templateDomain.getTemplateTypeCode());
        templateGetVo.setTemplateType(TemplateTypeEnum.getByEnumCode(templateDomain.getTemplateTypeCode()).getEnumDescription());
        templateGetVo.setName(templateDomain.getName());
        templateGetVo.setContent(templateDomain.getContent());
        return templateGetVo;
    }

    @Override
    public PageVo<TemplateListVo> templateList(TemplateListRequest request) {
        PageVo<TemplateDomain> templateDomainPageVo = templateDataService.templateList(request);
        PageVo<TemplateListVo> pageVo = new PageVo<>();
        pageVo.setTotalCount(templateDomainPageVo.getTotalCount());
        pageVo.setTotalPageNum(templateDomainPageVo.getTotalPageNum());
        pageVo.setCurrentPageNo(templateDomainPageVo.getCurrentPageNo());
        pageVo.setCurrentPageSize(templateDomainPageVo.getCurrentPageSize());
        pageVo.setCurrentCount(templateDomainPageVo.getCurrentCount());
        TemplateListVo listVoTemp;
        List<TemplateListVo> templateListVoList = new ArrayList<>(templateDomainPageVo.getDataList().size());
        for (TemplateDomain item : templateDomainPageVo.getDataList()) {
            listVoTemp = new TemplateListVo();
            listVoTemp.setTemplateId(item.getTemplateId());
            listVoTemp.setTemplateTypeCode(item.getTemplateTypeCode());
            listVoTemp.setTemplateType(TemplateTypeEnum.getByEnumCode(item.getTemplateTypeCode()).getEnumDescription());
            listVoTemp.setName(item.getName());
            listVoTemp.setCreateTime(item.getCreateTime());
            listVoTemp.setUpdateTime(item.getUpdateTime());
            templateListVoList.add(listVoTemp);
        }
        pageVo.setDataList(templateListVoList);
        return pageVo;
    }

    @Override
    public Boolean templateAddPublic(TemplateAddRequest request) {
        request.setTemplateTypeCode(TemplateTypeEnum.PUBLIC.getEnumCode());
        return templateDataService.templateAdd(request);
    }

    @Override
    public Boolean templateAddPrivate(TemplateAddRequest request) {
        request.setTemplateTypeCode(TemplateTypeEnum.PRIVATE.getEnumCode());
        return templateDataService.templateAdd(request);
    }

    @Override
    public Boolean templateModify(TemplateModifyRequest request) {
        TemplateDomain templateDomain = templateDataService.templateGet(request.getTemplateId());
        if (Objects.isNull(templateDomain)) {
            throw new NoSuchTemplateException(request.getTemplateId());
        }
        if (TemplateTypeEnum.PUBLIC.getEnumCode() == templateDomain.getTemplateTypeCode()) {
            throw new UnmodifiableTemplateException(request.getTemplateId());
        }
        Boolean result = templateDataService.templateModify(request);
        if (result) {
            templateEngine.clearTemplateCacheFor(GlobalConstants.DATABASE_TEMPLATE_RESOLVER_PATTERN + request.getTemplateId());
        }
        return result;
    }
}
