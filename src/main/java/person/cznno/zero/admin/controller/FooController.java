package person.cznno.zero.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import person.cznno.zero.admin.service.FooService;

/**
 * Created by cznno
 * Date: 18-1-5
 */
@Controller
public class FooController {
    @Autowired
    private FooService fooService;
}
