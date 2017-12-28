package person.cznno.zero.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    @Resource
    private UserService userService;

    @GetMapping
    public List<UserEntity> getAll(UserEntity userEntity){
        return userService.getAll(userEntity);
    }
}
