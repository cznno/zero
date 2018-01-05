package person.cznno.zero.admin.service;

import person.cznno.zero.admin.entity.RolePermissionEntity;
import person.cznno.zero.base.model.response.Response;

public interface RolePermissionService {

		RolePermissionEntity selectById(Integer id);

	    Response insertSelective(RolePermissionEntity record);

	    Response updateByIdSelective(RolePermissionEntity record);

	    Response deleteById(Integer id);
	
}
