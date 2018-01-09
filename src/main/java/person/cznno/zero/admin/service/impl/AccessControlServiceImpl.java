package person.cznno.zero.admin.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import person.cznno.zero.admin.entity.PermissionEntity;
import person.cznno.zero.admin.entity.RolePermissionEntity;
import person.cznno.zero.admin.entity.UserEntity;
import person.cznno.zero.admin.entity.UserRoleEntity;
import person.cznno.zero.admin.service.*;
import person.cznno.zero.base.exception.ParamErrorException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by cznno
 * Date: 18-1-9
 */
@Service
@Slf4j
public class AccessControlServiceImpl implements AccessControlService {

    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserService userService;
    @Autowired
    private RolePermissionService rolePermissionService;
    @Autowired
    private PermissionService permissionService;

    @Override
    public int updateRolePermissionRelations(List<RolePermissionEntity> rolePermissionList) {

        int insRes = 0;
        Boolean doUpdate = true;

        try {
            for (RolePermissionEntity rolePermission : rolePermissionList) {
                if (null == rolePermission.getPermissionId())
                    doUpdate = false;
                if (null == rolePermission.getRoleId())
                    throw new ParamErrorException();
            }
            int delRes = rolePermissionService.deleteBatchByRoleId(rolePermissionList);
            log.info("删除角色菜单关联数据：" + delRes + "条");

            if (doUpdate) {
                insRes = rolePermissionService.insertBatchSelective(rolePermissionList);
                log.info("增加角色菜单关联数据：" + insRes + "条");
            }
        } catch (Exception e) {
            log.error("修改用户-角色关联失败", e);
        }
        return insRes;
    }

    @Override
    public int updateUserRoleRelations(List<UserRoleEntity> userRoleList) {

        int insRes = 0;
        Boolean doUpdate = true;
        try {

            for (UserRoleEntity userRole : userRoleList) {
                if (null == userRole.getUserId())
                    doUpdate = false;
                if (null == userRole.getRoleId())
                    throw new ParamErrorException();
            }

            int delRes = userRoleService.deleteBatchByRoleId(userRoleList);
            log.info("删除角色菜单关联数据：" + delRes + "条");

            if (doUpdate) {
                insRes = userRoleService.insertBatch(userRoleList);
                log.info("增加角色菜单关联数据：" + insRes + "条");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return insRes;
    }

    @Override
    public Map<Boolean, List<UserEntity>> selectUserGroupByRoleId(Integer roleId) {

        Map<Boolean, List<UserEntity>> userMap = null;
        try {
            List<UserRoleEntity> userRoleList = new ArrayList<>(userRoleService.selectByRoleId(roleId));

            List<Integer> userIdList = userRoleList.stream()
                    .map(UserRoleEntity::getUserId)
                    .collect(Collectors.toList());

            List<UserEntity> userList = new ArrayList<>();
//            userList.addAll(userService.selectAll().getList());

            userMap = userList.stream()
                    .collect(Collectors.partitioningBy(user -> userIdList.contains(user.getId())));
        } catch (Exception e) {
            log.error("查询所有用户并按是否有角色分组", e);
        }
        return userMap;
    }

    @Override
    public List<PermissionEntity> selectPermissionMarkedByRoleId(@RequestParam("id") Integer roleId) {

        try {
            List<Integer> menuIdList =
                    rolePermissionService.selectByRoleId(roleId).stream()
                            .map(RolePermissionEntity::getPermissionId)
                            .collect(Collectors.toList());

            List<PermissionEntity> permissionList = permissionService.selectAll(0, 0).getList();

            List<Integer> list...
            List<Object> objList...
            for (Object o : objList) {
                if(list.contains(o.getInt()))
                    remove o;
            }
            menuList.stream().filter(o ->
                    menuIdList.contains(o.getId())
            );
        } catch (Exception e) {

        }
        return null;
    }
}
