package Control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO;
import Entity.Account;


@WebServlet("/signupconcac")
public class SignUpControl extends HttpServlet {
	 private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String user = req.getParameter("user");
		String pass = req.getParameter("pass");
		DAO dao = new DAO();
		Account a = dao.checkAccountExist(user);
		if(a == null) {
			dao.signup(user, pass);
			res.sendRedirect("HomePage.jsp");
		}
		else {
			res.sendRedirect("SignUp.jsp");
		}
	}
	}
