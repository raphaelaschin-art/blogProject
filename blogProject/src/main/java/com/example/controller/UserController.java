package com.example.controller;

import com.example.common.Result;
import com.example.entity.User;
import com.example.enums.UserRole;
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
        //后端手动判空
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            return Result.error("用户名不能为空！");
        }
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            return Result.error("邮箱不能为空！");
        }
        if (user.getPhone() == null || user.getPhone().trim().isEmpty()) {
            return Result.error("电话不能为空！");
        }
        //简单邮箱格式校验
        if (!user.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            return Result.error("邮箱格式错误！");
        }
        // 1. 先判断用户名和电邮是否已存在（冲突）
        if (userService.existsByUsername(user.getUsername())) {
            return Result.error("用户名已存在，请更换！");
        }

        if (userService.existsByEmail(user.getEmail())) {
            return Result.error("该电邮已被使用，请更换！");
        }
        if (userService.existsByPhone(user.getEmail())) {
            return Result.error("该电话已被使用，请更换！");
        }
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
        User exist = userService.selectUserById(id);
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
    @GetMapping("/selectUserById/{id}")
    public Result selectUserById(@PathVariable Integer id) {
        User user = userService.selectUserById(id);
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

    @GetMapping("listByGender/{gender}")
    public Result listByGender(@PathVariable Integer gender) {
        List<User> list = userService.listByGender(gender);
        if (list == null || list.isEmpty()) {
            return Result.noData("你寻找用户不存在！");
        }
        return Result.success(list);
    }

    @GetMapping("listLikeUsername/{username}")
    public Result listLikeUsername(@PathVariable String username) {
        List<User> list = userService.listLikeUsername(username);
        if (list == null || list.isEmpty()) {
            return Result.noData("你寻找用户不存在！");
        }
        return Result.success(list);
    }

    @GetMapping("listLikeEmail/{email}")
    public Result listLikeEmail(@PathVariable String email) {
        List<User> list = userService.listLikeEmail(email);
        if (list == null || list.isEmpty()) {
            return Result.noData("你寻找用户不存在！");
        }
        return Result.success(list);
    }

    @GetMapping("/listLikePhone/{phone}")
    public Result listLikePhone(@PathVariable String phone) {
        List<User> list = userService.listLikePhone(phone);
        if (phone == null || phone.trim().isEmpty()) {
            return Result.noData("请输入手机号进行搜索");
        }
        if (list == null || list.isEmpty()) {
            return Result.noData("你寻找用户不存在！");
        }
        return Result.success(list);
    }

    @GetMapping("/listByRole/{role}")
    public Result listByRole(@PathVariable Integer role) {
        List<User> list = userService.listByRole(role);
        if (list == null || list.isEmpty()) {
            return Result.noData("你寻找用户不存在！");

        }
        return Result.success(list);
    }

    @GetMapping("selectRoleById/{id}")
    public Result selectRoleById(@PathVariable Integer id) {
        Integer role = userService.selectRoleById(id);
        return role != null ? Result.success(role) : Result.noData("用户不存在！");
    }

    @GetMapping("/countByRole/{role}")
    public Result countByRole(@PathVariable Integer role) {
        Integer count = userService.countByRole(role);
        if (!UserRole.isValid(role)) {
            return Result.error("角色参数不合法！");
        }
        String message = "您找到的角色用户有 " + count + " 个";
        return Result.success(message);
    }


}
