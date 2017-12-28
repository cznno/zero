package person.cznno.zero.admin.service;

import com.github.pagehelper.PageHelper;
import person.cznno.zero.admin.entity.UserEntity;

import java.util.List;

/**
 * Created by cznno
 * Date: 17-12-28
 */
public interface UserService {

     List<UserEntity> getAll(UserEntity city) ;

     UserEntity getById(Integer id) ;

     void deleteById(Integer id);

     void save(UserEntity country);
}
