package person.cznno.zero.admin.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import person.cznno.zero.admin.entity.RoleEntity;
import person.cznno.zero.admin.service.RoleService;
import person.cznno.zero.base.dto.response.Response;
import person.cznno.zero.base.enums.CrudStatusEnum;
import person.cznno.zero.base.factory.CrudResponseFactory;
import person.cznno.zero.base.factory.PagedResponseFactory;

/**
 * 角色CRUD
 * Created by cznno
 * Date: 18-1-8
 */
@RestController
@RequestMapping("/admin/role")
@RequiresRoles("admin")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 查询全部角色
     *
     * @param entity 分页参数
     * @return 角色分页结果
     */
    @GetMapping
    public Response selectAll(RoleEntity entity) {
        return PagedResponseFactory.get(roleService.selectAll(entity));
    }

    /**
     * 按id查询角色
     *
     * @param id 主键
     * @return 角色实体
     */
    @GetMapping("/{id}")
    public Response selectById(@PathVariable("id") Integer id) {
        return CrudResponseFactory.get(CrudStatusEnum.SELECT, roleService.selectById(id));
    }

    /**
     * 新增角色
     *
     * @param role 角色实体
     * @return 增加的条数
     */
    @PostMapping
    public Response insert(@RequestBody RoleEntity role) {
        return CrudResponseFactory.get(CrudStatusEnum.INSERT, roleService.insertSelective(role));
    }

    /**
     * 按id修改角色
     *
     * @param role 角色实体
     * @return 修改的条数
     */
    @PutMapping
    public Response updateById(@RequestBody RoleEntity role) {
        return CrudResponseFactory.get(CrudStatusEnum.UPDATE, roleService.updateByIdSelective(role));
    }

    /**
     * 按id删除角色
     *
     * @param id 主键
     * @return 删除的条数
     */
    @DeleteMapping("/{id}")
    public Response deleteById(@PathVariable Integer id) {
        return CrudResponseFactory.get(CrudStatusEnum.DELETE, roleService.deleteById(id));
    }
}
