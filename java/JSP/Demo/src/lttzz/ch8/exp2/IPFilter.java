package lttzz.ch8.exp2;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IPFilter implements Filter {
    private FilterConfig config;
    private int startIP;
    private int endIP;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // convert type
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        // read from web.xml
        String strstartIP = config.getInitParameter("startIP");
        String strendIP = config.getInitParameter("endIP");

        System.out.println("startIP:" + strstartIP);
        System.out.println("endIP:" + strendIP);

        req.setAttribute("startIP", strstartIP);
        req.setAttribute("endIP", strendIP);

        // convert form
        startIP = Integer.parseInt(strstartIP.replace(".", ""));
        endIP = Integer.parseInt(strendIP.replace(".", ""));

        // String reqIP = req.getRemoteHost();
        String reqIP = "127.0.1.1";
        req.setAttribute("reqIP", reqIP);

        System.out.println(reqIP);

        reqIP = reqIP.replace(".", "");

        int ip = Integer.parseInt(reqIP);
        if (ip < startIP || ip > endIP) {
            System.out.println(ip + " is not in " + startIP + " ~ " + endIP);
            // resp.sendRedirect("./ch8/exp2/filtip.jsp");
            req.getRequestDispatcher("filtip.jsp").forward(req, resp);
        }
        System.out.println(ip + " is in " + startIP + " ~ " + endIP);
        System.out.println("这是对request的过滤");

        // filterChain.doFilter(req, resp);
        System.out.println("这是对response的过滤");
    }

    @Override
    public void destroy() {

    }
}
