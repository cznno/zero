package person.cznno.zero.admin.service;

import person.cznno.zero.admin.dto.LoginUserDTO;
import person.cznno.zero.admin.dto.UserInfoDTO;
import person.cznno.zero.base.enums.AuthStatusEnum;

/**
 * 登录登出业务
 * Created by cznno
 * Date: 18-1-8
 */
public interface LoginService {

    /**
     * 登录表单提交
     * @param userDTO 用户登录信息
     * @return 登录结果
     */
    AuthStatusEnum authLogin(LoginUserDTO userDTO);

    /**
     * 查询当前登录用户的权限等信息
     * @return 登录结果
     */
    UserInfoDTO getInfo(String username);

    /**
     * 退出登录
     * @return 退出登录结果
     */
    AuthStatusEnum logout();
}