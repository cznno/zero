package person.cznno.zero.admin.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import person.cznno.zero.admin.entity.PermissionEntity;
import person.cznno.zero.admin.entity.RolePermissionEntity;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class RolePermissionServiceTest {

    @Autowired
    private RolePermissionService rolePermissionService;

    @Test
    public void testSelectById() {
        RolePermissionEntity rolePermissionEntity = rolePermissionService.selectById(1);
        assertThat(rolePermissionEntity.getId()).isEqualTo(1);
    }

    @Test
    public void testInsertSelective() {
        RolePermissionEntity permissionEntity = new RolePermissionEntity();
        permissionEntity.setRoleId(1);
        int res = rolePermissionService.insertSelective(permissionEntity);
        assertThat(res).isEqualTo(1);
    }

    @Test
    public void testUpdateByIdSelective() {
        RolePermissionEntity rolePermissionEntity = rolePermissionService.selectById(1);
        rolePermissionEntity.setRoleId(1);
        rolePermissionEntity.setId(1);
        int res = rolePermissionService.updateByIdSelective(rolePermissionEntity);
        assertThat(res).isEqualTo(1);
    }

    @Test
    public void testDeleteById() {
        int res = rolePermissionService.deleteById(1);
        assertThat(res).isEqualTo(1);
    }
}
