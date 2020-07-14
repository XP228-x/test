package com.bosssoft.hr.train.jsp.example.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Slf4j
public class OnlineListener implements HttpSessionListener{
    private static final String ATTRIBUTE_NAME = "numOnline";

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //超时时间设置？
        se.getSession().setMaxInactiveInterval(5);
        //得到ServletContext对象
        ServletContext context = se.getSession().getServletContext();
        //得到存在ServletContext对象中的num的值
        Integer num = (Integer) context.getAttribute(ATTRIBUTE_NAME);
        //如果为空,说明是第一个访问的用户
        if(num==null) {
            num = 1;
        }else {
            num++;//不为空,num++
        }
        log.info("I'm listener" + num);
        //再把num装到ServletContext域中
        context.setAttribute(ATTRIBUTE_NAME, num);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("Session Destroy");
        ServletContext context = se.getSession().getServletContext();
        Integer num = (Integer) context.getAttribute(ATTRIBUTE_NAME);
        //session，num--
        num--;
        context.setAttribute(ATTRIBUTE_NAME, num);
    }

}
