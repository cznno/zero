package person.cznno.zero.admin.dao;

import org.springframework.stereotype.Repository;
import person.cznno.zero.admin.entity.RolePermissionEntity;

@Repository
public interface RolePermissionDao {

    RolePermissionEntity selectById(Integer id);

    int insertSelective(RolePermissionEntity record);

    int updateByIdSelective(RolePermissionEntity record);

    int deleteById(Integer id);
}