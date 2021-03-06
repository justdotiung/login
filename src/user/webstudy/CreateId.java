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
import user.db.UserDao;
import user.db.UserDb;

@WebServlet("/create")
public class CreateId extends HttpServlet {
	final static Logger logger = LoggerFactory.getLogger(CreateId.class);
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		String userPW = req.getParameter("userPw");
		String userName = req.getParameter("userName");
		String userEmail = req.getParameter("userEmail");
		String a = req.getContextPath();
		System.out.println(a);
		User user = new User(userId, userPW, userName, userEmail);
		log(user.toString());
		UserDao dao = new UserDao();
		dao.insert(user);
		resp.sendRedirect("/webstudy/loginpage.jsp");
	}
}
