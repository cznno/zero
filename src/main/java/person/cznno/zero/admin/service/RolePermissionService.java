package person.cznno.zero.admin.service;

import com.github.pagehelper.PageInfo;
import person.cznno.zero.admin.entity.RolePermissionEntity;

public interface RolePermissionService {

    PageInfo<RolePermissionEntity> selectAll(RolePermissionEntity entity);

    RolePermissionEntity selectById(Integer id);

    int insertSelective(RolePermissionEntity record);

    int updateByIdSelective(RolePermissionEntity record);

    int deleteById(Integer id);
}
