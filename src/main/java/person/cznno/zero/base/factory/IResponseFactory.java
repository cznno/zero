package person.cznno.zero.base.factory;

import person.cznno.zero.base.enums.StatusEnum;
import person.cznno.zero.base.dto.response.Response;

/**
 * 回复消息工厂接口
 * Created by cznno
 * Date: 17-12-28
 */
public interface IResponseFactory<T> {

    Response getResponse(StatusEnum anEnum, T data);

    Response getResponse(StatusEnum anEnum);
}
