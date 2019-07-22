package lttzz.ch7.exp3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ImageServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ImageServlet() {
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

		response.setContentType("text/html;charset=utf-8");
		int width = 78;
		int height = 20;
		
		// create BufferedImage object
		BufferedImage bim = new BufferedImage(68, 20, BufferedImage.TYPE_INT_RGB);
		Graphics g = bim.getGraphics();
		Random rm = new Random();
		g.setColor(new Color(rm.nextInt(100), 205, rm.nextInt(100)));
		g.fillRect(0, 0, width, height);
		StringBuffer sbf = new StringBuffer("");
		for (int i = 0; i < 4; ++i) {
			g.setColor(Color.black);
			int n = rm.nextInt(10);
			sbf.append(n);
			g.drawString("" + n, i * 15 + 5, 18);
		}
		
		HttpSession session = request.getSession(true);
		session.setAttribute("piccode", sbf);
		
		response.setHeader("Parma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		
		ImageIO.write(bim, "JPG", response.getOutputStream());
		response.getOutputStream().close();
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
