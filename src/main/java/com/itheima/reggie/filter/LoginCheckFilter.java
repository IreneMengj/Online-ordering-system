package com.itheima.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.itheima.reggie.common.BaseContext;
import com.itheima.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    //path mather which supports *
    public static final AntPathMatcher PATH_MATCHER =new AntPathMatcher();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //1.get uri for the current request
        String requestURI = request.getRequestURI();
        //2.define paths which are not needed to deal with
        String[] uris = new String[]{
            "/employee/login",
            "/employee/logout",
            "/backend/**",
            "/front/**",
            "/common/**",
            "/user/sendMsg",
            "/user/login"
        };
        log.info("intercepted requests: {}",request.getRequestURI());
        //3.identify whether we need to deal with the current request

        for (String uri : uris) {
            boolean match = PATH_MATCHER.match(uri, requestURI);

            if (match) {
                log.info("we don't need to deal with this request: {}",requestURI);
                filterChain.doFilter(request, response);
                return;
            }
        }
        //4.identify whether the user has logged in
        if(request.getSession().getAttribute("employee")!=null){
            log.info("user has logged in");
            Long employeeId = (Long)request.getSession().getAttribute("employee");
            BaseContext.setCurrentId(employeeId);
            long id = Thread.currentThread().getId();
            log.info("thread id is {}",id);
            filterChain.doFilter(request,response);
            return;
        }
        //4.identify whether the user has logged in through mobile app
        if(request.getSession().getAttribute("user")!=null){
            log.info("user has logged in");
            Long userId = (Long)request.getSession().getAttribute("user");
            BaseContext.setCurrentId(userId);

            filterChain.doFilter(request,response);
            return;
        }
        log.info("user has not logged in");
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));

    }
}
