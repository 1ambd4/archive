package lttzz.ch4;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyServlet", urlPatterns = { "/ch4/MyServlet" })
public class MyServlet implements Servlet {

    private transient ServletConfig servletConfig;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    // Called by the servlet container to allow the servlet to respond to a request.
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        // 设置类型
        servletResponse.setContentType("text/html");
        PrintWriter writer = servletResponse.getWriter();
        writer.print("<html><body bgcolor=\"#00ffff\">\n" +
                "<form>\n" +
                "    <fieldset>\n" +
                "        <legend align=\"center\">user login</legend>\n" +
                "        <label>username:</label>\n" +
                "        <input type=\"text\" id=\"user\"><br><br>\n" +
                "        <label>password:</label>\n" +
                "        <input type=\"password\" id=\"passwd\"><br>\n" +
                "        <input type=\"button\" value=\"login\" onclick=\"check()\">\n" +
                "    </fieldset>\n" +
                "</form>\n" +
                "</body></html>");

        writer.close();
    }

    @Override
    public String getServletInfo() {
        return "MyServlet";
    }

    @Override
    public void destroy() {

    }
}
