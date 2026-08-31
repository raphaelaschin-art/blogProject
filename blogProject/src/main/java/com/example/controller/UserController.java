package com.example.controller;

import com.example.common.Result;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户 Controller，提供 RESTful 风格的增删改查接口
 * 基础路径：/api/user
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 新增用户
     * POST /api/user
     * Body: {"name":"张三","password":"123456","age":20,"email":"z@qq.com","gender":1,"phone":"13800000000"}
     */
    @PostMapping("/addUser")
    public Result addUser(@RequestBody User user) {
        return userService.addUser(user) ? Result.success() : Result.error("新增失败");
    }

    /**
     * 根据 ID 删除
     * DELETE /api/user/1
     */
    @DeleteMapping("/deleteUserById/{id}")
    public Result deleteUserById(@PathVariable Integer id) {
        return userService.deleteUserById(id) ? Result.success() : Result.error("删除失败");
    }

    /**
     * 更新用户（动态更新，只改传入的字段）
     * PUT /api/user
     * Body: {"id":1,"name":"新名字","phone":"13900000000"}
     */
    @PutMapping("/updateUserById/{id}")
    public Result updateUserById(@PathVariable Integer id, @RequestBody User user) {
        // 1. 强制使用路径上的 id
        user.setId(id);

        // 2. 先判断用户是否存在
        User exist = userService.getUserById(id);
        if (exist == null) {
            return Result.error("用户不存在");
        }

        // 3. 直接更新，不管影响行数
        userService.updateUserById(user);
        return Result.success();
    }

    /**
     * 根据 ID 查询
     * GET /api/user/1
     */
    @GetMapping("/getUserById/{id}")
    public Result getUserById(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        return user != null ? Result.success(user) : Result.error("用户不存在");
    }

    /**
     * 查询全部用户
     * GET /api/user/list
     */
    @GetMapping("/list")
    public Result list() {
        List<User> list = userService.list();
        return Result.success(list);
    }

    @GetMapping("/getUserByUsername/{username}")
    public Result selectUserByUsername(@PathVariable String username) {
        User user = userService.selectUserByUsername(username);
        if (user == null) {
            return Result.noData("你寻找用户不存在！");
        }
        return Result.success(user);
    }

    @GetMapping("getUserByEmail/{email}")
    public Result selectUserByEmail(@PathVariable String email) {
        User user = userService.selectUserByEmail(email);
        if (user == null) {
            return Result.noData("你寻找用户不存在！");
        }
        return Result.success(user);
    }

    @GetMapping("getUserByPhone/{phone}")
    public Result selectUserByPhone(@PathVariable String phone) {
        User user = userService.selectUserByPhone(phone);
        if (user == null) {
            return Result.noData("你寻找用户不存在！");
        }
        return Result.success(user);
    }

}
