package com.bosssoft.hr.train.jsp.example.controller;

import com.alibaba.fastjson.JSON;
import com.bosssoft.hr.train.jsp.example.pojo.Query;
import com.bosssoft.hr.train.jsp.example.pojo.User;
import com.bosssoft.hr.train.jsp.example.service.UserService;
import com.bosssoft.hr.train.jsp.example.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @create: 2020-05-30 11:22
 * @since
 **/

@Slf4j
public class QueryUserController extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String idStr = req.getParameter("id");
        String code = req.getParameter("code");
        Integer id = null;

        if (!"".equals(idStr)) {
            try {
                id = Integer.valueOf(idStr);
            } catch (NumberFormatException e) {
                log.error(e.getLocalizedMessage(), e);
            }
        }

        if ("".equals(code)) {
            code = null;
        }

        List<User> userList = userService.queryByCondition(new Query(code, id));
        log.info("I'm QueryController, result size = " + userList.size());
        String result = JSON.toJSONString(userList);

        try {
            resp.getWriter().write(result);
        } catch (IOException e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        doGet(req,resp);
    }
}
