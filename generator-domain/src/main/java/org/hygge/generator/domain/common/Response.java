package org.hygge.generator.domain.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(title = "基础响应模型")
public class Response<T> {

    @Schema(title = "业务响应码")
    private Integer code;

    @Schema(title = "业务响应信息")
    private String message;

    @Schema(title = "业务响应业务模型")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private T data;

    public static <T> Response<T> success(T data) {
        return Response.<T>builder()
                .code(ResponseCodeEnum.SUCCESS.getEnumCode())
                .message(ResponseCodeEnum.SUCCESS.getEnumDescription())
                .data(data)
                .build();
    }

    public static <T> Response<T> fail(String message) {
        return Response.<T>builder()
                .code(ResponseCodeEnum.FAIL.getEnumCode())
                .message(message)
                .build();
    }
}
