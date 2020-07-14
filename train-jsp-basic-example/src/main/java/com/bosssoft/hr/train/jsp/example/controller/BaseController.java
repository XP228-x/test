package com.bosssoft.hr.train.jsp.example.controller;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @param
 * @description:
 * @author: Administrator
 * @create: 2020-05-29 11:56
 * @since
 **/

@Slf4j
public abstract class BaseController extends HttpServlet {
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
        try {
            super.doPost(req, resp);
        } catch (ServletException | IOException e) {
            log.error(e.getLocalizedMessage(), e);
        }
        doAction(req,resp);
    }
    protected abstract void doAction(HttpServletRequest req, HttpServletResponse resp);
}
