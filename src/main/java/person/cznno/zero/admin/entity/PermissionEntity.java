package person.cznno.zero.admin.entity;

import lombok.Data;

import java.util.Date;

/**
 * 权限
 * Created by cznno
 * Date: 2017-12-28 14:25:50
 * @version 1.0 
 */
@Data
public class PermissionEntity {

    //自定id,主要供前端展示权限列表分类排序使用.
    private Integer id;
    //归属菜单,前端判断并展示菜单使用,
    private String menuCode;
    //菜单的中文释义
    private String menuName;
    //权限的代码/通配符,对应代码中@RequiresPermissions 的value
    private String permissionCode;
    //本权限的中文释义
    private String permissionName;
    //是否本菜单必选权限, 1.必选 2非必选 通常是"列表"权限是必选
    private Boolean requiredPermission;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //启用
    private Boolean enabled;
}