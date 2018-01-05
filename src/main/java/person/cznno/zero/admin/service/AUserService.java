package person.cznno.zero.admin.service;

import person.cznno.zero.admin.entity.UserEntity;

import java.util.List;

/**
 * Created by cznno
 * Date: 17-12-28
 */
public interface AUserService {

    List<UserEntity> getAll(UserEntity city);

    UserEntity getById(Integer id);

    UserEntity getUserByUsernameAndPassword(String username, String password);

    int deleteById(Integer id);

    int insertSelective(UserEntity country);
}
