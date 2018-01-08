package person.cznno.zero.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import person.cznno.zero.admin.entity.RolePermissionEntity;
import person.cznno.zero.admin.entity.UserEntity;
import person.cznno.zero.admin.service.UserService;
import person.cznno.zero.base.factory.BaseResponseFactory;
import person.cznno.zero.base.model.response.Response;

/**
 * 用户CRUD
 * Created by cznno
 * Date: 17-12-28
 */
@Slf4j
@RestController
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    //    @RequiresPermissions("article:list")
    @GetMapping
    public Response getAll(UserEntity entity) {
        return BaseResponseFactory.get(userService.selectAll(entity));
    }

    @GetMapping("/{id}")
    public Response get(@PathVariable Integer id) {
        return BaseResponseFactory.get(userService.selectById(id));
    }

    @PostMapping
    public Response insertUser(@RequestBody UserEntity entity) {
        return BaseResponseFactory.get(userService.insertSelective(entity));
    }

    @PutMapping
    public Response updateById(@RequestBody UserEntity entity) {
        return BaseResponseFactory.get(userService.updateByIdSelective(entity));
    }

    @DeleteMapping("/{id}")
    public Response deleteById(@PathVariable Integer id) {
        return BaseResponseFactory.get(userService.deleteById(id));
    }
}
