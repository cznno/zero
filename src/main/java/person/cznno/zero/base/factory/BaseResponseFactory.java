package person.cznno.zero.base.factory;

import org.springframework.stereotype.Component;
import person.cznno.zero.base.enums.CommonStatusEnum;
import person.cznno.zero.base.enums.StatusEnum;
import person.cznno.zero.base.model.response.BaseResponse;
import person.cznno.zero.base.model.response.Response;

/**
 * Created by cznno
 * Date: 17-12-28
 */
@Component
public class BaseResponseFactory implements IResponseFactory {

    private static final BaseResponse response = new BaseResponse();

    @Override
    public Response getResponse(StatusEnum anEnum, Object data) {

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
}
