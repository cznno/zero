package person.cznno.zero.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import person.cznno.zero.admin.dto.LoginUserDTO;
import person.cznno.zero.admin.dto.UserInfoDTO;
import person.cznno.zero.admin.service.LoginService;
import person.cznno.zero.base.dto.response.Response;
import person.cznno.zero.base.enums.CrudStatusEnum;
import person.cznno.zero.base.factory.BaseResponseFactory;
import person.cznno.zero.base.factory.CrudResponseFactory;

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
     * @param loginUser 用户登录信息
     * @return 登录结果
     */
    @PostMapping("/auth")
    public Response authLogin(@RequestBody LoginUserDTO loginUser) {
        return BaseResponseFactory.get(loginService.authLogin(loginUser));
    }

    /**
     * 查询当前登录用户的信息
     *
     * @param userDTO 保存在session的用户信息
     * @return 当前用户信息
     */
    @GetMapping("/get_info")
    public Response getInfo(@SessionAttribute("user_info") UserInfoDTO userDTO) {
        return CrudResponseFactory.get(CrudStatusEnum.SELECT, loginService.getInfo(userDTO.getUsername()));
    }

    /**
     * 登出
     *
     * @return 登出结果
     */
    @GetMapping("/logout")
    public Response logout() {
        return BaseResponseFactory.get(loginService.logout());
    }
}
