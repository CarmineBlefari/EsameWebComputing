package com.gestioneweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;

public class amministratoreLoggato {

	@GetMapping("loginAmministratore")
	public String loginAmministratore(HttpServletRequest req , HttpServletResponse resp)
	{
//		try {
//			RequestDispatcher dispacher = req.getRequestDispatcher("/WEB-INF/jsp/loginAmministratore.jsp");
//			dispacher.forward(req,resp);
//		} catch (ServletException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return "loginAmministratore";
	}
}
