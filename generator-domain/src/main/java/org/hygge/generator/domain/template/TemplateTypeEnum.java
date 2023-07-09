package org.hygge.generator.domain.template;

import lombok.Getter;

@Getter
public enum TemplateTypeEnum {
    UNKNOWN(1, "unknown", "未知类型", "enum.template.type.unknown"),
    PUBLIC(10, "public", "公共模板", "enum.template.type.public"),
    PRIVATE(20, "private", "私人模板", "enum.template.type.private"),
    ;


    private final int enumCode;

    private final String enumValue;

    private final String enumDescription;

    private final String enumI18n;

    TemplateTypeEnum(int enumCode, String enumValue, String enumDescription, String enumI18n) {
        this.enumCode = enumCode;
        this.enumValue = enumValue;
        this.enumDescription = enumDescription;
        this.enumI18n = enumI18n;
    }

    public static TemplateTypeEnum getByEnumCode(int enumCode) {
        for (TemplateTypeEnum item : TemplateTypeEnum.values()) {
            if (item.getEnumCode() == enumCode) {
                return item;
            }
        }
        return TemplateTypeEnum.UNKNOWN;
    }
}
