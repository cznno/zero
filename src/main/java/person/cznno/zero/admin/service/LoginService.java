package person.cznno.zero.admin.service;

import person.cznno.zero.admin.dto.LoginUserDTO;
import person.cznno.zero.base.model.response.Response;

public interface LoginService {
    /**
     * 登录表单提交
     *
     * @param jsonObject
     * @return
     */
    Response authLogin(LoginUserDTO jsonObject);

    /**
     * 根据用户名和密码查询对应的用户
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    LoginUserDTO getUser(String username, String password);

    /**
     * 查询当前登录用户的权限等信息
     *
     * @return
     */
    void getInfo();

    /**
     * 退出登录
     *
     * @return
     */
    void logout();
}