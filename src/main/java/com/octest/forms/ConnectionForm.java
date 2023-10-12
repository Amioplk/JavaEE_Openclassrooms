package com.octest.forms;

import javax.servlet.http.HttpServletRequest;

public class ConnectionForm {
	private String result;

	public void checkCredentials(HttpServletRequest request) {
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");

		if (pass.equals(login + "123")) {
			this.result = "Vous êtes bien connecté !";
		} else {
			this.result = "Identifiants erronés !";
		}
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
