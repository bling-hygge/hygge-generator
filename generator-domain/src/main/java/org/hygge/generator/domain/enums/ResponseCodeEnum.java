package org.hygge.generator.domain.enums;

import lombok.Getter;

@Getter
public enum ResponseCodeEnum {
    SUCCESS(200, "success", "成功", "enum.response.code.success"),
    FAIL(400, "fail", "失败", "enum.response.code.fail"),
    ;


    private final int enumCode;

    private final String enumValue;

    private final String enumDescription;

    private final String enumI18n;

    ResponseCodeEnum(int enumCode, String enumValue, String enumDescription, String enumI18n) {
        this.enumCode = enumCode;
        this.enumValue = enumValue;
        this.enumDescription = enumDescription;
        this.enumI18n = enumI18n;
    }
}
