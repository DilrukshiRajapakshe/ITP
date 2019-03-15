/** IT17119122
 * Liyanage I.M */
package com.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class addUser {
	
	@RequestMapping("/save")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse respond)
	{
		int j = Integer.parseInt(request.getParameter("num1"));
		int i = Integer.parseInt(request.getParameter("num2"));		
		System.out.println(i);
		System.out.println(j);
		int k = j+i;
		System.out.println(k);
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("display.jsp");
		mv.addObject("result",k);
		
		return mv;
	}
	
	/*
	@RequestMapping("/save")
	public String add()
	{
		System.out.println("I am here");
		return"display.jsp";
	}*/
}
