package person.cznno.zero.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.cznno.zero.admin.dao.UserDao;
import person.cznno.zero.admin.entity.UserEntity;
import person.cznno.zero.admin.service.UserService;

/**
 * Created by cznno
 * Date: 18-1-5
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public PageInfo<UserEntity> selectAll(UserEntity entity) {
        return PageHelper.startPage(entity.getPage(), entity.getRows())
                .doSelectPageInfo(() -> userDao.selectAll());
    }

    @Override
    public UserEntity selectById(Integer id) {
        return  userDao.selectByPrimaryKey(id);
    }

    @Override
    public int insertSelective(UserEntity user) {

        int res = 0;
        UserEntity resultUser = userDao.selectByUsername(user.getUsername());

        if (resultUser != null) {
//            resEnum = AuthStatusEnum.REGISTER_REPEAT;
            //TODO throw exception
        } else {
            //TODO algorithm name enum
            String algorithmName = "MD5";
            SimpleHash simpleHash = new SimpleHash(algorithmName, user.getPassword(), user.getUsername(), 2);
            user.setPassword(simpleHash.toHex());

            res = userDao.insertSelective(user);
        }
        return res;
    }

    @Override
    public int updateByIdSelective(UserEntity entity) {
        return userDao.updateByPrimaryKey(entity);
    }

    @Override
    public int deleteById(Integer id) {
        return userDao.deleteByPrimaryKey(id);
    }
}
