package person.cznno.zero.base.factory;

import org.springframework.stereotype.Component;
import person.cznno.zero.base.enums.CommonStatusEnum;
import person.cznno.zero.base.enums.StatusEnum;
import person.cznno.zero.base.model.response.BaseResponse;
import person.cznno.zero.base.model.response.Response;

import java.util.List;

/**
 * Created by cznno
 * Date: 17-12-28
 */
@Component
public class BaseResponseFactory<T> implements IResponseFactory<T> {

    private static final BaseResponse response = new BaseResponse();

    @Override
    public  Response getResponse(StatusEnum anEnum, T data) {
        CommonStatusEnum commonStatusEnum = (CommonStatusEnum) anEnum;
        response.setSuccess(commonStatusEnum.isSuccess());
        response.setMsg(data.toString());
        return response;
    }

    @Override
    public Response getResponse(StatusEnum anEnum) {
        CommonStatusEnum commonStatusEnum = (CommonStatusEnum) anEnum;
        response.setSuccess(commonStatusEnum.isSuccess());
        response.setMsg(commonStatusEnum.getMsg());
        return response;
    }

    public Response getResponse(Boolean success,String msg,T data){
        response.setSuccess(success);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }

    public Response getResponse(Boolean success,T data){
        response.setSuccess(success);
        response.setData(data);
        return response;
    }

    public static Response get(String str){
        response.setMsg(str);
        return response;
    }
}
