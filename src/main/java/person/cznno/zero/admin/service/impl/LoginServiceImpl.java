package person.cznno.zero.admin.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttribute;
import person.cznno.zero.admin.dao.LoginDao;
import person.cznno.zero.admin.dto.LoginUserDTO;
import person.cznno.zero.admin.dto.UserInfoDTO;
import person.cznno.zero.admin.service.LoginService;
import person.cznno.zero.admin.service.UserService;
import person.cznno.zero.base.enums.AuthStatusEnum;
import person.cznno.zero.base.factory.BaseResponseFactory;
import person.cznno.zero.base.model.response.Response;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();
    @Autowired
    private static final BaseResponseFactory RESPONSE_FACTORY = new BaseResponseFactory();
    private AuthStatusEnum authStatusEnum;
    @Autowired
    private UserService userService;
    @Autowired
    private LoginDao loginDao;

    /**
     * 登录表单提交
     *
     * @param userDTO
     * @return
     */
    @Override
    public Response authLogin(LoginUserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        AuthStatusEnum resEnum;
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            currentUser.login(token);
            resEnum = AuthStatusEnum.LOGIN_SUCCESS;
        } catch (AuthenticationException e) {
            resEnum = AuthStatusEnum.LOGIN_FAIL;
        }
        return RESPONSE_FACTORY.getResponse(resEnum.isSuccess(), resEnum.getMsg());
    }

    /**
     * 根据用户名和密码查询对应的用户
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @Override
    public LoginUserDTO getUser(String username, String password) {
//        UserEntity userEntity = userService.getUserByUsernameAndPassword(username, password);
        return MODEL_MAPPER.map(null, LoginUserDTO.class);
    }

    /**
     * 查询当前登录用户的权限等信息
     *
     * @return
     */
    @Override
    public Response getInfo(String username) {
        Session session = SecurityUtils.getSubject().getSession();
        UserInfoDTO userInfoDTO = loginDao.selectUserInfoByUsername(username);
        session.setAttribute("permission", userInfoDTO.getPermissionList());
        return RESPONSE_FACTORY.getResponse(true, userInfoDTO);
    }

    /**
     * 退出登录
     *
     * @return
     */
    @Override
    public Response logout() {
        try {
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.logout();
        } catch (Exception e) {
            return RESPONSE_FACTORY.getResponse(AuthStatusEnum.LOGOUT_FAIL);
        }
        return RESPONSE_FACTORY.getResponse(AuthStatusEnum.LOGOUT_SUCCESS);
    }
}