package user.webstudy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import user.db.User;
import user.db.UserDb;

@WebServlet("/login")
public class Login extends HttpServlet {
	final static Logger logger = LoggerFactory.getLogger(Login.class);

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		logger.info("start2");
		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");
		session.setAttribute("userId", userId);
		session.setAttribute("userPw", userPw);
		logger.info("Id :" + userId + ", pw :" + userPw);
		User user = new User();
		user.create(user);
		UserDb.addUser(user);

		if (session.getAttribute("userId").equals(userId))
			resp.sendRedirect("/login.jsp");
	}
}
