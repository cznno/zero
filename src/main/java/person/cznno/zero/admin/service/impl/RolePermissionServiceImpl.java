package person.cznno.zero.admin.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.cznno.zero.admin.dao.RolePermissionDao;
import person.cznno.zero.admin.entity.RolePermissionEntity;
import person.cznno.zero.admin.service.RolePermissionService;
import person.cznno.zero.base.enums.CrudStatusEnum;
import person.cznno.zero.base.factory.BaseResponseFactory;
import person.cznno.zero.base.model.response.Response;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

	@Autowired
	private RolePermissionDao rolePermissionDao ;
	@Autowired
	private static final BaseResponseFactory RESPONSE_FACTORY = new BaseResponseFactory();
	@Override
	public RolePermissionEntity selectById(Integer id) {
		
		return rolePermissionDao.selectByPrimaryKey(id);
	}

	@Override
	public Response insertSelective(RolePermissionEntity rolePermissionEntity) {
		int insertResult = rolePermissionDao.insertSelective(rolePermissionEntity);
		 if (insertResult==1) 
			 return RESPONSE_FACTORY.getResponse(CrudStatusEnum.INSERT_SUCCESS.isSuccess(), CrudStatusEnum.INSERT_SUCCESS.getMsg());
		 return RESPONSE_FACTORY.getResponse(CrudStatusEnum.INSERT_FAIL.isSuccess(), CrudStatusEnum.INSERT_FAIL.getMsg());
	}

	@Override
	public Response updateByIdSelective(RolePermissionEntity rolePermissionEntity) {
		int updateResult = rolePermissionDao.updateByPrimaryKeySelective(rolePermissionEntity);
		 if (updateResult > 0)
			 return RESPONSE_FACTORY.getResponse(CrudStatusEnum.UPDATE_SUCCESS.isSuccess(), CrudStatusEnum.UPDATE_SUCCESS.getMsg());
		 return RESPONSE_FACTORY.getResponse(CrudStatusEnum.UPDATE_FAIL.isSuccess(), CrudStatusEnum.UPDATE_FAIL.getMsg());
	}

	@Override
	public Response deleteById(Integer id) {
		int deleteResult = rolePermissionDao.deleteByPrimaryKey(id);
		if (deleteResult == 1) 
			return RESPONSE_FACTORY.getResponse(CrudStatusEnum.DELETE_SUCCESS.isSuccess(), CrudStatusEnum.DELETE_SUCCESS.getMsg());
		return RESPONSE_FACTORY.getResponse(CrudStatusEnum.DELETE_FAIL.isSuccess(), CrudStatusEnum.DELETE_FAIL.getMsg());
	}
}
