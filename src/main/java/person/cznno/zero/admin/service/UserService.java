package person.cznno.zero.admin.service;

import com.github.pagehelper.PageInfo;
import person.cznno.zero.admin.entity.UserEntity;

/**
 * Created by cznno
 * Date: 18-1-5
 */
public interface UserService {

    PageInfo<UserEntity> selectAll(UserEntity city);

    UserEntity selectById(Integer id);

    int updateByIdSelective(UserEntity entity);

    int insertSelective(UserEntity user);

    int deleteById(Integer id);
}
