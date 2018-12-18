package org.project.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author weitangzhao
 **/
public class LoginUrlEntryPoint extends LoginUrlAuthenticationEntryPoint {

    private PathMatcher pathMatcher = new AntPathMatcher();

    private final Map<String, String> authEntryMap;

    public LoginUrlEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
        authEntryMap = new HashMap<>();
        //学生登录入口
        authEntryMap.put("/student/**", "/student/login");
        //管理员登录入口
        authEntryMap.put("/admin/**", "/admin/login");
        //修理工人登录入口
        authEntryMap.put("/repairman/**", "/repairman/login");
    }

    /**
     * 根据请求跳转到指定页面
     * @param request
     * @param response
     * @param exception
     * @return
     */
    @Override
    protected String determineUrlToUseForThisRequest(HttpServletRequest request,
                                                     HttpServletResponse response, AuthenticationException exception) {
        String uri = request.getRequestURI().replace(request.getContextPath(), "");
        for (Map.Entry<String, String> auth : this.authEntryMap.entrySet()){
            if (this.pathMatcher.match(auth.getKey(), uri)){
                return auth.getValue();
            }
        }
        return super.determineUrlToUseForThisRequest(request, response, exception);
    }
}
