package com.octest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.octest.beans.Author;
import com.octest.forms.ConnectionForm;

public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Test() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.setAuthors(request);
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("age")) {
					request.setAttribute("age", cookie.getValue());
				}
			}
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.setAuthors(request); // Anti-pattern

		ConnectionForm form = new ConnectionForm();
		boolean check_ok = form.checkCredentials(request);
		if(check_ok) {
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			HttpSession session = request.getSession(true); // If already a session, retrieve it
			session.setAttribute("login", login);
			session.setAttribute("password", password);
		}
		request.setAttribute("connectionForm", form);
		
		// Save age cookie
		String age = request.getParameter("age");
		Cookie cookie = new Cookie("age", age);
		cookie.setMaxAge(3600 * 3); // Lasts 3 hours (defaut session scope)
		response.addCookie(cookie);

		this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
	}
	
	

	private void setAuthors(HttpServletRequest request) {
		Author author = new Author();
		author.setName("Worms");
		author.setSurname("Amir");
		author.setActive(true);

		Author author2 = new Author();
		author2.setName("Lambourg");
		author2.setSurname("Charlotte");
		author2.setActive(true);

		Author[] authors = { author, author2 };

		request.setAttribute("author", author);
		request.setAttribute("authors", authors);
	}

}
