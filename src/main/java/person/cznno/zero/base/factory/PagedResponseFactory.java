package person.cznno.zero.base.factory;

import com.github.pagehelper.PageInfo;
import person.cznno.zero.base.enums.BaseStatusEnum;
import person.cznno.zero.base.enums.CrudStatusEnum;
import person.cznno.zero.base.model.response.BaseResponse;
import person.cznno.zero.base.model.response.PagedResponse;
import person.cznno.zero.base.model.response.Response;

/**
 * 分页返回消息工厂
 * Created by cznno
 * Date: 18-1-8
 */
public class PagedResponseFactory {

    public static Response get(PageInfo data) {
        PagedResponse response = new PagedResponse();
        response.setSuccess(CrudStatusEnum.SELECT_SUCCESS.isSuccess());
        response.setMsg(CrudStatusEnum.SELECT_SUCCESS.getMsg());
        return setInfoData(response,data);
    }

    public static Response get(BaseStatusEnum anEnum, PageInfo data) {
        PagedResponse response = new PagedResponse();
        response.setSuccess(anEnum.isSuccess());
        response.setMsg(anEnum.getMsg());
        return setInfoData(response,data);
    }

    public static Response get(BaseStatusEnum anEnum) {
        BaseResponse response = new BaseResponse();
        response.setSuccess(anEnum.isSuccess());
        response.setMsg(anEnum.getMsg());
        return response;
    }

    public static Response get(Boolean success, String msg, PageInfo data) {
        PagedResponse response = new PagedResponse();
        response.setSuccess(success);
        response.setMsg(msg);
        return setInfoData(response,data);
    }

    public static Response get(Boolean success, String msg) {
        BaseResponse response = new BaseResponse();
        response.setSuccess(success);
        response.setData(msg);
        return response;
    }

    private static PagedResponse setInfoData(PagedResponse response, PageInfo data) {
        response.setPage(data.getPageNum());
        response.setRows(data.getPageSize());
        response.setCount(data.getTotal());
        response.setData(data.getList());
        return response;
    }
}
