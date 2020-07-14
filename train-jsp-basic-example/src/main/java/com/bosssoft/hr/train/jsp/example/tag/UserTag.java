package com.bosssoft.hr.train.jsp.example.tag;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * @description: 定义<boss:userTag /> 标签
 * @author: Administrator
 * @create: 2020-05-29 13:50
 * @since
 **/

@Slf4j
public class UserTag extends TagSupport {

    private PageContext userPageContext;

    @Override
    public void setPageContext(PageContext pageContext) {
        this.userPageContext = pageContext;
    }

    @Override
    public int doStartTag() throws JspException {
        String code = (String) userPageContext.getSession().getAttribute("code");
        try {
            userPageContext.getResponse().getWriter().write("我是自定义标签，当前用户： " + code);
        } catch (IOException e) {
            log.error(e.getLocalizedMessage(), e);
        }
        return super.doStartTag();
    }
}
