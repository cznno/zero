package person.cznno.zero.admin.service;

import com.github.pagehelper.PageInfo;
import person.cznno.zero.admin.entity.UserRoleEntity;

public interface UserRoleService {

    PageInfo<UserRoleEntity> selectAll(UserRoleEntity entity);

    UserRoleEntity selectById(Integer id);

    int insertSelective(UserRoleEntity userRole);

    int updateByIdSelective(UserRoleEntity userRole);

    int deleteById(Integer id);
}
