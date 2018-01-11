package person.cznno.zero.admin.service;

import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import person.cznno.zero.admin.entity.RoleEntity;
import person.cznno.zero.admin.entity.RolePermissionEntity;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Create by Cuiguibin
 * Date: 2018年1月9日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class RoleServiceTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void testSelectAll() {
        RoleEntity entity = new RoleEntity();
        entity.setPage(1);
        entity.setRows(5);
        PageInfo<RoleEntity> pageInfo2 = roleService.selectAll(entity);
        assertThat(pageInfo2.getSize()).isGreaterThan(0);
    }

    @Test
    public void testSelectById() {
        RoleEntity roleEntity = roleService.selectById(1);
        assertThat(roleEntity.getId()).isEqualTo(1);
    }

    @Test
    public void testInsert() {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleName("testRolename");
        int res = roleService.insertSelective(roleEntity);
        assertThat(res).isEqualTo(1);
    }

    @Test
    public void testUpdateByIdSelective() {
        RoleEntity roleEntity = roleService.selectById(1);
        roleEntity.setRoleName("testRolename");
        roleEntity.setId(1);
        int res = roleService.updateByIdSelective(roleEntity);
        assertThat(res).isEqualTo(1);
    }

    @Test
    public void testDeleteById() {
        int res = roleService.deleteById(8);
        assertThat(res).isEqualTo(1);
    }
}
