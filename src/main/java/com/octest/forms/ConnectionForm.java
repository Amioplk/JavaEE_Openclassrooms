package com.octest.forms;

import javax.servlet.http.HttpServletRequest;

public class ConnectionForm {
	private String result;

	public boolean checkCredentials(HttpServletRequest request) {
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");

		boolean check = false;
		
		if (pass.equals(login + "123")) {
			check = true;
			this.result = "Vous êtes bien connecté !";
		} else {
			this.result = "Identifiants erronés !";
		}
		
		return check;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
