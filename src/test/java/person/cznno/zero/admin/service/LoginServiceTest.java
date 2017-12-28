package person.cznno.zero.admin.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import person.cznno.zero.admin.dto.LoginUserDTO;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by cznno
 * Date: 17-12-28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginServiceTest {

    @Resource
    private LoginService loginService;

    @Test
    public void getUserTest() {

        String username = "admin";
        String password = "123456";

        LoginUserDTO loginUserDTO = loginService.getUser(username, password);
        assertThat(loginUserDTO.getUsername()).isEqualTo(username);
        assertThat(loginUserDTO.getPassword()).isEqualTo(password);
    }
}
