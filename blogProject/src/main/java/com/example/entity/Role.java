package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 角色实体类，对应数据库 blog_db.role 表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    /** 角色ID */
    private Integer id;

    /** 角色名称，如：管理员、普通用户 */
    private String roleName;

    /** 角色编码，如：ADMIN、USER，用于权限判断 */
    private String roleCode;

    /** 角色描述 */
    private String description;

    /** 创建时间 */
    private LocalDateTime createTime;
}
