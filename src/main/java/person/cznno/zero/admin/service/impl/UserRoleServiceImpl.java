package person.cznno.zero.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.cznno.zero.admin.dao.UserRoleDao;
import person.cznno.zero.admin.entity.UserRoleEntity;
import person.cznno.zero.admin.service.UserRoleService;
/**
 * Created by cznno
 * Date: 18-1-5
 */
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public PageInfo<UserRoleEntity> selectAll(UserRoleEntity entity) {
        return PageHelper.startPage(entity.getPage(), entity.getRows())
                .doSelectPageInfo(() -> userRoleDao.selectAll());
    }

    @Override
    public UserRoleEntity selectById(Integer id) {
        return userRoleDao.selectByPrimaryKey(id);
    }

    @Override
    public List<UserRoleEntity> selectByRoleId(Integer roleId) {
        return userRoleDao.selectByRoleId(roleId);
    }

    @Override
    public int insertSelective(UserRoleEntity entity) {
        return userRoleDao.insertSelective(entity);
    }

    @Override
    public int insertBatch(List<UserRoleEntity> userRoleList) {
        return userRoleDao.insertBatch(userRoleList);
    }

    @Override
    public int updateByIdSelective(UserRoleEntity entity) {
        return userRoleDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int deleteById(Integer id) {
        return userRoleDao.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBatchByRoleId(List<UserRoleEntity> userRoleList) {
        return userRoleDao.deleteBatchByRoleId(userRoleList);
    }
}
