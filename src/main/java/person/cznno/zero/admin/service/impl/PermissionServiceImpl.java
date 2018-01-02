package person.cznno.zero.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import person.cznno.zero.admin.dao.PermissionDao;
import person.cznno.zero.admin.entity.PermissionEntity;
import person.cznno.zero.admin.service.PermissionService;
import person.cznno.zero.base.model.response.Response;

import java.util.Set;

/**
 * Created by cznno
 * Date: 18-1-2
 */
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public Response getUserPermission(String username) {
       return null;
    }

//    /**
//     * 从数据库查询用户权限信息
//     *
//     * @param username
//     * @return
//     */
//    private JSONObject getUserPermissionFromDB(String username) {
//        JSONObject userPermission = permissionDao.getUserPermission(username);
//        //管理员角色ID为1
//        int adminRoleId = 1;
//        //如果是管理员
//        String roleIdKey = "roleId";
//        if (adminRoleId == userPermission.getIntValue(roleIdKey)) {
//            //查询所有菜单  所有权限
//            Set<String> menuList = permissionDao.getAllMenu();
//            Set<String> permissionList = permissionDao.getAllPermission();
//            userPermission.put("menuList", menuList);
//            userPermission.put("permissionList", permissionList);
//        }
//        return userPermission;
//    }
}
