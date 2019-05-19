package lttzz.ch4;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyHttpServlet", urlPatterns = {"/ch4/Servlet"})
public class MyHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.print("<html><body bgcolor=\"#00ffff\">\n" +
                "<form>\n" +
                "    <fieldset>\n" +
                "        <legend align=\"center\">user login</legend>\n" +
                "        <label>username:</label>\n" +
                "        <input type=\"text\" id=\"user\"><br><br>\n" +
                "        <label>password</label>\n" +
                "        <input type=\"password\" id=\"passwd\"><br>\n" +
                "        <input type=\"button\" value=\"login\" onclick=\"check()\">\n" +
                "    </fieldset>\n" +
                "</form>\n" +
                "</body></html>");

        writer.close();
    }
}
