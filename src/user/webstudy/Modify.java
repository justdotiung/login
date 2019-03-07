package user.webstudy;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import user.db.User;
import user.db.UserDao;

@WebServlet("/modify")
public class Modify extends HttpServlet {
	final static Logger logger = LoggerFactory.getLogger(Modify.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");
		if(userId == null)
			resp.sendRedirect("/loginpage.jsp");
		
		UserDao dao = new UserDao();
		User user = dao.view(userId);
		req.setAttribute("user", user);
		RequestDispatcher rs = req.getRequestDispatcher("/create.jsp");
		rs.forward(req, resp);
	}

}
