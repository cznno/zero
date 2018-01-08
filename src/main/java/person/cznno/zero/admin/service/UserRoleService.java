package person.cznno.zero.admin.service;

import com.github.pagehelper.PageInfo;
import person.cznno.zero.admin.entity.UserRoleEntity;

/**
 * 用户角色业务
 * Created by cznno
 * Date: 18-1-8
 */
public interface UserRoleService {

    /**
     * 查询全部用户角色
     *
     * @param entity 分页参数
     * @return 分页查询结果
     */
    PageInfo<UserRoleEntity> selectAll(UserRoleEntity entity);

    /**
     * 按id查询用户角色
     *
     * @param id 主键
     * @return 用户角色实体
     */
    UserRoleEntity selectById(Integer id);

    /**
     * 插入角色
     *
     * @param userRole 用户角色实体
     * @return 插入结果数
     */
    int insertSelective(UserRoleEntity userRole);

    /**
     * 按id更新角色
     *
     * @param userRole 用户角色实体
     * @return 更新结果数
     */
    int updateByIdSelective(UserRoleEntity userRole);

    /**
     * 按id删除角色
     *
     * @param id 主键
     * @return 删除结果数
     */
    int deleteById(Integer id);
}
