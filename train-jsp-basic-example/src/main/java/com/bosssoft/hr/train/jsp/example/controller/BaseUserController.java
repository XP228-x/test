package com.bosssoft.hr.train.jsp.example.controller;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: Administrator
 * @create: 2020-05-29 14:00
 * @since
 **/
@Slf4j
public class BaseUserController extends BaseController{

    /**
     * 请根据 路径映射判断调用各方法
     * @param req
     * @param resp
     */
    @Override
    protected void doAction(HttpServletRequest req, HttpServletResponse resp) {
        log.info("DO Action");
    }



}
