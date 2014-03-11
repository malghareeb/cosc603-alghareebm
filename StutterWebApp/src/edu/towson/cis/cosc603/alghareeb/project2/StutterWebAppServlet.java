package edu.towson.cis.cosc603.alghareeb.project2;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class StutterWebAppServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
