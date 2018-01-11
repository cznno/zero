package person.cznno.zero.admin.service;

import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import person.cznno.zero.Application;
import person.cznno.zero.admin.dto.LoginUserDTO;
import person.cznno.zero.base.config.ShiroConfiguration;
import person.cznno.zero.base.config.UserRealm;
import person.cznno.zero.base.enums.AuthStatusEnum;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by cznno
 * Date: 17-12-28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@Transactional
@ContextConfiguration(classes = {ShiroConfiguration.class, Application.class, UserRealm.class})
public class LoginServiceTest {

    @Autowired
    private LoginService loginService;

    @Test
    public void getUserTest() {

        String username = "admin";
        String passwordEncrypted = "928bfd2577490322a6e19b793691467e";
        LoginUserDTO loginUser = new LoginUserDTO();
        loginUser.setUsername(username);
        loginUser.setPassword("123456");
//        UserEntity userEntity = loginService.authLogin(username, passwordEncrypted);
        AuthStatusEnum authLogin = loginService.authLogin(loginUser);
        assertThat(authLogin.isSuccess()).isTrue();
//        assertThat(authLogin.getUsername()).isEqualTo(username);
//        assertThat(authLogin.getPassword()).isEqualTo(passwordEncrypted);
    }
}
