package com.skr.controller;

import com.skr.service.impl.TestServiceImpl;
import com.skr.service.intf.TestService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 15082188 on 2018/8/2.
 */

@Controller
public class TestController {
    private static final Log log= LogFactory.getLog(TestController.class);
    @Autowired
    TestService testService;
    @ResponseBody
    @RequestMapping(value="test.action",method = RequestMethod.GET)
    public String testHttpRequest(){
        String a=testService.queryForString();
        log.error("this is a error");
        log.info("this is a test_log");
        return a;
    }

    @RequestMapping(value="testMoney.action",method = RequestMethod.GET)
    public String testMoney(HttpServletRequest request){
        String a=testService.queryForString();
        log.error("this is a error");
        log.info("this is a test_log");
        request.setAttribute("lkm","李康民");
        return "x-money/moneyIndex.ftl";
    }

    static void print(){
        System.out.println("I AM STATIC");
    }
}
