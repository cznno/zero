package person.cznno.zero.base.factory;

import org.springframework.stereotype.Component;
import person.cznno.zero.base.enums.CrudStatusEnum;
import person.cznno.zero.base.enums.StatusEnum;
import person.cznno.zero.base.model.response.BaseResponse;
import person.cznno.zero.base.model.response.Response;

/**
 * Created by cznno
 * Date: 17-12-28
 */
@Component
public class CrudResponseFactory<T> implements IResponseFactory<T> {

    private static final BaseResponse response = new BaseResponse();

    @Override
    public Response getResponse(StatusEnum anEnum, T data) {

        CrudStatusEnum responseEnum = (CrudStatusEnum) anEnum;
        response.setSuccess(responseEnum.isSuccess());
        response.setMsg(responseEnum.getMsg());
        response.setData(data);
        return response;
    }

    @Override
    public Response getResponse(StatusEnum anEnum) {

        CrudStatusEnum responseEnum = (CrudStatusEnum) anEnum;
        response.setSuccess(responseEnum.isSuccess());
        response.setMsg(responseEnum.getMsg());
        return response;
    }
}
