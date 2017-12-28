package person.cznno.zero.admin.entity;

import lombok.Data;

import java.util.Date;

/**
 * 用户-角色关联
 * Created by cznno
 * Date: 2017-12-28 14:25:50
 * @version 1.0 
 */
@Data
public class UserRoleEntity {

    private Integer id;
    //用户ID
    private Integer user_id;
    //角色ID
    private Integer role_id;
    //创建时间
    private Date create_time;
    //修改时间
    private Date update_time;
    //启用
    private Boolean enabled;
}