package person.cznno.zero.admin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import person.cznno.zero.base.model.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * 用户
 * Created by cznno
 * Date: 2017-12-28 14:25:50
 * @version 1.0 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "sys_user")
public class UserEntity extends BaseEntity{

    //用户名
    private String username;
    //密码
    @Column(name = "passwrd")
    private String password;
    //真名
    private String realname;
    //电子邮箱地址
    private String mail_address;
    //电话
    private String phone;
    //是否有效  1有效  2无效
    private Boolean enabled;
    //修改时间
    private Date update_time;
    //创建时间
    private Date create_time;
}