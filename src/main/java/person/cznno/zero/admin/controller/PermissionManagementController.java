package person.cznno.zero.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import person.cznno.zero.admin.entity.RolePermissionEntity;
import person.cznno.zero.admin.entity.UserRoleEntity;
import person.cznno.zero.admin.service.AccessControlService;
import person.cznno.zero.base.dto.response.Response;
import person.cznno.zero.base.enums.CrudStatusEnum;
import person.cznno.zero.base.factory.CrudResponseFactory;

import java.util.List;

/**
 * 权限控制
 * Created by cznno
 * Date: 18-1-9
 */
@Slf4j
@RestController
@RequestMapping("/admin/access_control")
public class PermissionManagementController {

    @Autowired
    private AccessControlService accessControlService;

    /**
     * 修改角色-权限关联
     *
     * @param rolePermissionList 角色权限List
     * @return 修改的条数
     */
    @PutMapping("user_role")
    public Response updateRolePermissionRelations(@RequestBody List<RolePermissionEntity> rolePermissionList) {
        return CrudResponseFactory.get(
                CrudStatusEnum.UPDATE,
                accessControlService.updateRolePermissionRelations(rolePermissionList));
    }

    /**
     * 修改用户-角色关联
     *
     * @param userRoleList 用户角色List
     * @return 修改的条数
     */
    @PutMapping("role_menu")
    public Response updateUserRoleRelations(@RequestBody List<UserRoleEntity> userRoleList) {
        return CrudResponseFactory.get(
                CrudStatusEnum.UPDATE,
                accessControlService.updateUserRoleRelations(userRoleList));
    }

    /**
     * 查询所有用户并按角色id分类
     *
     * @param roleId 角色id
     * @return 用户角色分组
     */
    @GetMapping("user_role/{id}")
    public Response selectUserGroupByRoleId(@PathVariable("id") Integer roleId) {
        return CrudResponseFactory.get(
                CrudStatusEnum.SELECT,
                accessControlService.selectUserGroupByRoleId(roleId));
    }

    /**
     * 按角色id查询全部菜单，并按照是否有权限标注
     *
     * @param roleId 角色id
     * @return 角色权限分组
     */
    @GetMapping("role_menu/{id}")
    public Response selectPermissionGroupByRoleId(@PathVariable("id") Integer roleId) {
        return CrudResponseFactory.get(
                CrudStatusEnum.SELECT,
                accessControlService.selectPermissionGroupByRoleId(roleId));
    }
}
