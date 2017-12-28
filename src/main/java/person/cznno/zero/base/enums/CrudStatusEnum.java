package person.cznno.zero.base.enums;

/**
 * Created by cznno
 * Date: 17-12-28
 */
public enum CrudStatusEnum implements CommonStatusEnum {

    GENERAL_SUCCESS("数据库操作成功", true),
    SELECT_SUCCESS("查询成功", true),
    INSERT_SUCCESS("插入成功", true),
    UPDATE_SUCCESS("更新成功", true),
    DELETE_SUCCESS("删除成功", true),
    PRARM_ERROR("参数错误", false),
    SELECT_FAIL("查询失败", false),
    SELECT_NO_RESULT("查询失败,找不到结果", false),
    INSERT_FAIL("插入失败", false),
    UPDATE_FAIL("更新失败", false),
    DELETE_FAIL("删除失败", false),
    DELETE_FAIL_CONSTRAINT("数据存在关联关系，请检查后删除", false),
    GENERAL_FAIL("数据库操作失败", false);

    private String msg;
    private Boolean success;

    CrudStatusEnum(String msg, Boolean success) {
        this.msg = msg;
        this.success = success;
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
