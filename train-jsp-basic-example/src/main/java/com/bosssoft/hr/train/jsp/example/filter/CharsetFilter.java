package com.bosssoft.hr.train.jsp.example.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Suyukai
 */
public class CharsetFilter implements javax.servlet.Filter {
    private String encoding;

    @Override
    public void destroy() {
        // Do nothing because of destroy
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        // 设置字符编码链锁
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        chain.doFilter(request, response);

    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        // 接收web.xml配置文件中的初始参数
        encoding = config.getInitParameter("CharsetEncoding");
    }

}
