package person.cznno.zero.admin.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import person.cznno.zero.admin.entity.UserRoleEntity;
import person.cznno.zero.admin.service.UserRoleService;
import person.cznno.zero.base.dto.response.Response;
import person.cznno.zero.base.enums.CrudStatusEnum;
import person.cznno.zero.base.factory.CrudResponseFactory;
import person.cznno.zero.base.factory.PagedResponseFactory;

/**
 * 用户角色CRUD
 * Created by cznno
 * Date: 18-1-8
 */
@RestController
@RequestMapping("admin/user_role")
@RequiresRoles("admin")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    /**
     * 查询所有用户角色关联
     *
     * @param entity 分页参数
     * @return 用户角色分页信息
     */
    @GetMapping
    public Response getAll(UserRoleEntity entity) {
        return PagedResponseFactory.get(userRoleService.selectAll(entity));
    }

    /**
     * 根据id查询用户角色关联
     *
     * @param id 主键
     * @return 用户角色关联实体
     */
    @GetMapping("/{id}")
    public Response SelectById(@PathVariable Integer id) {
        return CrudResponseFactory.get(CrudStatusEnum.SELECT, userRoleService.selectById(id));
    }

    /**
     * 新增用户角色关联
     *
     * @param userRole 用户角色关联实体
     * @return 新增的条数
     */
    @PostMapping
    public Response insert(UserRoleEntity userRole) {
        return CrudResponseFactory.get(CrudStatusEnum.INSERT, userRoleService.insertSelective(userRole));
    }

    /**
     * 更新用户角色关联
     *
     * @param userRole 用户角色关联实体
     * @return 更新的条数
     */
    @PutMapping
    public Response updateById(@RequestBody UserRoleEntity userRole) {
        return CrudResponseFactory.get(CrudStatusEnum.UPDATE, userRoleService.updateByIdSelective(userRole));
    }

    /**
     * 按id删除用户角色关联
     *
     * @param id 主键
     * @return 删除的条数
     */
    @DeleteMapping("/{id}")
    public Response deleteById(@PathVariable Integer id) {
        return CrudResponseFactory.get(CrudStatusEnum.DELETE, userRoleService.deleteById(id));
    }
}
