package person.cznno.zero.base.aop;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import person.cznno.zero.base.enums.AuthStatusEnum;
import person.cznno.zero.base.exception.CheckException;
import person.cznno.zero.base.model.response.BaseResponse;
import person.cznno.zero.base.model.response.Response;

/**
 * Created by cznno
 * Date: 18-1-3
 */
@Aspect
@Component
@Slf4j
public class ControllerAspect {

    @Pointcut("execution(public * person.cznno.zero.*.controller..*(..))")
    public void controllerAspect() {}

    @Around("controllerAspect()")
    public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();

        Response result;

        try {
            log.info("aaabbb");
            result = (Response) pjp.proceed();
            log.info(pjp.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));
        } catch (Throwable e) {
            result = handlerException(pjp, e);
        }

        return result;
    }

    private Response handlerException(ProceedingJoinPoint pjp, Throwable e) {
        BaseResponse result = new BaseResponse();

        // 已知异常
        if (e instanceof CheckException) {
            result.setMsg(e.getLocalizedMessage());
            result.setSuccess(false);
        }else if(e instanceof AuthenticationException){
            result.setMsg(AuthStatusEnum.LOGIN_FAIL.getMsg());
            result.setSuccess(false);
        }
        else {
            log.error(pjp.getSignature() + " error ", e);
            //TODO 未知的异常，应该格外注意，可以发送邮件通知等
            result.setMsg(e.toString());
            result.setSuccess(false);
        }

        return result;
    }
}
