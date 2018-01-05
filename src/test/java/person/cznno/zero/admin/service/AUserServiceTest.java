package person.cznno.zero.admin.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
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
public class AUserServiceTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void getById() {
        Integer id = 1;
        UserEntity userEntity = userDao.selectByPrimaryKey(id);
        assertThat(userEntity.getId()).isEqualTo(1);
    }

    @Test
    public void insert() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("test_user");
        userEntity.setPassword("123456");
        userEntity.setRealName("test_user");
        assertThat(userDao.insert(userEntity)).isEqualTo(1);
    }
}
