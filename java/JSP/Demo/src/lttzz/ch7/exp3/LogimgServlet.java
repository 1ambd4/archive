package lttzz.ch7.exp3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogimgServlet")
public class LogimgServlet extends HttpServlet {
    public LogimgServlet() {
        super();
    }

    public void destory() {
        super.destroy();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String checkcode = request.getParameter("checkcode");
        String piccode  = request.getSession().getAttribute("piccode").toString();
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");

        request.getSession().setAttribute("logInfo", userName + ";" + passWord + ";" + checkcode + ";" + piccode);

        if (userName.equals("admin") && passWord.equals("admin") && checkcode.equals(piccode)) {
            request.getSession().setAttribute("userName", userName);
            response.sendRedirect("./ch7/exp2/welcome.jsp");
        }
        else {
            response.sendRedirect("./ch7/exp3/logfail.jsp");
        }
    }
}
