package com.skr.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * Created by 15082188 on 2018/8/6.
 */
public class TestServlet extends HttpServlet {
    private String testStr;

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            String a = "this is a test servlet";
            String b = testStr;

            response.flushBuffer();
            String param=this.getInitParameter("testStr");
            String c="";
            response.setContentType("text/json; charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
