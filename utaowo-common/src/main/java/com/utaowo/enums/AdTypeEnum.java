package com.utaowo.enums;

public enum AdTypeEnum {

    BANNER_IMG(1, "轮播图"),

    SCROLL_BAR(2, "滚动条");

    // 枚举值
    private final int key;

    // 枚举描述
    private final String desc;

    AdTypeEnum(int key, String desc ) {
        this.key = key;
        this.desc = desc;
    }

    public int key() {
        return key;
    }

    public String desc() {
        return desc;
    }
}
