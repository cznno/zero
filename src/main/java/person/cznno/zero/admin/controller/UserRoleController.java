package person.cznno.zero.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import person.cznno.zero.admin.entity.UserRoleEntity;
import person.cznno.zero.admin.service.UserRoleService;
import person.cznno.zero.base.factory.BaseResponseFactory;
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
     * @param entity
     * @return
     */
    @GetMapping
    public Response getAll(UserRoleEntity entity) {
        return BaseResponseFactory.get(userRoleService.selectAll(entity));
    }

    /**
     * 根据id查询用户角色关联
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Response SelectById(@PathVariable Integer id) {
        return BaseResponseFactory.get(userRoleService.selectById(id));
    }

    /**
     * 新增
     *
     * @param userRole
     * @return
     */
    @PostMapping
    public Response insert(UserRoleEntity userRole) {
        return BaseResponseFactory.get(userRoleService.insertSelective(userRole));
    }

    /**
     * 修改用户角色关联
     *
     * @return
     */
    @PutMapping
    public Response updateById(@RequestBody UserRoleEntity userRole) {
        return BaseResponseFactory.get(userRoleService.updateByIdSelective(userRole));
    }

    /**
     * 按id删除用户角色关联
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Response deleteById(@PathVariable Integer id) {
        return BaseResponseFactory.get(userRoleService.deleteById(id));
    }
}
