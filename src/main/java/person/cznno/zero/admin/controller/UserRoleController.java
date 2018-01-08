package person.cznno.zero.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import person.cznno.zero.admin.entity.UserRoleEntity;
import person.cznno.zero.admin.service.UserRoleService;
import person.cznno.zero.base.factory.BaseResponseFactory;
import person.cznno.zero.base.factory.PagedResponseFactory;
import person.cznno.zero.base.model.response.Response;

/**
 * 用户角色CRUD
 * Created by cznno
 * Date: 18-1-8
 */
@Slf4j
@RestController
@RequestMapping("admin/userRole")
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
        return BaseResponseFactory.get(userRoleService.selectById(id));
    }

    /**
     * 新增用户角色关联
     *
     * @param userRole 用户角色关联实体
     * @return 新增的条数
     */
    @PostMapping
    public Response insert(UserRoleEntity userRole) {
        return BaseResponseFactory.get(userRoleService.insertSelective(userRole));
    }

    /**
     * 更新用户角色关联
     * @param userRole 用户角色关联实体
     * @return 更新的条数
     */
    @PutMapping
    public Response updateById(@RequestBody UserRoleEntity userRole) {
        return BaseResponseFactory.get(userRoleService.updateByIdSelective(userRole));
    }

    /**
     * 按id删除用户角色关联
     *
     * @param id 主键
     * @return 删除的条数
     */
    @DeleteMapping("/{id}")
    public Response deleteById(@PathVariable Integer id) {
        return BaseResponseFactory.get(userRoleService.deleteById(id));
    }
}
