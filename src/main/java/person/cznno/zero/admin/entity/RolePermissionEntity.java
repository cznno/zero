package person.cznno.zero.admin.entity;

import lombok.Data;

import java.util.Date;

/**
 * 角色-权限关联
 * Created by cznno
 * Date: 2017-12-28 14:25:50
 * @version 1.0 
 */
@Data
public class RolePermissionEntity {

    private Integer id;
    //角色id
    private Integer role_id;
    //权限id
    private Integer permission_id;
    private Date create_time;
    private Date update_time;
    //是否有效 1有效     2无效
    private Boolean enabled;
}