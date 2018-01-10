package person.cznno.zero.admin.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import person.cznno.zero.admin.dao.UserDao;
import person.cznno.zero.admin.entity.UserEntity;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by cznno
 * Date: 17-12-28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class LoginServiceTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void getUserTest() {

        String username = "admin";
        String passwordEncrypted = "928bfd2577490322a6e19b793691467e";

        UserEntity userEntity = userDao.selectByUsernameAndPassword(username, passwordEncrypted);
        assertThat(userEntity.getUsername()).isEqualTo(username);
        assertThat(userEntity.getPassword()).isEqualTo(passwordEncrypted);
    }
}
