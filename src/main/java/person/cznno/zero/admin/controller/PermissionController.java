package person.cznno.zero.admin.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import person.cznno.zero.admin.entity.PermissionEntity;
import person.cznno.zero.admin.service.PermissionService;
import person.cznno.zero.base.dto.response.Response;
import person.cznno.zero.base.enums.CrudStatusEnum;
import person.cznno.zero.base.factory.CrudResponseFactory;
import person.cznno.zero.base.factory.PagedResponseFactory;

/**
 * 权限CRUD
 * Created by cznno
 * Date: 18-1-8
 */
@RestController
@RequestMapping("admin/permission")
@RequiresRoles("admin")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    /**
     * 查询全部权限
     *
     * @param entity 分页信息
     * @return 权限分页结果
     */
    @GetMapping
    public Response selectAll(PermissionEntity entity) {
        return PagedResponseFactory.get(permissionService.selectAll(entity));
    }

    /**
     * 根据id查询权限
     *
     * @param id 主键
     * @return 权限
     */
    @GetMapping("/{id}")
    public Response selectById(@PathVariable Integer id) {
        return CrudResponseFactory.get(CrudStatusEnum.SELECT, permissionService.selectById(id));
    }

    /**
     * 新增权限
     *
     * @param permission 权限实体
     * @return 新增的条数
     */
    @PostMapping
    public Response insert(PermissionEntity permission) {
        return CrudResponseFactory.get(CrudStatusEnum.INSERT, permissionService.insertSelective(permission));
    }

    /**
     * 按id修改权限
     *
     * @param permission 权限实体
     * @return 修改的条数
     */
    @PutMapping
    public Response updateById(@RequestBody PermissionEntity permission) {
        return CrudResponseFactory.get(CrudStatusEnum.UPDATE, permissionService.updateByIdSelective(permission));
    }

    /**
     * 按id删除权限
     *
     * @param id 主键
     * @return 删除的条数
     */
    @DeleteMapping("/{id}")
    public Response deleteById(@PathVariable Integer id) {
        return CrudResponseFactory.get(CrudStatusEnum.DELETE, permissionService.deleteById(id));
    }
}
