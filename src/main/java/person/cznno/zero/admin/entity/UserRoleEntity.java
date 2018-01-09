package person.cznno.zero.admin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import person.cznno.zero.base.entity.BaseEntity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 用户-角色关联
 * Created by cznno
 * Date: 2017-12-28 14:25:50
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name="sys_user_role")
public class UserRoleEntity extends BaseEntity{

    //用户ID
    private Integer userId;
    //角色ID
    private Integer roleId;
    //启用
    private Boolean enabled;
    //创建时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    //修改时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;
}