package person.cznno.zero.admin.dao;

import org.springframework.stereotype.Repository;
import person.cznno.zero.admin.entity.RolePermissionEntity;
import person.cznno.zero.base.MyMapper;

import java.util.List;

@Repository
public interface RolePermissionDao extends MyMapper<RolePermissionEntity> {

    List<RolePermissionEntity> selectByRoleId(Integer roleId);

    int insertBatchSelective(List<RolePermissionEntity> roleMenuList);

    int deleteBatchByRoleId(List<RolePermissionEntity> roleMenuList);
}