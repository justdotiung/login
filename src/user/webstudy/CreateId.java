package user.webstudy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.db.User;
import user.db.UserDb;

@WebServlet("/create")
public class CreateId extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");
		String userName = req.getParameter("userName");
		String userEmail = req.getParameter("userEmail");
		
		User user = new User(userId, userPw, userName, userEmail);
		UserDb.addUser(user);

		resp.sendRedirect("loginpage.jsp");
	}
}
