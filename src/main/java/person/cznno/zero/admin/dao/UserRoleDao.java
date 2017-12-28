package person.cznno.zero.admin.dao;

import org.springframework.stereotype.Repository;
import person.cznno.zero.admin.entity.UserRoleEntity;

@Repository
public interface UserRoleDao {

    UserRoleEntity selectById(Integer id);

    int insertSelective(UserRoleEntity record);

    int updateByIdSelective(UserRoleEntity record);

    int deleteById(Integer id);
}