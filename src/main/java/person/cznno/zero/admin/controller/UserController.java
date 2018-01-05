package person.cznno.zero.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import person.cznno.zero.admin.entity.UserEntity;
import person.cznno.zero.admin.service.AUserService;

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
    private AUserService AUserService;

//    @RequiresPermissions("article:list")
    @GetMapping
    public List<UserEntity> getAll(UserEntity userEntity) {
        return AUserService.getAll(userEntity);
    }

    @GetMapping("a/{id}")
    public UserEntity get(@PathVariable  Integer id) {
        return AUserService.getById(id);
    }

    @PostMapping
    public int insertUser(@RequestBody  UserEntity user){
        return AUserService.insertSelective(user);
    }
}
