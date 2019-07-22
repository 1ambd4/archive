package lttzz.ch7.exp1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowParamtersServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ShowParamtersServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String title = "读取所有请求参数";
		out.println("<!DOCTYPE HTML PUBLIC>");
		out.println("<HTML>");
		out.println("<HEAD><TITLE>读取所有请求参数</TITLE></HEAD>");
		out.println("<BODY bgcolor=\"#FDF5F6\">"
				+ "<h1 aligh=center>" + title + "</h1>\n"
				+ "<table align=center>\n"
				+ "<tr bgcolor=\"#FFAD00\">\n"
				+ "<th>参数<th>参数值"
		);
		Enumeration<?> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paraName = (String)paramNames.nextElement();
			out.println("<tr><td>" + paraName + "\n<td>");
			String[] paramValues = request.getParameterValues(paraName);
			if (paramValues.length == 1) {
				String paramvalue = paramValues[0];
				if (paramvalue.length() == 0) out.println("<i>No value</i>");
				else {
					out.println(paramvalue);
				}
			}
			else {
				out.println("<ul>");
				for (int i = 0; i < paramValues.length; ++i) {
					out.println("<li>" + paramValues[i] + "</li>");
				}
				out.println("</ul>");
			}
		}
		out.println("</table>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
