package com.example.enums;   // 建议放在 enums 包下

/**
 * 用户角色枚举
 */
public enum UserRole {
    NORMAL(0, "普通用户"),
    ADMIN(1, "管理员");

    private final int code;
    private final String desc;

    UserRole(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    /**
     * 判断角色值是否合法
     */
    public static boolean isValid(Integer code) {
        if (code == null) {
            return false;
        }
        for (UserRole role : values()) {
            if (role.code == code) {
                return true;
            }
        }
        return false;
    }
}