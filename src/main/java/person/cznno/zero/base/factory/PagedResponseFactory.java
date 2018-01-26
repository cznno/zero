package person.cznno.zero.base.factory;

import com.github.pagehelper.PageInfo;
import person.cznno.zero.base.enums.BaseStatusEnum;
import person.cznno.zero.base.enums.CrudStatusEnum;
import person.cznno.zero.base.dto.response.BaseResponse;
import person.cznno.zero.base.dto.response.PagedResponse;
import person.cznno.zero.base.dto.response.Response;

/**
 * 分页返回消息工厂
 * Created by cznno
 * Date: 18-1-8
 */
public class PagedResponseFactory {

    public static<T> Response get(PageInfo<T> data) {
        PagedResponse<T> response = new PagedResponse<>();
        response.setSuccess(CrudStatusEnum.SELECT_SUCCESS.isSuccess());
        response.setMsg(CrudStatusEnum.SELECT_SUCCESS.getMsg());
        return setInfoData(response,data);
    }

    public static<T> Response get(BaseStatusEnum anEnum, PageInfo<T> data) {
        PagedResponse<T> response = new PagedResponse<>();
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

    public static<T> Response get(Boolean success, String msg, PageInfo<T> data) {
        PagedResponse<T> response = new PagedResponse<>();
        response.setSuccess(success);
        response.setMsg(msg);
        return setInfoData(response,data);
    }

    public static<T> Response get(Boolean success, String msg) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setSuccess(success);
        response.setMsg(msg);
        return response;
    }

    private static<T> PagedResponse setInfoData(PagedResponse<T> response, PageInfo<T> data) {
        response.setPage(data.getPageNum());
        response.setRows(data.getPageSize());
        response.setCount(data.getTotal());
        response.setData(data.getList());
        return response;
    }
}
