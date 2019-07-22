package lttzz.ch8.exp3;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String basePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath() + "/";

        // TODO
        // noticed req.getRequestURL() and req.getRequestURL()
        String url = req.getRequestURL().toString();
        String str = (String) req.getSession().getAttribute("username");

        System.out.println("basePath = " +basePath);
        System.out.println("url = " + basePath + "ch8/exp3/checkUser.jsp");
        System.out.println("url = " + url);
        System.out.println("str = " + str);

        if (str != null || url.equals(basePath + "ch8/exp3/login.jsp") || url.equals(basePath + "ch8/exp3/checkUser.jsp")) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else {
             resp.sendRedirect("./ch8/exp3/login.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
