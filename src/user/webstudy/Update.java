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

@WebServlet("/update")
public class Update extends HttpServlet {
	final static Logger logger = LoggerFactory.getLogger(Update.class);

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String result = (String) session.getAttribute("userId");
		if (result == null) {
			resp.sendRedirect("/webstudy/loginpage.jsp");
			logger.debug("null값이라서 에러");
			return;
		}

		String userId = req.getParameter("userId");
		if (!userId.equals(result)) {
			resp.sendRedirect("/webstudy/loginpage.jsp");
			logger.debug(userId+"같지않아서 에러"+result);
			return;
		}
		String userPW = req.getParameter("userPw");
		String userName = req.getParameter("userName");
		String userEmail = req.getParameter("userEmail");

		User user = new User(userId, userPW, userName, userEmail);
		UserDao dao = new UserDao();
		dao.modify(user);
		
		resp.sendRedirect("/webstudy/login.jsp");

	}

}
