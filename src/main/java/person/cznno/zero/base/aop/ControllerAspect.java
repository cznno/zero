package person.cznno.zero.base.aop;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import person.cznno.zero.base.dto.response.BaseResponse;
import person.cznno.zero.base.dto.response.Response;
import person.cznno.zero.base.enums.AuthStatusEnum;
import person.cznno.zero.base.enums.RequestVerifyEnum;
import person.cznno.zero.base.exception.CrudException;
import person.cznno.zero.base.exception.NoPermissionException;
import person.cznno.zero.base.exception.ParamErrorException;

import javax.servlet.http.HttpServletRequest;

/**
 * 所有controller的切面
 * 记录日志及异常处理
 * Created by cznno
 * Date: 18-1-3
 */
@Aspect
@Component
@Slf4j
@Order(1)
public class ControllerAspect {

    @Pointcut("execution(public * person.cznno.zero.*.controller..*(..))")
    public void controllerAspect() {}

    @Around("controllerAspect()")
    public Object handlerControllerMethod(ProceedingJoinPoint pjp) {

        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        log.info("收到请求:\n url: {}\n method: {}\n uri: {}\n params: {}", url, method, uri, queryString);

        long startTime = System.currentTimeMillis();

        Response result;

        try {
            result = (Response) pjp.proceed();
            log.info(pjp.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));
        } catch (Throwable e) {
            result = handlerException(pjp, e);
        }
        return result;
    }

    private Response handlerException(ProceedingJoinPoint pjp, Throwable e) {

        BaseResponse result = new BaseResponse();
        result.setSuccess(false);
        log.error(pjp.getSignature() + " error ", e);

        // 已知异常
        if (e instanceof AuthenticationException) {
            result.setMsg(AuthStatusEnum.LOGIN_FAIL_NOT_MATCH.getMsg());
        } else if (e instanceof NoPermissionException) {
            result.setMsg(AuthStatusEnum.PERMISSION_DENY.getMsg());
        } else if (e instanceof ParamErrorException) {
            result.setMsg(RequestVerifyEnum.PARAM_ERROR.getMsg());
        } else if (e instanceof CrudException) {
            result.setMsg(e.getMessage());
        } else {
//            log.error(pjp.getSignature() + " error ", e);
            //TODO 未知的异常，应该格外注意，可以发送邮件通知等
            result.setMsg(e.toString());
        }
        return result;
    }
}
