package person.cznno.zero.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import person.cznno.zero.admin.dto.LoginUserDTO;
import person.cznno.zero.admin.service.LoginService;
import person.cznno.zero.base.model.response.Response;

@RestController
@RequestMapping("/login")
public class  LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录
     *
     * @param loginUser
     * @return
     */
    @PostMapping("/auth")
    public Response authLogin(@RequestBody LoginUserDTO loginUser) {
        return loginService.authLogin(loginUser);
    }

}