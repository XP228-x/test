package com.bosssoft.hr.train.jsp.example.controller;


import com.bosssoft.hr.train.jsp.example.pojo.User;
import com.bosssoft.hr.train.jsp.example.service.UserService;
import com.bosssoft.hr.train.jsp.example.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @param
 * @description:
 * @author: Administrator
 * @create: 2020-05-30 11:21
 * @since
 **/

@Slf4j
public class AddUserController extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        log.info("I'm AddController");
        User user = new User();

        try {
            user.setId(Integer.valueOf(req.getParameter("id")));
        } catch (NumberFormatException e) {
            log.error(e.getLocalizedMessage(), e);
        }

        user.setName(req.getParameter("name"));
        user.setCode(req.getParameter("code"));
        user.setPassword(req.getParameter("password"));

        log.info(user.toString());

        try {
            if (userService.save(user)) {
                resp.getWriter().write("success!");
            } else {
                resp.getWriter().write("failed!");
            }
        } catch (IOException e) {
            log.error(e.getLocalizedMessage(), e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }
}
