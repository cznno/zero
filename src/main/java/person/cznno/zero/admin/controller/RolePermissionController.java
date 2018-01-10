package person.cznno.zero.admin.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import person.cznno.zero.admin.entity.RolePermissionEntity;
import person.cznno.zero.admin.service.RolePermissionService;
import person.cznno.zero.base.dto.response.Response;
import person.cznno.zero.base.enums.CrudStatusEnum;
import person.cznno.zero.base.factory.CrudResponseFactory;
import person.cznno.zero.base.factory.PagedResponseFactory;

/**
 * 角色权限CRUD
 * Created by cznno
 * Date: 18-1-8
 */
@RestController
@RequestMapping("/admin/role_permission")
@RequiresRoles("admin")
public class RolePermissionController {

    @Autowired
    private RolePermissionService rolePermissionService;

    /**
     * 查询所有角色权限
     *
     * @param entity 角色权限实体
     * @return 分页角色权限
     */
    @GetMapping
    public Response selectAll(RolePermissionEntity entity) {
        return PagedResponseFactory.get(rolePermissionService.selectAll(entity));
    }

    /**
     * 根据id查询权限
     *
     * @param id 主键
     * @return 角色权限实体
     */
    @GetMapping("/{id}")
    public Response SelectById(@PathVariable Integer id) {
        return CrudResponseFactory.get(CrudStatusEnum.SELECT, rolePermissionService.selectById(id));
    }

    /**
     * 新增角色权限
     *
     * @param rolePermission 角色权限实体
     * @return 新增条数
     */
    @PostMapping
    public Response insert(@RequestBody RolePermissionEntity rolePermission) {
        return CrudResponseFactory.get(CrudStatusEnum.INSERT, rolePermissionService.insertSelective(rolePermission));
    }

    /**
     * 按id修改角色权限
     *
     * @param rolePermission 角色权限实体
     * @return 修改条数
     */
    @PutMapping
    public Response updateById(@RequestBody RolePermissionEntity rolePermission) {
        return CrudResponseFactory.get(CrudStatusEnum.UPDATE, rolePermissionService.updateByIdSelective(rolePermission));
    }

    /**
     * 按id删除角色权限
     *
     * @param id 主键
     * @return 删除的条数
     */
    @DeleteMapping("/{id}")
    public Response deleteById(@PathVariable Integer id) {
        return CrudResponseFactory.get(CrudStatusEnum.DELETE, rolePermissionService.deleteById(id));
    }
}
