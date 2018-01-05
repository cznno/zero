package person.cznno.zero.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.cznno.zero.admin.dao.PermissionDao;
import person.cznno.zero.admin.entity.PermissionEntity;
import person.cznno.zero.admin.service.PermissionService;
import person.cznno.zero.base.enums.CrudStatusEnum;
import person.cznno.zero.base.factory.BaseResponseFactory;
import person.cznno.zero.base.model.response.Response;

import java.util.Set;

/**
 * Created by cznno
 * Date: 18-1-2
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private static final BaseResponseFactory RESPONSE_FACTORY = new BaseResponseFactory();

    @Override
    public PermissionEntity selectById(Integer id) {

        return permissionDao.selectByPrimaryKey(id);
    }

    @Override
    public Response insertSelective(PermissionEntity record) {
        int insertResult = permissionDao.insertSelective(record);
        int a=1/0;
        if (insertResult==1)
            return RESPONSE_FACTORY.getResponse(CrudStatusEnum.INSERT_SUCCESS.isSuccess(), CrudStatusEnum.INSERT_SUCCESS.getMsg());
        return RESPONSE_FACTORY.getResponse(CrudStatusEnum.INSERT_FAIL.isSuccess(), CrudStatusEnum.INSERT_FAIL.getMsg());
    }

    @Override
    public Response updateByIdSelective(PermissionEntity record) {
        int updateResult = permissionDao.updateByPrimaryKeySelective(record);
        if (updateResult == 1)
            return RESPONSE_FACTORY.getResponse(CrudStatusEnum.UPDATE_SUCCESS.isSuccess(), CrudStatusEnum.UPDATE_SUCCESS.getMsg());
        return RESPONSE_FACTORY.getResponse(CrudStatusEnum.UPDATE_FAIL.isSuccess(), CrudStatusEnum.UPDATE_FAIL.getMsg());
    }

    @Override
    public Response deleteById(Integer id) {
        int deleteResult = permissionDao.deleteByPrimaryKey(id);
        if (deleteResult == 1)
            return RESPONSE_FACTORY.getResponse(CrudStatusEnum.DELETE_SUCCESS.isSuccess(), CrudStatusEnum.DELETE_SUCCESS.getMsg());
        return RESPONSE_FACTORY.getResponse(CrudStatusEnum.DELETE_FAIL.isSuccess(), CrudStatusEnum.DELETE_FAIL.getMsg());
    }
}
