package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.userDAOImpl;
import com.DB.DBConnect;
import com.entity.user;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			
			userDAOImpl dao=new userDAOImpl(DBConnect.getConn());			
			HttpSession session=req.getSession();
			
			String gmail=req.getParameter("gmail");
			String password=req.getParameter("password");
			
			if("admin@gmail.com".equals(gmail) && "admin".equals(password)) {
				user us=new user();
				session.setAttribute("userobj", us);
				resp.sendRedirect("admin/home.jsp");
			}else {
				
				user us=dao.login(gmail, password);
				if(us!=null) {
					session.setAttribute("acc", us);
					session.setAttribute("userobj", us);
					resp.sendRedirect("index.jsp");
				}else {
					req.setAttribute("mess", "Wrong user or pass");
					resp.sendRedirect("login.jsp");
				}
				
				
				resp.sendRedirect("home.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}