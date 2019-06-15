package com.chanshiguan365.controller;

import com.chanshiguan365.service.intf.CsgService;
import com.chanshiguan365.util.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
        System.out.println("11");
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

    @RequestMapping(value = "regesiter.htm", method = RequestMethod.POST)
    @ResponseBody
    public String regesiter(HttpServletRequest request, HttpServletResponse response) {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        if (!csgService.checkAccountIsNotExist(account)) {
            return "error01";
        }
        boolean ret = csgService.createNewAccount(account, password);
        return String.valueOf(ret);
    }

    @RequestMapping(value = "login.htm", method = RequestMethod.POST)
    @ResponseBody
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        Map<String, Object> accountInfo = csgService.queryUserAccountInfo(account, password);
        if (accountInfo != null) {
            request.getSession(true).setAttribute("csgId", accountInfo.get("CSGID"));
            //如果选择保存登陆信息
            Cookie idCookie = new Cookie("account", account); //可以使用md5或着自己的加密算法保存
            Cookie passwordCookie = new Cookie("password", password);
            idCookie.setPath("/chanshiguan365/"); //cookie路径问题，在我的其他文章里有专门的讲解
            idCookie.setMaxAge(100);
            passwordCookie.setPath("/chanshiguan365/");
            passwordCookie.setMaxAge(100);
            response.addCookie(idCookie);
            response.addCookie(passwordCookie);
            return "true";
        } else {
            return "false";
        }
    }
}
