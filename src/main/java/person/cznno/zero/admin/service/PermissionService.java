package person.cznno.zero.admin.service;

import com.github.pagehelper.PageInfo;
import person.cznno.zero.admin.entity.PermissionEntity;

public interface PermissionService {

    PageInfo<PermissionEntity> selectAll(PermissionEntity entity);

    /**
     * 查询某用户的 角色  菜单列表   权限列表
     *
     * @param id
     * @return
     */
    PermissionEntity selectById(Integer id);

    int insertSelective(PermissionEntity record);

    int updateByIdSelective(PermissionEntity record);

    int deleteById(Integer id);
}