package person.cznno.zero.admin.service;

import com.github.pagehelper.PageInfo;
import person.cznno.zero.admin.entity.RoleEntity;

public interface RoleService {

    PageInfo<RoleEntity> selectAll(RoleEntity entity);

    RoleEntity selectById(Integer id);

    int insertSelective(RoleEntity role);

    int updateByIdSelective(RoleEntity role);

    int deleteById(Integer id);
}
