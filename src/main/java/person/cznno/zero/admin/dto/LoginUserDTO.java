package person.cznno.zero.admin.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Created by cznno
 * Date: 17-12-28
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginUserDTO {

    //用户名
    private String username;
    //密码
    private String password;
    //是否有效  1有效  2无效
    private Boolean enabled;
}
