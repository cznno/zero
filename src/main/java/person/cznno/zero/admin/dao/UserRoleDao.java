package person.cznno.zero.admin.dao;

import org.springframework.stereotype.Repository;
import person.cznno.zero.admin.entity.UserRoleEntity;
import person.cznno.zero.base.MyMapper;

import java.util.List;

@Repository
public interface UserRoleDao extends MyMapper<UserRoleEntity> {

    List<UserRoleEntity> selectByRoleId(Integer roleId);

    int insertBatch(List<UserRoleEntity> roleMenuList);

    int deleteBatchByRoleId(List<UserRoleEntity> roleMenuList);
}