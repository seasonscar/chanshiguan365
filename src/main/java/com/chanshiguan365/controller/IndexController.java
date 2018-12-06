package com.chanshiguan365.controller;


import com.chanshiguan365.service.intf.CardService;
import com.chanshiguan365.util.RequestUtil;
import com.skr.service.intf.TestService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by 15082188 on 2018/12/6.
 */

@Controller
public class IndexController {
    private static final Log log = LogFactory.getLog(IndexController.class);
    @Autowired
    CardService cardService;

    @RequestMapping(value = "index.htm", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        List<Map<String,Object>> cardList=cardService.queryCardList();
        request.setAttribute("cardList",cardList);
        request.setAttribute("ip", RequestUtil.getIpAddress(request));
        return "index";
    }
}
