//package person.cznno.zero.base.exception;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@ControllerAdvice
//@ResponseBody
//public class GlobalExceptionHandler {
//
//    /**
//     * 所有异常报错
//     * @param request
//     * @param exception
//     * @return
//     * @throws Exception
//     */
//    @ExceptionHandler(value=Exception.class)
//    public String allExceptionHandler(HttpServletRequest request,Exception exception) throws Exception{
//        exception.printStackTrace();
//        return "服务器异常，请联系管理员！";
//    }
//
//}