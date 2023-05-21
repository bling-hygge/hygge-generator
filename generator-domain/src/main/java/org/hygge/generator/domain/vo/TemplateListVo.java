package org.hygge.generator.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hygge.generator.domain.constants.GlobalConstants;

import java.util.Date;

@Schema(title = "模板列表响应视图模型")
@Data
public class TemplateListVo {

    @Schema(title = "模板ID")
    private Long templateId;

    @Schema(title = "模板名称")
    private String name;

    @Schema(title = "模板创建时间", pattern = GlobalConstants.DATE_FORMAT)
    private Date createTime;

    @Schema(title = "模板更新时间", pattern = GlobalConstants.DATE_FORMAT)
    private Date updateTime;
}
