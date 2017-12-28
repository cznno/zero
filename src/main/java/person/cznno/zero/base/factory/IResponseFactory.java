package person.cznno.zero.base.factory;

import person.cznno.zero.base.enums.StatusEnum;
import person.cznno.zero.base.model.response.Response;

/**
 * Created by cznno
 * Date: 17-12-28
 */
public interface IResponseFactory<T> {

    Response getResponse(StatusEnum anEnum, T data);

    Response getResponse(StatusEnum anEnum);
}
