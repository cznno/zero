package person.cznno.zero.admin.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import person.cznno.zero.admin.dao.UserDao;
import person.cznno.zero.admin.dto.LoginUserDTO;
import person.cznno.zero.admin.entity.UserEntity;
import person.cznno.zero.admin.service.LoginService;
import person.cznno.zero.admin.service.UserService;
import person.cznno.zero.base.model.response.Response;

import javax.annotation.Resource;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    private static final ModelMapper modelMapper = new ModelMapper();
    @Resource
    private UserService userService;
//    @Resource
//    private PermissionService permissionService;

    /**
     * 登录表单提交
     *
     * @param loginUser
     * @return
     */
//    @Override
//    public Response authLogin(LoginUserDTO loginUser) {
//
//        Subject currentUser = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(loginUser.getUsername(), loginUser.getPassword());
//        try {
//            currentUser.login(token);
//            returnData.put("result", "success");
//        } catch (AuthenticationException e) {
//            returnData.put("result", "fail");
//        }
//        return CommonUtil.successJson(returnData);
//    }

    @Override
    public Response authLogin(LoginUserDTO jsonObject) {
        return null;
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
        UserEntity userEntity = userService.getUserByUsernameAndPassword(username, password);
        return modelMapper.map(userEntity, LoginUserDTO.class);
    }

    @Override
    public void getInfo() {

    }

    @Override
    public void logout() {

    }

    /**
     * 查询当前登录用户的权限等信息
     *
     * @return
     */
//    @Override
//    public JSONObject getInfo() {
//        //从session获取用户信息
//        Session session = SecurityUtils.getSubject().getSession();
//        JSONObject userInfo = (JSONObject) session.getAttribute(Constants.SESSION_USER_INFO);
//        String username = userInfo.getString("username");
//        JSONObject returnData = new JSONObject();
//        JSONObject userPermission = permissionService.getUserPermission(username);
//        session.setAttribute(Constants.SESSION_USER_PERMISSION, userPermission);
//        returnData.put("userPermission", userPermission);
//        return CommonUtil.successJson(returnData);
//    }

    /**
     * 退出登录
     *
     * @return
     */
//    @Override
//    public JSONObject logout() {
//        try {
//            Subject currentUser = SecurityUtils.getSubject();
//            currentUser.logout();
//        } catch (Exception e) {
//        }
//        return CommonUtil.successJson();
//    }
}