package person.cznno.zero.admin.service;

import person.cznno.zero.admin.entity.RoleEntity;
import person.cznno.zero.base.model.response.Response;

public interface RoleService {

    Response insert(RoleEntity role);

    Response deleteById(Integer id);

    Response updateByIdSelective(RoleEntity role);

    RoleEntity selectById(Integer id);
}
