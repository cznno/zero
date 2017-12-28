package person.cznno.zero.admin.dao;

import org.springframework.stereotype.Repository;
import person.cznno.zero.admin.entity.PermissionEntity;

@Repository
public interface PermissionDao {

    PermissionEntity selectById(Integer id);

    int insertSelective(PermissionEntity record);

    int updateByIdSelective(PermissionEntity record);

    int deleteById(Integer id);
}
