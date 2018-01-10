package person.cznno.zero.admin.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import person.cznno.zero.admin.entity.UserRoleEntity;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserRoleServiceTest {

    @Autowired
    private UserRoleService userRoleService;

    @Test
    public void testSelectById() {
        UserRoleEntity userRoleEntity = userRoleService.selectById(1);
        assertThat(userRoleEntity.getId()).isEqualTo(1);
    }

    @Test
    public void testInsertSelective() {
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        userRoleEntity.setUserId(1);
        userRoleEntity.setRoleId(1);
        int res = userRoleService.insertSelective(userRoleEntity);
        assertThat(res).isEqualTo(1);
    }

    @Test
    public void testUpdateByIdSelective() {
        UserRoleEntity userRoleEntity = userRoleService.selectById(1);
        userRoleEntity.setUserId(1);
        int res = userRoleService.updateByIdSelective(userRoleEntity);
        assertThat(res).isEqualTo(1);
    }

    @Test
    public void testDeleteById() {
        int res = userRoleService.deleteById(1);
        assertThat(res).isEqualTo(1);
    }
}
