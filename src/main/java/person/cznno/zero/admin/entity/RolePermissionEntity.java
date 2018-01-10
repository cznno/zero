package person.cznno.zero.admin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import person.cznno.zero.base.entity.BaseEntity;

import javax.persistence.Table;
import java.util.Date;

/**
 * 角色-权限关联
 * Created by cznno
 * Date: 2017-12-28 14:25:50
 */
@Data
@EqualsAndHashCode
@Table(name="sys_role_permission")
public class RolePermissionEntity extends BaseEntity{

    //角色id
    private Integer roleId;
    //权限id
    private Integer permissionId;
    //创建时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    //修改时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;
    //是否有效 1有效     2无效
    private Boolean enabled;
}