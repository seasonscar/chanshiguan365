package com.chanshiguan365.controller;


import com.chanshiguan365.service.intf.CardService;
import com.chanshiguan365.service.intf.CsgService;
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
    @Autowired
    CsgService csgService;

    @RequestMapping(value = "guideIndex.htm", method = RequestMethod.GET)
    public String guideIndex(HttpServletRequest request) {
        String csgId = (String) request.getSession().getAttribute("csgId");
        System.out.println("当前登录chanshiguan:" + csgId);
        if (StringUtil.isNullOrEmpty(csgId)) {
            return "guideIndex";
        } else {
            return "redirect:index.htm";
        }
    }

    @RequestMapping(value = "index.htm", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        String csgId = (String) request.getSession().getAttribute("csgId");
        if (StringUtil.isNullOrEmpty(csgId)) {
            return "redirect:guideIndex.htm";
        }
        List<Map<String, Object>> cardList = cardService.queryCardList();
        List<Map<String, Object>> csgCardList = cardService.queryCardListByCsgId(csgId);
        Map<String, Object> csgInfo = csgService.queryCsgInfo(csgId);
        request.setAttribute("csgInfo", csgInfo);
        System.out.println(request.getSession().getAttribute("csgId"));
        request.setAttribute("cardList", cardList);
        request.setAttribute("csgCardList", csgCardList);
        request.setAttribute("ip", RequestUtil.getIpAddress(request));
        return "index";
    }

    @RequestMapping(value = "upload.htm", method = RequestMethod.POST)
    @ResponseBody
    public String upload(HttpServletRequest request) {
        String csgId = (String) request.getSession().getAttribute("csgId");

        if (StringUtil.isNullOrEmpty(csgId)) {
            return "redirect:guideIndex.htm";
        }
        String croperImgCode = request.getParameter("croperImgCode");
        String cardNote=request.getParameter("cardnote");
        if (StringUtil.isNullOrEmpty(croperImgCode) || croperImgCode.length() < 23) {
            return "false";
        }
        boolean r = cardService.createCard(csgId, croperImgCode,cardNote);
        return String.valueOf(r);
    }

    @RequestMapping(value = "card.htm", method = RequestMethod.POST)
    public String card(HttpServletRequest request) {
        String cardId = request.getParameter("cardId");
        if (StringUtil.isNullOrEmpty(cardId)) {
            return "error";
        }
        Map<String, Object> cardInfo = cardService.queryCardInfo(cardId);
        request.setAttribute("card", cardInfo);
        return "card";
    }
}
