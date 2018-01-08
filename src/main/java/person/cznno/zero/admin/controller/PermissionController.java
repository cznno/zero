package person.cznno.zero.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import person.cznno.zero.admin.entity.PermissionEntity;
import person.cznno.zero.admin.service.PermissionService;
import person.cznno.zero.base.factory.BaseResponseFactory;
import person.cznno.zero.base.factory.PagedResponseFactory;
import person.cznno.zero.base.model.response.Response;

/**
 * 权限CRUD
 * Created by cznno
 * Date: 18-1-8
 */
@RestController
@RequestMapping("admin/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    /**
     * 查询全部权限
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
    public Response SelectById(@PathVariable Integer id) {
        return BaseResponseFactory.get(permissionService.selectById(id));
    }

    /**
     * 新增权限
     *
     * @param permission 权限实体
     * @return 新增的条数
     */
    @PostMapping
    public Response insert(PermissionEntity permission) {
        return BaseResponseFactory.get(permissionService.insertSelective(permission));
    }

    /**
     * 按id修改权限
     * @param permission 权限实体
     * @return 修改的条数
     */
    @PutMapping
    public Response updateById(@RequestBody PermissionEntity permission) {
        return BaseResponseFactory.get(permissionService.updateByIdSelective(permission));
    }

    /**
     * 按id删除权限
     *
     * @param id 主键
     * @return 删除的条数
     */
    @DeleteMapping("/{id}")
    public Response deleteById(@PathVariable Integer id) {
        return BaseResponseFactory.get(permissionService.deleteById(id));
    }
}
