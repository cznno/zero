package person.cznno.zero.admin.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import person.cznno.zero.admin.dao.RoleDao;
import person.cznno.zero.admin.entity.RoleEntity;
import person.cznno.zero.admin.service.RoleService;
import person.cznno.zero.admin.service.UserService;
import person.cznno.zero.base.enums.CrudStatusEnum;
import person.cznno.zero.base.factory.BaseResponseFactory;
import person.cznno.zero.base.model.response.Response;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	@Autowired
    private UserService userService;
	@Autowired
	private static final BaseResponseFactory RESPONSE_FACTORY = new BaseResponseFactory();
	
	public Response insert(RoleEntity role) {
		
		 int insertResult = roleDao.insertSelective(role);
		 int a=1/0;
		 if (insertResult==1) 
			 return RESPONSE_FACTORY.getResponse(CrudStatusEnum.INSERT_SUCCESS.isSuccess(), CrudStatusEnum.INSERT_SUCCESS.getMsg());
		 return RESPONSE_FACTORY.getResponse(CrudStatusEnum.INSERT_FAIL.isSuccess(), CrudStatusEnum.INSERT_FAIL.getMsg());
	}
	
	public Response deleteById(@PathVariable Integer id) {
		
		int deleteResult = roleDao.deleteByPrimaryKey(id);
		if (deleteResult == 1) 
			return RESPONSE_FACTORY.getResponse(CrudStatusEnum.DELETE_SUCCESS.isSuccess(), CrudStatusEnum.DELETE_SUCCESS.getMsg());
		return RESPONSE_FACTORY.getResponse(CrudStatusEnum.DELETE_FAIL.isSuccess(), CrudStatusEnum.DELETE_FAIL.getMsg());
	}

	@Override
	public Response updateByIdSelective(RoleEntity role) {
		int updateResult = roleDao.updateByPrimaryKeySelective(role);
		 if (updateResult > 0)
			 return RESPONSE_FACTORY.getResponse(CrudStatusEnum.UPDATE_SUCCESS.isSuccess(), CrudStatusEnum.UPDATE_SUCCESS.getMsg());
		 return RESPONSE_FACTORY.getResponse(CrudStatusEnum.UPDATE_FAIL.isSuccess(), CrudStatusEnum.UPDATE_FAIL.getMsg());
	}

	@Override
	public RoleEntity selectById(Integer id) {
		return  roleDao.selectByPrimaryKey(id);
		
	}

}
