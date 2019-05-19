package lttzz.ch4;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyGenericServlet", urlPatterns = {"/ch4/MyGenericServlet"})
public class MyGenericServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
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
}
