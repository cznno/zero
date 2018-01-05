package person.cznno.zero.admin.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.cznno.zero.admin.dao.UserDao;
import person.cznno.zero.admin.entity.UserEntity;
import person.cznno.zero.admin.service.AUserService;

import java.util.List;

/**
 * Created by cznno
 * Date: 17-12-28
 */
@Service
public class AUserServiceImpl implements AUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<UserEntity> getAll(UserEntity user) {
        if (user.getPage() != null && user.getRows() != null) {
            PageHelper.startPage(user.getPage(), user.getRows());
        }
        return userDao.selectAll();
    }

    @Override
    public UserEntity getUserByUsernameAndPassword(String username, String password) {
        return userDao.selectByUsernameAndPassword(username, password);
    }

    @Override
    public UserEntity getById(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(Integer id) {
       return userDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(UserEntity user) {

        if (user.getId() != null) {
            userDao.updateByPrimaryKey(user);
        } else {
            userDao.insert(user);
        }
        int a= 1/0;
        return a;
    }
}
