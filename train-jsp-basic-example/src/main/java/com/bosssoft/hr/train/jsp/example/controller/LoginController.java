package com.bosssoft.hr.train.jsp.example.controller;


import com.bosssoft.hr.train.jsp.example.pojo.User;
import com.bosssoft.hr.train.jsp.example.service.UserService;
import com.bosssoft.hr.train.jsp.example.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @param
 * @description:
 * @author: Administrator
 * @create: 2020-05-30 10:11
 * @since
 **/

@Slf4j
public class LoginController extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        try {
            super.doGet(req, resp);
            doPost(req,resp);
        } catch (ServletException | IOException e) {
            log.error(e.getLocalizedMessage(), e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {


        String code = req.getParameter("code");
        String password = req.getParameter("password");
        log.info("I'm LoginController");
        log.info(code + "---" + password);

        HttpSession session = req.getSession();
        session.setAttribute("code", code);

        PrintWriter printWriter;

        try {
            printWriter = resp.getWriter();
        } catch (IOException e) {
            log.error(e.getLocalizedMessage(), e);
            return;
        }


        boolean flag = userService.authentication(new User(code, password));
        if (flag) {
            log.info("返回的结果" + "success");
            String result = "success";
            printWriter.print(result);
        } else {
            log.info("返回的结果" + "failed");
            String result = "failed";
            printWriter.print(result);
        }
        printWriter.flush();
        printWriter.close();
    }

}
