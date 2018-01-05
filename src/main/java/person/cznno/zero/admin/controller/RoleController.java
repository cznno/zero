package person.cznno.zero.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import person.cznno.zero.admin.entity.RoleEntity;
import person.cznno.zero.admin.service.RoleService;
import person.cznno.zero.base.model.response.Response;

@RestController
@RequestMapping("/admin/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	/**
	 * 新增角色
	 * @param role
	 * @return
	 */
	@PostMapping
	public Response insert(RoleEntity role){
		return roleService.insert(role);
		
	}
	/**
     * 按id查询角色
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public RoleEntity selectById(@PathVariable("id") Integer id) {
//    	int i = 1/0;
        return roleService.selectById(id);
    }
	 /**
     * 修改角色
     *
     * @return
     */
    @PutMapping
    public Response updateById(@RequestBody RoleEntity role) {
    	
        return roleService.updateByIdSelective(role);
       
    }

    /**
     * 按id删除角色
     *
     * @param id
     * @return
     */
	@DeleteMapping("/{id}")
	public Response deleteById(@PathVariable Integer id){
		
		return roleService.deleteById(id);
		
	}
	
	
}
