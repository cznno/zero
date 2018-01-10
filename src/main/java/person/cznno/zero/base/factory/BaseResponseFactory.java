package person.cznno.zero.base.factory;

import person.cznno.zero.base.dto.response.BaseResponse;
import person.cznno.zero.base.dto.response.Response;
import person.cznno.zero.base.enums.BaseStatusEnum;

/**
 * 基础返回消息工厂
 * Created by cznno
 * Date: 17-12-28
 */
public class BaseResponseFactory {

    public static Response get(BaseStatusEnum anEnum, Object data) {
        BaseResponse response = new BaseResponse();
        response.setSuccess(anEnum.isSuccess());
        response.setMsg(anEnum.getMsg());
        response.setData(data);
        return response;
    }

    public static Response get(BaseStatusEnum anEnum) {
        BaseResponse response = new BaseResponse();
        response.setSuccess(anEnum.isSuccess());
        response.setMsg(anEnum.getMsg());
        return response;
    }

    public static Response get(Boolean success, String msg, Object data) {
        BaseResponse response = new BaseResponse();
        response.setSuccess(success);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }

    public static Response get(Boolean success, String msg) {
        BaseResponse response = new BaseResponse();
        response.setSuccess(success);
        response.setMsg(msg);
        return response;
    }
}
