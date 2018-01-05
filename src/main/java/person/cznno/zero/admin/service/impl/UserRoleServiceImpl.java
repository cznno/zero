package person.cznno.zero.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.cznno.zero.admin.dao.UserRoleDao;
import person.cznno.zero.admin.entity.UserRoleEntity;
import person.cznno.zero.admin.service.UserRoleService;
import person.cznno.zero.base.enums.CrudStatusEnum;
import person.cznno.zero.base.factory.BaseResponseFactory;
import person.cznno.zero.base.model.response.Response;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Autowired
	private static final BaseResponseFactory RESPONSE_FACTORY = new BaseResponseFactory();
	@Override
	public UserRoleEntity selectById(Integer id) {
		return userRoleDao.selectByPrimaryKey(id);
		 
	}

	@Override
	public Response insertSelective(UserRoleEntity userRole) {
		
		 int insertResult = userRoleDao.insertSelective(userRole);
		 if (insertResult==1) 
			 return RESPONSE_FACTORY.getResponse(CrudStatusEnum.INSERT_SUCCESS.isSuccess(), CrudStatusEnum.INSERT_SUCCESS.getMsg());
		 return RESPONSE_FACTORY.getResponse(CrudStatusEnum.INSERT_FAIL.isSuccess(), CrudStatusEnum.INSERT_FAIL.getMsg());
	}

	@Override
	public Response updateByIdSelective(UserRoleEntity userRole) {
		int updateResult = userRoleDao.updateByPrimaryKeySelective(userRole);
		if (updateResult == 1)
			 return RESPONSE_FACTORY.getResponse(CrudStatusEnum.UPDATE_SUCCESS.isSuccess(), CrudStatusEnum.UPDATE_SUCCESS.getMsg());
		 return RESPONSE_FACTORY.getResponse(CrudStatusEnum.UPDATE_FAIL.isSuccess(), CrudStatusEnum.UPDATE_FAIL.getMsg());
	}

	@Override
	public Response deleteById(Integer id) {
		int deleteResult = userRoleDao.deleteByPrimaryKey(id);
		if (deleteResult == 1) 
			return RESPONSE_FACTORY.getResponse(CrudStatusEnum.DELETE_SUCCESS.isSuccess(), CrudStatusEnum.DELETE_SUCCESS.getMsg());
		return RESPONSE_FACTORY.getResponse(CrudStatusEnum.DELETE_FAIL.isSuccess(), CrudStatusEnum.DELETE_FAIL.getMsg());
	}

}
