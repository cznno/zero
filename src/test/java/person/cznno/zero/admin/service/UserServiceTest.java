package person.cznno.zero.admin.service;

import com.github.pagehelper.PageInfo;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import person.cznno.zero.admin.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by cznno
 * Date: 17-12-28
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Transactional
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    private static List<UserEntity> userListMock = new ArrayList<>();
    //    @Autowired
//    private UserService userService;
    @Mock
    private UserService userServiceMock;

    @BeforeClass
    public static void init() {

        String username = "username";
        String realName = "real_name";
        String password = "password";
        String mailAddr = "mail_addr";
        String phone = "phone";

        for (int i = 1; i <= 10; i++) {
            final UserEntity user = new UserEntity();
            user.setId(i);
            user.setUsername(username + i);
            user.setRealName(realName + i);
            user.setPassword(password + i);
            user.setMailAddress(mailAddr + i);
            user.setPhone(phone + i);
            userListMock.add(user);
        }
    }

    @Test
    public void getById() {
//        UserService userServiceMock = mock(UserService.class);
        when(userServiceMock.selectById(1)).thenReturn(userListMock.get(1));
        UserEntity userEntity = userServiceMock.selectById(1);
        assertThat(userEntity.getId()).isEqualTo(1);
        assertThat(userEntity).isEqualTo(userListMock.get(1));
    }

    @Test
    public void selectAllTest() {
        UserEntity userEntity = new UserEntity();
        userEntity.setPage(1);
        userEntity.setRows(10);
//        PageInfo<UserEntity> pageInfo = userService.selectAll(userEntity);
        when(userServiceMock.selectById(1)).thenReturn(userListMock.get(1));
        PageInfo<UserEntity> pageInfo = userServiceMock.selectAll(userEntity);
        assertThat(pageInfo.getList().size()).isGreaterThan(0);
        assertThat(pageInfo.getPageNum()).isEqualTo(1);
        assertThat(pageInfo.getPageSize()).isEqualTo(10);

//        pageInfo = userService.selectAll(1, 5);
//        assertThat(pageInfo.getList().size()).isGreaterThan(0);
//        assertThat(pageInfo.getPageNum()).isEqualTo(1);
//        assertThat(pageInfo.getPageSize()).isEqualTo(5);
    }

    @Test
    public void insertTest() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("test_user");
        userEntity.setPassword("123456");
        userEntity.setRealName("test_user");
//        assertThat(userService.insertSelective(userEntity)).isEqualTo(1);
    }

    @Test
    public void updateTest() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1);
        userEntity.setUsername("test_user2");
        userEntity.setPassword("123456");
        userEntity.setRealName("test_user2");
//        int res = userService.updateByIdSelective(userEntity);
//        assertThat(res).isEqualTo(1);
    }

    public void deleteByIdTest() {
//        int res = userService.deleteById(1);
//        assertThat(res).isEqualTo(1);
    }
}
