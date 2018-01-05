package person.cznno.zero.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import person.cznno.zero.admin.dto.LoginUserDTO;
import person.cznno.zero.admin.service.LoginService;
import person.cznno.zero.base.model.response.Response;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录
     *
     * @param loginUser
     * @return
     */
    @PostMapping("/auth")
    public Response<?> authLogin(@RequestBody LoginUserDTO loginUser) {
        return loginService.authLogin(loginUser);
    }

    /**
     * 查询当前登录用户的信息
     *
     * @return
     */
    @PostMapping("/getInfo")
    public Response getInfo(@SessionAttribute("user_info") LoginUserDTO userDTO) {
        return loginService.getInfo(userDTO.getUsername());
    }

    /**
     * 登出
     *
     * @return
     */
    @GetMapping("/logout")
    public Response logout() {
        return loginService.logout();
    }
}
