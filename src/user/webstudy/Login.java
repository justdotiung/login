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

import user.db.NotFoundException;
import user.db.PasswordMismatch;
import user.db.User;
import user.db.UserDb;

@WebServlet("/login")
public class Login extends HttpServlet {
	final static Logger logger = LoggerFactory.getLogger(Login.class);

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");
		
		try {
			User.login(userId, userPw);
			session.setAttribute("userId", userId);
			logger.debug("id"+userId+"pw:"+userPw);
			
			resp.sendRedirect("login.jsp");
		} catch (NotFoundException e) {
			foward(req, resp, "존재하지 않는 아이디입니다.");
		} catch (PasswordMismatch e) {
			foward(req, resp, "비밀번호가 틀렸습니다.");
		}
		
	}

	private void foward(HttpServletRequest req, HttpServletResponse resp,String error)
			throws ServletException, IOException {
		req.setAttribute("errormasage", error);
		RequestDispatcher rd = req.getRequestDispatcher("/loginpage.jsp");
		rd.forward(req, resp);
		
	}
}
