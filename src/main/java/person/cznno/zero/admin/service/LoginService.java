package person.cznno.zero.admin.service;

import person.cznno.zero.admin.dto.LoginUserDTO;
import person.cznno.zero.admin.dto.UserInfoDTO;
import person.cznno.zero.base.enums.AuthStatusEnum;

public interface LoginService {

    /**
     * 登录表单提交
     *
     * @param userDTO
     * @return
     */
    AuthStatusEnum authLogin(LoginUserDTO userDTO);

    /**
     * 查询当前登录用户的权限等信息
     *
     * @return
     */
    UserInfoDTO getInfo(String username);

    /**
     * 退出登录
     *
     * @return
     */
    AuthStatusEnum logout();
}