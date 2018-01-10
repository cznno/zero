package person.cznno.zero.admin.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.cznno.zero.admin.dao.LoginDao;
import person.cznno.zero.admin.dto.LoginUserDTO;
import person.cznno.zero.admin.dto.UserInfoDTO;
import person.cznno.zero.admin.service.LoginService;
import person.cznno.zero.base.enums.AuthStatusEnum;
/**
 * Created by cznno
 * Date: 18-1-5
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    /**
     * 登录表单提交
     *
     * @param userDTO 用户登录信息
     * @return 登录验证信息
     */
    @Override
    public AuthStatusEnum authLogin(LoginUserDTO userDTO) throws AuthenticationException {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        try {
        currentUser.login(token);
//        } catch (AuthenticationException e) {
//            authStatusEnum = AuthStatusEnum.LOGIN_FAIL;
//        }
        return AuthStatusEnum.LOGIN_SUCCESS;
    }

    /**
     * 查询当前登录用户的权限等信息
     *
     * @return 用户的权限,菜单等信息
     */
    @Override
    public UserInfoDTO getInfo(String username) {
        Session session = SecurityUtils.getSubject().getSession();
        UserInfoDTO userInfoDTO = loginDao.selectUserInfoByUsername(username);
        session.setAttribute("role", userInfoDTO.getRoleList());
        session.setAttribute("permission", userInfoDTO.getPermissionList());
        return userInfoDTO;
    }

    /**
     * 退出登录
     *
     * @return 成功与否
     */
    @Override
    public AuthStatusEnum logout() {
        try {
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.logout();
        } catch (Exception e) {
            return AuthStatusEnum.LOGOUT_FAIL;
        }
        return AuthStatusEnum.LOGOUT_SUCCESS;
    }
}