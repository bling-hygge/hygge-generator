package org.hygge.generator.infrastructure.dataservice;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.hygge.generator.domain.request.TemplateAddRequest;
import org.hygge.generator.domain.request.TemplateListRequest;
import org.hygge.generator.domain.request.TemplateModifyRequest;
import org.hygge.generator.domain.template.TemplateDataService;
import org.hygge.generator.domain.template.TemplateDomain;
import org.hygge.generator.domain.vo.PageVo;
import org.hygge.generator.infrastructure.mapper.TemplateMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TemplateDataServiceImpl implements TemplateDataService {
    private final TemplateMapper templateMapper;

    public TemplateDataServiceImpl(TemplateMapper templateMapper) {
        this.templateMapper = templateMapper;
    }

    @Override
    public TemplateDomain templateGet(Long templateId) {
        return templateMapper.findOne(templateId);
    }

    @Override
    public PageVo<TemplateDomain> templateList(TemplateListRequest request) {
        IPage<TemplateDomain> page = Page.of(request.getPageNo(), request.getPageSize());
        page = templateMapper.findAllWithPage(page, request.getTemplateIdList(), request.getTemplateName(), request.getCreateBeginTime(), request.getCreateEndTime(), request.getUpdateBeginTime(), request.getUpdateEndTime());
        PageVo<TemplateDomain> pageVo = new PageVo<>();
        pageVo.setTotalCount(page.getTotal());
        pageVo.setTotalPageNum(page.getPages());
        pageVo.setCurrentPageNo(page.getCurrent());
        pageVo.setCurrentPageSize(page.getSize());
        pageVo.setCurrentCount((long) page.getRecords().size());
        pageVo.setDataList(page.getRecords());
        return pageVo;
    }

    @Override
    public Boolean templateAdd(TemplateAddRequest request) {
        TemplateDomain templateDomain = new TemplateDomain();
        templateDomain.setTemplateId(new Date().getTime());
        templateDomain.setName(request.getName());
        templateDomain.setCreateTime(new Date());
        templateDomain.setUpdateTime(new Date());
        templateDomain.setContent(request.getContent());
        return 1L == templateMapper.templateInsert(templateDomain);
    }

    @Override
    public Boolean templateModify(TemplateModifyRequest request) {
        TemplateDomain templateDomain = new TemplateDomain();
        templateDomain.setTemplateId(request.getTemplateId());
        templateDomain.setName(request.getName());
        templateDomain.setUpdateTime(new Date());
        templateDomain.setContent(request.getContent());
        return 1L == templateMapper.templateUpdate(templateDomain);
    }
}
