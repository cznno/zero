package person.cznno.zero;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@MapperScan(basePackages = "person.cznno.zero.*.dao")
@Configuration
@ControllerAdvice
@Slf4j
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
        SpringApplication application = new SpringApplication(Application.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(Application.class);
    }

//    @ExceptionHandler(AuthorizationException.class)
//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    public String handleException(AuthorizationException e, Model model) {
//
//        // you could return a 404 here instead (this is how github handles 403, so the user does NOT know there is a
//        // resource at that location)
//        log.debug("AuthorizationException was thrown", e);
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("status", HttpStatus.FORBIDDEN.value());
//        map.put("message", "No message available");
//        model.addAttribute("errors", map);
//
//        return "error";
//    }
}
