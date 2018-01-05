package person.cznno.zero.admin.service;

import person.cznno.zero.admin.entity.UserRoleEntity;
import person.cznno.zero.base.model.response.Response;

public interface UserRoleService {

    UserRoleEntity selectById(Integer id);

    Response insertSelective(UserRoleEntity userRole);

    Response updateByIdSelective(UserRoleEntity userRole);

    Response deleteById(Integer id);
}
