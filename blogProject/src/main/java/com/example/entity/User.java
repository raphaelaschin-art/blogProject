package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户实体类，对应数据库 blog_db.user 表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /** 主键ID */
    private int id;

    /** 用户名 */
    private String username;

    /** 密码 */
    private String password;

    /** 年龄 */
    private Integer age;

    /** 邮箱 */
    private String email;

    /** 性别 0-不显示 1-男 2-女 */
    private Integer gender;

    /** 手机号 */
    private String phone;

    private Integer role;
}
