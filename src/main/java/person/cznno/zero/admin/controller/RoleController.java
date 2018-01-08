package person.cznno.zero.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import person.cznno.zero.admin.entity.RoleEntity;
import person.cznno.zero.admin.service.RoleService;
import person.cznno.zero.base.factory.BaseResponseFactory;
import person.cznno.zero.base.factory.PagedResponseFactory;
import person.cznno.zero.base.model.response.Response;

/**
 * 角色CRUD
 * Created by cznno
 * Date: 18-1-8
 */
@RestController
@RequestMapping("/admin/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * @param entity
     * @return
     */
    public Response selectAll(RoleEntity entity) {
        return PagedResponseFactory.get(roleService.selectAll(entity));
    }

    /**
     * 按id查询角色
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Response selectById(@PathVariable("id") Integer id) {
        return BaseResponseFactory.get(roleService.selectById(id));
    }

    /**
     * 新增角色
     *
     * @param role
     * @return
     */
    @PostMapping
    public Response insert(@RequestBody RoleEntity role) {
        return BaseResponseFactory.get(roleService.insertSelective(role));
    }

    /**
     * 修改角色
     *
     * @return
     */
    @PutMapping
    public Response updateById(@RequestBody RoleEntity role) {
        return BaseResponseFactory.get(roleService.updateByIdSelective(role));
    }

    /**
     * 按id删除角色
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Response deleteById(@PathVariable Integer id) {
        return BaseResponseFactory.get(roleService.deleteById(id));
    }
}
