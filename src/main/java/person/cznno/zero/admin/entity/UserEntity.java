package person.cznno.zero.admin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "sys_user")
public class UserEntity extends BaseEntity {

    //用户名
    private String username;
    //密码
    @Column(name = "passwrd")
    @JsonIgnore
    private String password;
    //真名
    private String realName;
    //电子邮箱地址
    private String mailAddress;
    //电话
    private String phone;
    //是否有效  1有效  2无效
    private Boolean enabled;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    //修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}