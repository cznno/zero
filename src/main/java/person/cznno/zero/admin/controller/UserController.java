package person.cznno.zero.admin.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import person.cznno.zero.admin.entity.UserEntity;
import person.cznno.zero.admin.service.UserService;
import person.cznno.zero.base.dto.response.Response;
import person.cznno.zero.base.enums.CrudStatusEnum;
import person.cznno.zero.base.factory.CrudResponseFactory;
import person.cznno.zero.base.factory.PagedResponseFactory;

/**
 * 用户CRUD
 * Created by cznno
 * Date: 17-12-28
 */
@RestController
@RequestMapping("/admin/user")
@RequiresRoles("admin")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询全部用户
     *
     * @param entity 分页参数
     * @return 用户分页信息
     */
    //    @RequiresPermissions("article:list")
    @GetMapping
    public Response getAll(UserEntity entity) {
        return PagedResponseFactory.get(userService.selectAll(entity));
    }

    /**
     * 按id查询用户
     *
     * @param id 主键
     * @return 用户实体
     */
    @GetMapping("/{id}")
    public Response get(@PathVariable Integer id) {
        return CrudResponseFactory.get(CrudStatusEnum.SELECT, userService.selectById(id));
    }

    /**
     * 新增用户
     *
     * @param entity 用户实体
     * @return 新增的条数
     */
    @PostMapping
    public Response insertUser(@RequestBody UserEntity entity) {
        return CrudResponseFactory.get(CrudStatusEnum.INSERT, userService.insertSelective(entity));
    }

    /**
     * 更新用户
     *
     * @param entity 用户实体
     * @return 更新的条数
     */
    @PutMapping
    public Response updateById(@RequestBody UserEntity entity) {
        return CrudResponseFactory.get(CrudStatusEnum.UPDATE, userService.updateByIdSelective(entity));
    }

    /**
     * 按id删除用户
     *
     * @param id 主键
     * @return 删除的条数
     */
    @DeleteMapping("/{id}")
    public Response deleteById(@PathVariable Integer id) {
        return CrudResponseFactory.get(CrudStatusEnum.DELETE, userService.deleteById(id));
    }
}
