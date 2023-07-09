package org.hygge.generator.domain.template;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Schema(title = "模板详情响应视图模型")
@Data
public class TemplateGetVo {

    @Schema(title = "模板ID")
    private Long templateId;

    @Schema(title = "模板类型编码")
    private Integer templateTypeCode;

    @Schema(title = "模板类型")
    private String templateType;

    @Schema(title = "模板名称")
    private String name;

    @Schema(title = "模板创建时间")
    private Date createTime;

    @Schema(title = "模板更新时间")
    private Date updateTime;

    @Schema(title = "模板内容")
    private String content;
}
