package person.cznno.zero.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import person.cznno.zero.admin.entity.RolePermissionEntity;
import person.cznno.zero.admin.service.RolePermissionService;
import person.cznno.zero.base.factory.BaseResponseFactory;
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

    public Response selectAll(RolePermissionEntity entity) {
        return BaseResponseFactory.get(rolePermissionService.selectAll(entity));
    }

    /**
     * 根据id查询权限
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Response SelectById(@PathVariable Integer id) {
        return BaseResponseFactory.get(rolePermissionService.selectById(id));
    }

    /**
     * 新增角色权限
     *
     * @param rolePermission
     * @return
     */
    @PostMapping
    public Response insert(@RequestBody RolePermissionEntity rolePermission) {
        return BaseResponseFactory.get(rolePermissionService.insertSelective(rolePermission));
    }

    /**
     * 修改角色权限
     *
     * @return
     */
    @PutMapping
    public Response updateById(@RequestBody RolePermissionEntity rolePermission) {
        return BaseResponseFactory.get(rolePermissionService.updateByIdSelective(rolePermission));
    }

    /**
     * 按id删除角色权限
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Response deleteById(@PathVariable Integer id) {
        return BaseResponseFactory.get(rolePermissionService.deleteById(id));
    }
}
