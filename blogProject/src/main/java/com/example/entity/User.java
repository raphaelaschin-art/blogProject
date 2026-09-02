package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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

    /** 角色ID，关联 role.id */
    private Integer roleId;
    /** 账号状态 0-禁用 1-正常 */
    private Integer status;
    /** 逻辑删除标记 0-未删除 1-已删除 */
    private Integer deleted;
    /** 最后登录时间 */
    private LocalDateTime lastLoginTime;
    /** 创建时间 */
    private LocalDateTime createTime;
    /** 更新时间 */
    private LocalDateTime updateTime;
    /** 头像地址 */
    private String avatar;
}
