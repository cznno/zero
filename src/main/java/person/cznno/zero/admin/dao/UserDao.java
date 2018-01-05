package person.cznno.zero.admin.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import person.cznno.zero.admin.entity.UserEntity;
import person.cznno.zero.base.MyMapper;

@Repository
public interface UserDao extends MyMapper<UserEntity> {

    UserEntity selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
    UserEntity selectByUsername(String username);
}