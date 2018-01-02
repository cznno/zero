package person.cznno.zero.admin.dto;

import lombok.Data;

import java.util.List;

/**
 * Created by cznno
 * Date: 18-1-2
 */
@Data
public class UserInfoDTO {

    //id
    private Integer id;
    //用户名
    private String username;
    //真名
    private String realName;
    //菜单列表
    private List<String> menuList;
    //权限列表
    private List<String> permissionList;
}
