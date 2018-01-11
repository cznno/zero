package person.cznno.zero.admin.service;

import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import person.cznno.zero.admin.entity.PermissionEntity;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PermissionServiceTest {

    @Autowired
    private PermissionService permissionService;

    @Test
    public void testSelectAll() {
        PageInfo<PermissionEntity> pageInfo = permissionService.selectAll(0, 0);
        assertThat(pageInfo.getSize()).isGreaterThan(0);
        PermissionEntity entity = new PermissionEntity();
        entity.setPage(1);
        entity.setRows(5);
        PageInfo<PermissionEntity> pageInfo2 = permissionService.selectAll(entity);
        assertThat(pageInfo2.getSize()).isGreaterThan(0);
    }

    @Test
    public void testSelectById() {
        PermissionEntity permissionEntity = permissionService.selectById(101);
        assertThat(permissionEntity.getId()).isEqualTo(101);
    }

    @Test
    public void testInsertSelective() {
        PermissionEntity permissionEntity = new PermissionEntity();
        permissionEntity.setMenuName("test name");
        int res = permissionService.insertSelective(permissionEntity);
        assertThat(res).isEqualTo(1);
    }

    @Test
    public void testUpdateByIdSelective() {
        PermissionEntity permissionEntity = permissionService.selectById(101);
        permissionEntity.setMenuName("test name");
        int res = permissionService.updateByIdSelective(permissionEntity);
        assertThat(res).isEqualTo(1);
    }

    @Test
    public void testDeleteById() {
        int res = permissionService.deleteById(709);
        assertThat(res).isEqualTo(1);
    }
}
