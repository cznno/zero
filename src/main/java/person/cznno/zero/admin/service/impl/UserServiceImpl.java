package person.cznno.zero.admin.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import person.cznno.zero.admin.dao.UserDao;
import person.cznno.zero.admin.entity.UserEntity;
import person.cznno.zero.admin.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cznno
 * Date: 17-12-28
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<UserEntity> getAll(UserEntity city) {
        if (city.getPage() != null && city.getRows() != null) {
            PageHelper.startPage(city.getPage(), city.getRows());
        }
        return userDao.selectAll();
    }

    @Override
    public UserEntity getById(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public void deleteById(Integer id) {
        userDao.deleteByPrimaryKey(id);
    }

    @Override
    public void save(UserEntity country) {
        if (country.getId() != null) {
            userDao.updateByPrimaryKey(country);
        } else {
            userDao.insert(country);
        }
    }
}
