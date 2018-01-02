package person.cznno.zero.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import person.cznno.zero.admin.dao.UserDao;
import person.cznno.zero.admin.dto.LoginUserDTO;
import person.cznno.zero.admin.entity.UserEntity;
import person.cznno.zero.admin.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cznno
 * Date: 17-12-28
 */
@Slf4j
@RestController
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequiresPermissions("article:list")
    @GetMapping
    public List<UserEntity> getAll(UserEntity userEntity,@SessionAttribute("user_info") LoginUserDTO userDTO) {
        System.out.println(userDTO);
        return userService.getAll(userEntity);
    }

    @GetMapping("a/{id}")
    public UserEntity get(@PathVariable  Integer id) {
        return userService.getById(id);
    }
}
