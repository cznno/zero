package person.cznno.zero.base.config;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import person.cznno.zero.admin.dao.UserDao;
import person.cznno.zero.admin.dto.LoginUserDTO;
import person.cznno.zero.admin.entity.UserEntity;

import java.io.IOException;
import java.util.List;

@Slf4j
public class UserRealm extends AuthorizingRealm {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();
    //这里注入service会导致事务失效
    @Autowired
    private UserDao userDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Session session = SecurityUtils.getSubject().getSession();
        //查询用户的权限
        ObjectNode permission = (ObjectNode) session.getAttribute("permission");
        log.info("permission的值为:" + permission);
        log.info("本用户权限为:" + permission.get("permissionList"));
        //为当前用户设置角色和权限
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(List.class, String.class);
        try {
            List<String> list = OBJECT_MAPPER.readValue(permission.get("permissionList").toString(), javaType);
            authorizationInfo.addStringPermissions(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return authorizationInfo;
    }

    /**
     * 验证当前登录的Subject
     * LoginController.login()方法中执行Subject.login()时 执行此方法
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        String loginName = (String) authcToken.getPrincipal();
        // 获取用户密码
        String password = new String((char[]) authcToken.getCredentials());
//        LoginUserDTO user = loginService.getUser(loginName, password);
        UserEntity userEntity = userDao.selectByUsernameAndPassword(loginName, password);
        LoginUserDTO user = MODEL_MAPPER.map(userEntity, LoginUserDTO.class);
        if (user == null) {
            //没找到帐号
            throw new UnknownAccountException();
        }
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(),
                user.getPassword(),
                //ByteSource.Util.bytes("salt"), salt=username+salt,采用明文访问时，不需要此句
                getName()
        );
        //session中不需要保存密码
        user.setPassword(null);
        //将用户信息放入session中
        SecurityUtils.getSubject().getSession().setAttribute("user_info", user);
        return authenticationInfo;
    }
}
