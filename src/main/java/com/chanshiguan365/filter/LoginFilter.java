package com.chanshiguan365.filter;

import com.chanshiguan365.service.intf.CsgService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 15082188 on 2018/12/21.
 */
public class LoginFilter implements Filter{
    @Autowired
    CsgService csgService;
    private void doBeforeProcessing(ServletRequest request) {
        HttpSession session = ((HttpServletRequest) request).getSession(true);
        //首先检查session，若已经登陆则直接忽略一下代码
        if (session.getAttribute("account") != null) {
            return;
        }
        Cookie[] cookies = ((HttpServletRequest) request).getCookies();
        String account = null;
        String password = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("account")) {
                    account = c.getValue();
                }
                if (c.getName().equals("password")) {
                    password = c.getValue();
                }
            }
        }
        if (csgService.queryUserAccountInfo(account,password)!=null) {
            session = ((HttpServletRequest) request).getSession(true);
            session.setAttribute("account", account);
        }
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,ServletException{
        doBeforeProcessing(request);
        chain.doFilter(request, response);
    }

    public void destroy() {
        System.out.println("----Filter销毁----");
    }

    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("----Filter初始化----");
    }
}
