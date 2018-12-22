package com.chanshiguan365.controller;

import com.chanshiguan365.service.intf.CsgService;
import com.chanshiguan365.util.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by 15082188 on 2018/12/7.
 */
@Controller
public class CsgController {
    private static final Log log = LogFactory.getLog(IndexController.class);
    @Autowired
    CsgService csgService;

    @RequestMapping(value = "csg.htm", method = RequestMethod.POST)
    public String index(HttpServletRequest request) {
        String csgId = request.getParameter("csgId");
        if (StringUtil.isNullOrEmpty(csgId)) {
            return "";
        }
        Map<String, Object> csgInfo = csgService.queryCsgInfo(csgId);
        request.setAttribute("csgInfo", csgInfo);
        return "csg";
    }

    @RequestMapping(value = "csgReg.htm", method = RequestMethod.POST)
    public String csgReg(HttpServletRequest request) {
        String csgId = request.getParameter("csgId");
        if (StringUtil.isNullOrEmpty(csgId)) {
            return "";
        }
        Map<String, Object> csgInfo = csgService.queryCsgInfo(csgId);
        request.setAttribute("csgInfo", csgInfo);
        return "csg";
    }

    @RequestMapping(value = "csgLogin.htm", method = RequestMethod.GET)
    public String csgLogin(HttpServletRequest request, HttpServletResponse response) {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        if (true) {

        }
        Cookie cookie1 = new Cookie("account", "chanshiguan1");
        Cookie cookie2 = new Cookie("password", "123456");
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        return "redirect:index.htm";
    }
}
