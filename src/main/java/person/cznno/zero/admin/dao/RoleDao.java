package person.cznno.zero.admin.dao;

import org.springframework.stereotype.Repository;
import person.cznno.zero.admin.entity.RoleEntity;

@Repository
public interface RoleDao {

    RoleEntity selectById(Integer id);

    int insertSelective(RoleEntity record);

    int updateByIdSelective(RoleEntity record);

    int deleteById(Integer id);
}