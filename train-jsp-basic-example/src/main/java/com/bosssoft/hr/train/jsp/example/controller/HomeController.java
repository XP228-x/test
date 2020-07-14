package com.bosssoft.hr.train.jsp.example.controller;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        log.info("I'm HomeController");
        try {
            req.getRequestDispatcher("/home.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            log.error(e.getLocalizedMessage(), e);
        }


    }

}
