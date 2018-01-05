package person.cznno.zero.admin.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.cznno.zero.admin.dao.UserDao;
import person.cznno.zero.admin.entity.UserEntity;
import person.cznno.zero.admin.service.UserService;
import person.cznno.zero.base.factory.BaseResponseFactory;
import person.cznno.zero.base.model.response.Response;

import java.util.List;

/**
 * Created by cznno
 * Date: 18-1-5
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private static final BaseResponseFactory RESPONSE_FACTORY = new BaseResponseFactory();
    @Autowired
    private UserDao userDao;

    @Override
    public List<UserEntity> getAll(UserEntity city) {
        if (city.getPage() != null && city.getRows() != null) {
            PageHelper.startPage(city.getPage(), city.getRows());
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

    @Override
    public Response insertSelective(UserEntity user) {
//        UserEntity resultUser = userDao.selectByUsername(user.getUsername());
//        AuthStatusEnum resEnum;
//        if (resultUser!= null){
//            resEnum= AuthStatusEnum.REGISTER_REPEAT;
//        }else{
//            String password = user.getPassword();
//            String algorithmName = "MD5";
//            SimpleHash simpleHash = new SimpleHash(algorithmName, password, user.getUsername(), 2);
//            String Encryptionpassword = simpleHash.toHex();
//            user.setPassword(Encryptionpassword);

        int insertCount = userDao.insertSelective(user);
//            if (insertCount==1) {
//                resEnum= AuthStatusEnum.LOGIN_SUCCESS;
//            }else{
//                resEnum= AuthStatusEnum.LOGIN_FAIL;
//            }

//        }
        try {
            int a= 1/0;
        } catch (Exception e) {
            throw new RuntimeException();
        }
//        return RESPONSE_FACTORY.getResponse(resEnum.isSuccess(), resEnum.getMsg());
        return null;
    }
}
