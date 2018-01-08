package person.cznno.zero.admin.service;

import person.cznno.zero.admin.entity.PermissionEntity;
import person.cznno.zero.base.model.response.Response;

public interface PermissionService {
    /**
     * 查询某用户的 角色  菜单列表   权限列表
     *
     * @param id
     * @return
     */
    PermissionEntity selectById(Integer id);

    Response insertSelective(PermissionEntity record);

    Response updateByIdSelective(PermissionEntity record);

    Response deleteById(Integer id);
}