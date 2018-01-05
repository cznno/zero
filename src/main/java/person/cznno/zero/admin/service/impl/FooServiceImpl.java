package person.cznno.zero.admin.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.cznno.zero.admin.dao.LoginDao;
import person.cznno.zero.admin.service.FooService;
import person.cznno.zero.admin.service.UserService;
import person.cznno.zero.base.factory.BaseResponseFactory;

/**
 * Created by cznno
 * Date: 18-1-5
 */
@Service
@Slf4j
public class FooServiceImpl implements FooService{
    @Autowired
    private static final BaseResponseFactory RESPONSE_FACTORY = new BaseResponseFactory();
    @Autowired
    private UserService userService;
    @Autowired
    private LoginDao loginDao;
}
