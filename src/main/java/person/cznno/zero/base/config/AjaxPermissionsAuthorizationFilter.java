package person.cznno.zero.base.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import person.cznno.zero.base.dto.response.Response;
import person.cznno.zero.base.enums.AuthStatusEnum;
import person.cznno.zero.base.factory.BaseResponseFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AjaxPermissionsAuthorizationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("returnCode", ErrorEnum.E_20011.getErrorCode());
//        jsonObject.put("returnMsg", ErrorEnum.E_20011.getErrorMsg());
        HttpServletResponse res = (HttpServletResponse) response;
        res.setCharacterEncoding("UTF-8");
        res.setContentType("application/json");
        PrintWriter out = response.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        Response restResponse = BaseResponseFactory.get(AuthStatusEnum.REQUIRE_LOGIN);
        out.println(objectMapper.writeValueAsString(restResponse));
        if (null != out) {
            out.flush();
            out.close();
        }
        return false;
    }

    @Bean
    public FilterRegistrationBean registration(AjaxPermissionsAuthorizationFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);
        return registration;
    }
}