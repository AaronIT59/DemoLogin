package com.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController extends DaoImpl{

	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv =new ModelAndView();
		String t1= request.getParameter("user");
		String t2= request.getParameter("pass");
		if(new AddController().checkLogin(t1, t2))
		{
			mv.setViewName("display.jsp");
			mv.addObject("status","Success!");
		}
		
		else 
		{
			mv.setViewName("index.jsp");
			mv.addObject("status","Fail!");
			
		}
			
		return mv;
		
	}
	
}
