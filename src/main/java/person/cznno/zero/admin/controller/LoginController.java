package person.cznno.zero.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import person.cznno.zero.admin.dto.LoginUserDTO;
import person.cznno.zero.admin.service.LoginService;
import person.cznno.zero.base.factory.BaseResponseFactory;
import person.cznno.zero.base.model.response.Response;

/**
 * 登录
 * Created by cznno
 * Date: 18-1-8
 */
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
    public Response authLogin(@RequestBody LoginUserDTO loginUser) {
        return BaseResponseFactory.get(loginService.authLogin(loginUser));
    }

    /**
     * 查询当前登录用户的信息
     *
     * @return
     */
    @PostMapping("/getInfo")
    public Response getInfo(@SessionAttribute("user_info") LoginUserDTO userDTO) {
        return BaseResponseFactory.get(loginService.getInfo(userDTO.getUsername()));
    }

    /**
     * 登出
     *
     * @return
     */
    @GetMapping("/logout")
    public Response logout() {
        return BaseResponseFactory.get(loginService.logout());
    }
}
