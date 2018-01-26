package person.cznno.zero.admin.service;

import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import person.cznno.zero.admin.entity.UserEntity;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by cznno
 * Date: 17-12-28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void getById() {
        UserEntity userEntity = userService.selectById(1);
        assertThat(userEntity.getId()).isEqualTo(1);
    }

    @Test
    public void selectAllTest() {
        UserEntity userEntity = new UserEntity();
        userEntity.setPage(1);
        userEntity.setRows(10);
        PageInfo<UserEntity> pageInfo = userService.selectAll(userEntity);
        assertThat(pageInfo.getList().size()).isGreaterThan(0);
        assertThat(pageInfo.getPageNum()).isEqualTo(1);
        assertThat(pageInfo.getPageSize()).isEqualTo(10);

        pageInfo = userService.selectAll(1, 5);
        assertThat(pageInfo.getList().size()).isGreaterThan(0);
        assertThat(pageInfo.getPageNum()).isEqualTo(1);
        assertThat(pageInfo.getPageSize()).isEqualTo(5);
    }

    @Test
    public void insertTest() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("test_user");
        userEntity.setPassword("123456");
        userEntity.setRealName("test_user");
        assertThat(userService.insertSelective(userEntity)).isEqualTo(1);
    }

    @Test
    public void updateTest() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1);
        userEntity.setUsername("test_user2");
        userEntity.setPassword("123456");
        userEntity.setRealName("test_user2");
        int res = userService.updateByIdSelective(userEntity);
        assertThat(res).isEqualTo(1);
    }

    public void deleteByIdTest() {
        int res = userService.deleteById(1);
        assertThat(res).isEqualTo(1);
    }
}