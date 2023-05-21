package org.hygge.generator.domain.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hygge.generator.domain.constants.GlobalConstants;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Schema(title = "模板列表请求模型")
@Data
public class TemplateListRequest extends PageRequest {

    @Schema(title = "模板ID列表")
    @Size(max = 20)
    private List<Long> templateIdList;

    @Schema(title = "模板名称")
    private String templateName;

    @Schema(title = "模板创建开始时间", pattern = GlobalConstants.DATE_FORMAT)
    private Date createBeginTime;

    @Schema(title = "模板创建结束时间", pattern = GlobalConstants.DATE_FORMAT)
    private Date createEndTime;

    @Schema(title = "模板更新开始时间", pattern = GlobalConstants.DATE_FORMAT)
    private Date updateBeginTime;

    @Schema(title = "模板更新结束时间", pattern = GlobalConstants.DATE_FORMAT)
    private Date updateEndTime;
}
