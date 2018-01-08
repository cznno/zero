package person.cznno.zero.base.factory;

import person.cznno.zero.base.enums.BaseStatusEnum;
import person.cznno.zero.base.model.response.BaseResponse;
import person.cznno.zero.base.model.response.Response;

/**
 * Created by cznno
 * Date: 17-12-28
 */
public class BaseResponseFactory {

    public static Response getResponse(BaseStatusEnum anEnum, Object data) {
        BaseResponse response = new BaseResponse();
//        BaseStatusEnum commonStatusEnum = (BaseStatusEnum) anEnum;
        response.setSuccess(anEnum.isSuccess());
        response.setMsg(data.toString());
        return response;
    }

    public Response getResponse(BaseStatusEnum anEnum) {
        BaseResponse response = new BaseResponse();
//        BaseStatusEnum commonStatusEnum = (BaseStatusEnum) anEnum;
        response.setSuccess(anEnum.isSuccess());
        response.setMsg(anEnum.getMsg());
        return response;
    }
}
