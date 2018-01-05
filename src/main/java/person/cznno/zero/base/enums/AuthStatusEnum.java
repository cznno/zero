package person.cznno.zero.base.enums;

/**
 * Created by cznno
 * Date: 18-1-2
 */
public enum AuthStatusEnum implements CommonStatusEnum{

    LOGIN_SUCCESS(true, "登录成功"),
    LOGIN_FAIL(false, "登录失败"),
    PERMISSION_DENY(false,"没有权限"),
    REQUIRE_LOGIN(false,"需要登录"),
    LOGOUT_SUCCESS(true,"登出成功"),
    LOGOUT_FAIL(false,"登出失败"),
	REGISTER_SUCCESS(true,"注册成功"),
	REGISTER_FAIL(false,"注册失败"),
	REGISTER_REPEAT(false,"注册失败,重复注册");

    private Boolean success;
    private String msg;

    AuthStatusEnum(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public Boolean isSuccess() {
        return success;
    }
}