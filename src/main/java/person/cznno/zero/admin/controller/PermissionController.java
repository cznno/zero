package person.cznno.zero.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import person.cznno.zero.admin.entity.PermissionEntity;
import person.cznno.zero.admin.service.PermissionService;
import person.cznno.zero.base.model.response.Response;

@RestController
@RequestMapping("admin/permission")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;
	
	/**
	 * 根据id查询权限
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public PermissionEntity SelectById(@PathVariable Integer id){
		return permissionService.selectById(id);
	}

	/**
	 * 新增权限
	 * @param permission
	 * @return
	 */
	@PostMapping
	public Response insert(PermissionEntity permission){
		return permissionService.insertSelective(permission);
		
	}
	 /**
     * 修改权限
     *
     * @return
     */
    @PutMapping
    public Response updateById(@RequestBody PermissionEntity permission) {
    	
        return permissionService.updateByIdSelective(permission);
    }
    /**
     * 按id删除权限
     *
     * @param id
     * @return
     */
	@DeleteMapping("/{id}")
	public Response deleteById(@PathVariable Integer id){
		
		return permissionService.deleteById(id);
		
	}
	
	
}
