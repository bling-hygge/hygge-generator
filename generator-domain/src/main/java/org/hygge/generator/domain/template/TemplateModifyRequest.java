package org.hygge.generator.domain.template;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(title = "新增模板请求模型")
@Data
public class TemplateModifyRequest {

    @Schema(title = "模板ID")
    @NotNull
    private Long templateId;

    @Schema(title = "模板名称")
    @NotEmpty
    private String name;

    @Schema(title = "模板内容")
    private String content;
}
