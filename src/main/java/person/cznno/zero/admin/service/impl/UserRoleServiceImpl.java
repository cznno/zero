package person.cznno.zero.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.cznno.zero.admin.dao.UserRoleDao;
import person.cznno.zero.admin.entity.UserRoleEntity;
import person.cznno.zero.admin.service.UserRoleService;

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
    public int insertSelective(UserRoleEntity entity) {
        return userRoleDao.insertSelective(entity);
    }

    @Override
    public int updateByIdSelective(UserRoleEntity entity) {
        return userRoleDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int deleteById(Integer id) {
        return userRoleDao.deleteByPrimaryKey(id);
    }
}
