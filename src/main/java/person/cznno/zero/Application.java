package person.cznno.zero;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.Properties;

@SpringBootApplication
@Configuration
@ControllerAdvice
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Exc
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("status", HttpStatus.FORBIDDEN.value());
//        map.put("message", "No message avaeptionHandler(AuthorizationException.class)
////    @ResponseStatus(HttpStatus.FORBIDDEN)
////    public String handleException(AuthorizationException e, Model model) {
////
////        // you could return a 404 here instead (this is how github handles 403, so the user does NOT know there is a
////        // resource at that location)
////        log.debug("AuthorizationException was thrown", e);
////ilable");
//        model.addAttribute("errors", map);
//
//        return "error";
//    }

//    /**
//     * 事务配置
//     * @param platformTransactionManager
//     * @return
//     */
//    @Bean(name = "transactionInterceptor")
//    public TransactionInterceptor transactionInterceptor(PlatformTransactionManager platformTransactionManager) {
//        TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
//        // 事物管理器
//        transactionInterceptor.setTransactionManager(platformTransactionManager);
//        Properties transactionAttributes = new Properties();
//        // 新增
//        transactionAttributes.setProperty("insert*","PROPAGATION_REQUIRED,-Throwable");
//        // 修改
//        transactionAttributes.setProperty("update*","PROPAGATION_REQUIRED,-Throwable");
//        // 删除
//        transactionAttributes.setProperty("delete*","PROPAGATION_REQUIRED,-Throwable");
//        //查询
//        transactionAttributes.setProperty("select*","PROPAGATION_REQUIRED,-Throwable,readOnly");
//
//        transactionInterceptor.setTransactionAttributes(transactionAttributes);
//        return transactionInterceptor;
//    }
//    //代理到ServiceImpl的Bean
//    @Bean
//    public BeanNameAutoProxyCreator transactionAutoProxy() {
//        BeanNameAutoProxyCreator transactionAutoProxy = new BeanNameAutoProxyCreator();
//        transactionAutoProxy.setProxyTargetClass(true);
//        transactionAutoProxy.setBeanNames("*ServiceImpl");
//        transactionAutoProxy.setInterceptorNames("transactionInterceptor");
//        return transactionAutoProxy;
//    }
}
