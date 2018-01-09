package person.cznno.zero.admin.service;

import person.cznno.zero.admin.entity.PermissionEntity;
import person.cznno.zero.admin.entity.RolePermissionEntity;
import person.cznno.zero.admin.entity.UserEntity;
import person.cznno.zero.admin.entity.UserRoleEntity;

import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * Created by cznno
 * Date: 18-1-9
 */
public interface AccessControlService {

    /**
     * 修改角色-权限关联
     *
     * @param rolePermissionList
     * @return
     */
    int updateRolePermissionRelations(List<RolePermissionEntity> rolePermissionList);

    /**
     * 修改角色-菜单关联
     *
     * @param userRoleList
     * @return
     */
    int updateUserRoleRelations(List<UserRoleEntity> userRoleList);

    /**
     * 查询所有用户,按角色id区分是否有角色,分为两组
     *
     * @param roleId 角色id
     * @return Boolean 有无权限, List 用户
     */
    Map<Boolean, List<UserEntity>> selectUserGroupByRoleId(Integer roleId);

    /**
     * 按角色id查询全部权限，并按照是否有权限标注
     *
     * @param roleId 角色id
     * @return
     */
    List<PermissionEntity> selectPermissionMarkedByRoleId(Integer roleId);
}
