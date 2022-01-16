package com.gestioneweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;

public class acquirenteLoggato {
	@GetMapping("loginAcquirente")
	public String loginAcquirente(HttpServletRequest req , HttpServletResponse resp)
	{
//		try {
//			RequestDispatcher dispacher = req.getRequestDispatcher("/WEB-INF/jsp/loginAcquirente.jsp");
//			dispacher.forward(req,resp);
//		} catch (ServletException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return "loginAcquirente";
	}
}
