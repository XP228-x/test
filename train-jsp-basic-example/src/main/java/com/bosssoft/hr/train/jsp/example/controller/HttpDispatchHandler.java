package com.bosssoft.hr.train.jsp.example.controller;

import com.bosssoft.hr.train.jsp.example.pojo.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: Administrator
 * @create: 2020-05-29 14:00
 * @since
 **/
public abstract  class HttpDispatchHandler extends HttpServlet {
    /**
     * 如果要实现依据之类的mapping 映射调用之类的方式 考虑将ContextListener要将子类的Controller 放入map
     * 根据 依据 req获取url 映射调用 子类的控制器的方法
     * @param req
     * @param resp
     */
    protected  void doMapping(HttpServletRequest req, HttpServletResponse resp){
            // 根据路径映射调用具体的UserController
    }
}
