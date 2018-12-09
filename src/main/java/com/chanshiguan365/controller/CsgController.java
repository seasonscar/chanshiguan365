package com.chanshiguan365.controller;

import com.chanshiguan365.service.intf.CardService;
import com.chanshiguan365.service.intf.CsgService;
import com.chanshiguan365.util.RequestUtil;
import com.chanshiguan365.util.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
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
        String csgId=request.getParameter("csgId");
        if(StringUtil.isNullOrEmpty(csgId)){
            return "";
        }
        Map<String, Object> csgInfo = csgService.queryCsgInfo(csgId);
        request.setAttribute("csgInfo", csgInfo);
        return "csg";
    }

    @RequestMapping(value = "csg2.htm", method = RequestMethod.POST)
    public String index2(HttpServletRequest request) {
        String csgId=request.getParameter("csgId");
        if(StringUtil.isNullOrEmpty(csgId)){
            return "";
        }
        Map<String, Object> csgInfo = csgService.queryCsgInfo(csgId);
        request.setAttribute("csgInfo", csgInfo);
        return "csg2";
    }
}
