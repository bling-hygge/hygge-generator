package org.hygge.generator.domain.template;

import lombok.Data;

import java.util.Date;

@Data
public class TemplateDomain {
    private Long id;

    private Long templateId;

    private Integer templateTypeCode;

    private String name;

    private String content;

    private Date createTime;

    private Date updateTime;

    private Integer recordStatusCode;
}
