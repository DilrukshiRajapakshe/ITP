//IT17024914
package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.model.activity;
import com.model.viewAct;
import com.service.activityService;
import com.service.viewServiceAct;
import com.service.deleteServiceAct;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*; 
import java.text.*;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Controller

public class activityController {
	
	
	
	
	@RequestMapping("/viewAc")
	public ModelAndView viewData(HttpServletRequest request,HttpServletResponse response)throws ClassNotFoundException, SQLException{
		
		
			String View = request.getParameter("View");
			
			System.out.println(View);
			viewAct object = new viewAct();
			object.setView(View);
			
			//Getting parameters from the view -------------------------------
			boolean boolAll=false;
			if(request.getParameter("chkAll") != null){
				boolAll=true;
			}
			
			boolean boolToday=false;
			if(request.getParameter("chkToday") != null){
				boolToday=true;
			}
			
			String dtFromDate="";
			if (request.getParameter("FromDate")!=null)
				{
					dtFromDate=request.getParameter("FromDate");
				}
				
			String dtToDate="";
			if (request.getParameter("ToDate")!=null)
				{
					dtToDate=request.getParameter("ToDate");
				}
				
			String UserId="";
			if (request.getParameter("user")!=null)
				{ 
					UserId = request.getParameter("user");
				}
				
			String ActivityType="";
			if (request.getParameter("Activity")!=null)
				{
					ActivityType=request.getParameter("Activity");
				}
			//End getting parameters from the view  -------
			
			
			viewServiceAct vs = new viewServiceAct();
			
			//ArrayList view_list = vs.displayService(object);
	
			
			ArrayList view_list = vs.displayService(boolAll,boolToday, dtFromDate, dtToDate, UserId, ActivityType);
			
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("Activity.jsp");
			mav.addObject("result",view_list);
			return mav;
	}
	
	
	@RequestMapping("/deleteDataAct")
	public ModelAndView deleteUpdate(HttpServletRequest request,HttpServletResponse respond) throws ClassNotFoundException, SQLException
	{
		String value = request.getParameter("del");
		ModelAndView mav = new ModelAndView();
		if(value.equals("delete")){
		
			long Id = Long.parseLong(request.getParameter("Id"));
			activity nAct = new activity();
			//nAct.setId(Id);
			deleteServiceAct ds = new deleteServiceAct();
			ds.removeService(nAct);
			String View = request.getParameter("View");
			System.out.println(View);
			viewAct object = new viewAct();
			object.setView(View);
			viewServiceAct vs = new viewServiceAct();
			ArrayList view_list = vs.displayService(object);
			mav.setViewName("Activity.jsp");
			mav.addObject("result",view_list);
			
		}
	
		
		return mav;
	}
	
	
		
	
}
