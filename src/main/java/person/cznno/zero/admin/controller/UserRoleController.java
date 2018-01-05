package person.cznno.zero.admin.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import person.cznno.zero.admin.entity.UserRoleEntity;
import person.cznno.zero.admin.service.UserRoleService;
import person.cznno.zero.base.model.response.Response;

@Slf4j
@RestController
@RequestMapping("admin/userRole")
public class UserRoleController {
	
	@Autowired
	private UserRoleService userRoleService;
	
	/**
	 * 根据id查询权限
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public UserRoleEntity SelectById(@PathVariable Integer id){
		return userRoleService.selectById(id);
	}

	/**
	 * 新增权限
	 * @param userRole
	 * @return
	 */
	@PostMapping
	public Response insert(UserRoleEntity userRole){
		return userRoleService.insertSelective(userRole);
		
	}
	 /**
     * 修改权限
     *
     * @return
     */
    @PutMapping
    public Response updateById(@RequestBody UserRoleEntity userRole) {
    	
        return userRoleService.updateByIdSelective(userRole);
    }
    /**
     * 按id删除权限
     *
     * @param id
     * @return
     */
	@DeleteMapping("/{id}")
	public Response deleteById(@PathVariable Integer id){
		
		return userRoleService.deleteById(id);
		
	}
	
	
}
