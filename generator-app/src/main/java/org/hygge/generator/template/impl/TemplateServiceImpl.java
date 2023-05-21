package org.hygge.generator.template.impl;

import org.hygge.generator.domain.exception.NoSuchTemplateException;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TemplateServiceImpl implements TemplateService {

    private final TemplateDataService templateDataService;


    public TemplateServiceImpl(TemplateDataService templateDataService) {
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
            listVoTemp.setName(item.getName());
            listVoTemp.setCreateTime(item.getCreateTime());
            listVoTemp.setUpdateTime(item.getUpdateTime());
            templateListVoList.add(listVoTemp);
        }
        pageVo.setDataList(templateListVoList);
        return pageVo;
    }

    @Override
    public Boolean templateAdd(TemplateAddRequest request) {
        return templateDataService.templateAdd(request);
    }

    @Override
    public Boolean templateModify(TemplateModifyRequest request) {
        TemplateDomain templateDomain = templateDataService.templateGet(request.getTemplateId());
        if (Objects.isNull(templateDomain)) {
            throw new NoSuchTemplateException(request.getTemplateId());
        }
        return templateDataService.templateModify(request);
    }
}
