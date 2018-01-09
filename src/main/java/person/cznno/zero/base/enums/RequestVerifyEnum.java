package person.cznno.zero.base.enums;

/**
 * Created by cznno
 * Date: 18-1-9
 */
public enum RequestVerifyEnum implements StatusEnum {

    PARAM_ERROR("请求的参数不合法");

    private String msg;

    RequestVerifyEnum(String msg) {
        this.msg = msg;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
