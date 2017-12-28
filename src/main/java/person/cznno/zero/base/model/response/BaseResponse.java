package person.cznno.zero.base.model.response;

import lombok.Getter;
import lombok.Setter;

/**
 * 基本返回消息
 * Created by cznno
 * Date: 17-12-28
 */
@Getter
@Setter
public class BaseResponse<T>  implements Response<T>  {

    private Boolean success;
    private String msg;
    private T data;
}