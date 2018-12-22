package com.chanshiguan365.controller;


import com.chanshiguan365.service.intf.CardService;
import com.chanshiguan365.util.Base64Util;
import com.chanshiguan365.util.RequestUtil;
import com.chanshiguan365.util.StringUtil;
import com.chanshiguan365.util.UUIDGenerator;
import com.skr.service.intf.TestService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Random;

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

    @RequestMapping(value = "upload.htm", method = RequestMethod.POST)
    @ResponseBody
    public String upload(HttpServletRequest request) {
        String csgId=request.getParameter("csgId");
        Random ran=new Random();
        int i=ran.nextInt(8);
        csgId=String.valueOf(i);
        String croperImgCode=request.getParameter("croperImgCode");
        if(StringUtil.isNullOrEmpty(croperImgCode)||croperImgCode.length()<23){
            return "false";
        }
        boolean r=cardService.createCard(csgId,croperImgCode);
        return String.valueOf(r);
    }
}
