package person.cznno.zero.admin.entity;

import lombok.Data;

import java.util.Date;

/**
 * 角色
 * Created by cznno
 * Date: 2017-12-28 14:25:50
 * @version 1.0 
 */
@Data
public class RoleEntity {

    private Integer id;
    //角色名
    private String roleName;
    //是否有效  1有效  2无效
    private Byte enabled;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
}