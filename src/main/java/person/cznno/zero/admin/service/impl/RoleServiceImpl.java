package person.cznno.zero.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import person.cznno.zero.admin.dao.RoleDao;
import person.cznno.zero.admin.entity.RoleEntity;
import person.cznno.zero.admin.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public PageInfo<RoleEntity> selectAll(RoleEntity entity) {
        return PageHelper.startPage(entity.getPage(), entity.getRows())
                .doSelectPageInfo(() -> roleDao.selectAll());
    }

    @Override
    public RoleEntity selectById(Integer id) {
        return roleDao.selectByPrimaryKey(id);
    }

    @Override
    public int insertSelective(RoleEntity role) {
        return roleDao.insertSelective(role);
    }

    @Override
    public int updateByIdSelective(RoleEntity role) {
        return roleDao.updateByPrimaryKeySelective(role);
    }

    @Override
    public int deleteById(@PathVariable Integer id) {
        return roleDao.deleteByPrimaryKey(id);
    }
}
