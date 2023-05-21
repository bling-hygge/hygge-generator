package org.hygge.generator.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(title = "基础分页响应视图")
@Data
public class PageVo<T> {

    @Schema(title = "总页数")
    private Long totalPageNum;

    @Schema(title = "记录总数")
    private Long totalCount;

    @Schema(title = "当前页数")
    private Long currentPageNo;

    @Schema(title = "当前页大小")
    private Long currentPageSize;

    @Schema(title = "当前页记录数")
    private Long currentCount;

    @Schema(title = "数据列表")
    private List<T> dataList;
}
