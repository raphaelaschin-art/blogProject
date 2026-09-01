package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户 Mapper 接口
 * 方法名与 UserMapper.xml 中的 id 一一对应
 */
public interface UserMapper {

    /**
     * 新增用户，useGeneratedKeys 回填自增主键到 user.id
     */
    int insertUser(User user);

    /**
     * 根据 ID 删除
     */
    int deleteUserById(@Param("id") Integer id);

    /**
     * 根据 ID 更新（动态 SQL，只更新非空字段）
     */
    int updateUser(User user);

    /**
     * 根据 ID 查询
     */
    User selectUserById(@Param("id") Integer id);

    /**
     * 查询全部
     */
    List<User> selectAllUser();

    User selectUserByUsername(@Param("username") String username);

    User selectUserByEmail(@Param("email") String email);

    User selectUserByPhone(@Param("phone") String phone);

    List<User>listByGender(@Param("gender") Integer gender);

    List<User>listLikeUsername(@Param("username") String username);

    List<User>listLikeEmail(@Param("email") String email);

    List<User>listLikePhone(@Param("phone") String phone);

    List<User> listByRole(@Param("role") Integer role);

    Integer selectRoleById(@Param("id") Integer id);

    int countByRole(@Param("role") Integer role);

}
