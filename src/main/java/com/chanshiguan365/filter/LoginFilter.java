package com.chanshiguan365.filter;

import com.chanshiguan365.service.impl.CsgServiceImpl;
import com.chanshiguan365.service.intf.CsgService;
import com.chanshiguan365.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 15082188 on 2018/12/21.
 */
@Component
public class LoginFilter implements Filter{
    @Autowired
    CsgService csgService;
    private void doBeforeProcessing(ServletRequest request,ServletResponse response) {
        HttpSession session = ((HttpServletRequest) request).getSession(true);
        //首先检查session，若已经登陆则直接忽略一下代码
        if (session.getAttribute("account") != null) {
            return;
        }
        Cookie[] cookies = ((HttpServletRequest) request).getCookies();
        String account = "15850570275";
        String password = "5760909sea";
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
        WebApplicationContext wac= WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        CsgServiceImpl csg=wac.getBean("csgService",CsgServiceImpl.class);
        if (csg.queryUserAccountInfo(account,password)!=null) {
            session = ((HttpServletRequest) request).getSession(true);
,        }
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,ServletException{
        doBeforeProcessing(request,response);
//        String csgId=(String) request.getSession().getAttribute("csgId");
//        if(StringUtil.isNullOrEmpty(csgId)){
//            return "redirect:guideIndex.htm";
//        }else{
//
//        }
        chain.doFilter(request, response);
    }

    public void destroy() {
        System.out.println("----Filter销毁----");
    }

    public void init(FilterConfig arg0) throws ServletException {
        ServletContext context = arg0.getServletContext();
        System.out.println("----Filter初始化----");
    }
}
