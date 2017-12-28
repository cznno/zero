package person.cznno.zero.base.model.response;

/**
 * 返回消息接口
 * Created by cznno
 * Date: 17-12-28
 */
public interface Response<T> {

    String getMsg();

    void setMsg(String msg);
}
