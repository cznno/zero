package person.cznno.zero.admin.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import person.cznno.zero.admin.entity.RolePermissionEntity;
import person.cznno.zero.admin.service.RolePermissionService;
import person.cznno.zero.base.model.response.Response;

@Slf4j
@RestController
@RequestMapping("/admin/rolePermission")
public class RolePermissionController {

	@Autowired
	private RolePermissionService rolePermissionService;
	
	/**
	 * 根据id查询权限
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public RolePermissionEntity SelectById(@PathVariable Integer id){
		return rolePermissionService.selectById(id);
	}

	/**
	 * 新增角色权限
	 * @param rolePermission
	 * @return
	 */
	@PostMapping
	public Response insert(RolePermissionEntity rolePermission){
		return rolePermissionService.insertSelective(rolePermission);
		
	}
	 /**
     * 修改角色权限
     *
     * @return
     */
    @PutMapping
    public Response updateById(@RequestBody RolePermissionEntity rolePermission) {
    	
        return rolePermissionService.updateByIdSelective(rolePermission);
    }
    /**
     * 按id删除角色权限
     *
     * @param id
     * @return
     */
	@DeleteMapping("/{id}")
	public Response deleteById(@PathVariable Integer id){
		
		return rolePermissionService.deleteById(id);
		
	}
	
	
}
