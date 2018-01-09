package person.cznno.zero.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import person.cznno.zero.admin.entity.RolePermissionEntity;
import person.cznno.zero.admin.service.RolePermissionService;
import person.cznno.zero.base.factory.BaseResponseFactory;
import person.cznno.zero.base.factory.PagedResponseFactory;
import person.cznno.zero.base.model.response.Response;

/**
 * 角色权限CRUD
 * Created by cznno
 * Date: 18-1-8
 */
@Slf4j
@RestController
@RequestMapping("/admin/rolePermission")
public class RolePermissionController {

    @Autowired
    private RolePermissionService rolePermissionService;

    /**
     * 查询所有角色权限
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
        return BaseResponseFactory.get(rolePermissionService.selectById(id));
    }

    /**
     * 新增角色权限
     *
     * @param rolePermission 角色权限实体
     * @return 新增条数
     */
    @PostMapping
    public Response insert(@RequestBody RolePermissionEntity rolePermission) {
        return BaseResponseFactory.get(rolePermissionService.insertSelective(rolePermission));
    }

    /**
     * 按id修改角色权限
     * @param rolePermission 角色权限实体
     * @return 修改条数
     */
    @PutMapping
    public Response updateById(@RequestBody RolePermissionEntity rolePermission) {
        return BaseResponseFactory.get(rolePermissionService.updateByIdSelective(rolePermission));
    }

    /**
     * 按id删除角色权限
     *
     * @param id 主键
     * @return
     */
    @DeleteMapping("/{id}")
    public Response deleteById(@PathVariable Integer id) {
        return BaseResponseFactory.get(rolePermissionService.deleteById(id));
    }
}
