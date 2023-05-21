package org.hygge.generator.domain.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Schema(title = "新增模板请求模型")
@Data
public class TemplateAddRequest {

    @Schema(title = "模板类型编码", hidden = true)
    private Integer templateTypeCode;

    @Schema(title = "模板名称")
    @NotEmpty
    private String name;

    @Schema(title = "模板内容")
    private String content;
}
