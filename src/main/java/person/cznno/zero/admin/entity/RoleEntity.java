package person.cznno.zero.admin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import person.cznno.zero.base.model.entity.BaseEntity;

import javax.persistence.Table;
import java.util.Date;

/**
 * 角色
 * Created by cznno
 * Date: 2017-12-28 14:25:50
 * @version 1.0 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name="sys_role")
public class RoleEntity extends BaseEntity {

    //角色名
    private String roleName;
    //是否有效  1有效  2无效
    private Byte enabled;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
}