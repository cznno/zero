package person.cznno.zero.admin.dao;

import org.springframework.stereotype.Repository;
import person.cznno.zero.admin.dto.UserInfoDTO;
import person.cznno.zero.admin.entity.PermissionEntity;

/**
 * Created by cznno
 * Date: 18-1-2
 */
@Repository
public interface LoginDao {
    UserInfoDTO selectUserInfoByUsername(String username);
}
