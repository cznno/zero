package person.cznno.zero.admin.service;

import org.aspectj.lang.annotation.Aspect;
import person.cznno.zero.admin.entity.UserEntity;
import person.cznno.zero.base.model.response.Response;

import java.util.List;

/**
 * Created by cznno
 * Date: 18-1-5
 */
public interface UserService {
    List<UserEntity> getAll(UserEntity city);

    UserEntity getById(Integer id);

    UserEntity getUserByUsernameAndPassword(String username, String password);

    void deleteById(Integer id);

    void save(UserEntity country);

    Response insertSelective(UserEntity user);
}
