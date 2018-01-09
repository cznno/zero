package person.cznno.zero.admin.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import person.cznno.zero.admin.dao.UserDao;
import person.cznno.zero.admin.entity.UserEntity;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by cznno
 * Date: 17-12-28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginServiceTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void getUserTest() {

        String username = "admin";
        String password = "123456";

        UserEntity userEntity = userDao.selectByUsernameAndPassword(username, password);
        assertThat(userEntity.getUsername()).isEqualTo(username);
        assertThat(userEntity.getPassword()).isEqualTo(password);
    }
}
