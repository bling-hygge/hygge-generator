package org.hygge.generator.domain.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class PageRequest {

    @Schema(title = "页码")
    @Min(value = 1)
    private Long pageNo;

    @Schema(title = "页大小")
    @Min(value = 1)
    @Max(value = 100)
    private Long pageSize;
}
