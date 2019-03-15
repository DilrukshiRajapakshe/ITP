/** IT17089296
 * Hapuarachchi H.D.H.U */
package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.add;
import com.model.cashier;
import com.model.monthlyProfitReport;
import com.model.view;
import com.service.addService;
import com.service.dailyReportPDFViewer;
import com.service.deleteServiceHarini;
import com.service.monthlyReportPDFViewer;
import com.service.newDateService;
import com.service.refferIncomeService;
import com.service.viewDailyProfitService;
import com.service.viewMonthlyProfitService;
import com.service.viewService;

import java.util.Date;
import java.util.Locale;
import java.sql.SQLException;

import java.util.ArrayList;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;  

@Controller

public class profitController {
	
	
	
	@RequestMapping("/addCost")

	
	
	public ModelAndView addCost(HttpServletRequest request,HttpServletResponse response,RedirectAttributes rda) throws SQLException, ClassNotFoundException, ParseException {
		String value = request.getParameter("addAll");
		ModelAndView mav = new ModelAndView();
		System.out.println(value);
		if(value.equals("add")){
			String cost_type = request.getParameter("cost_type");
			double amount = Double.parseDouble(request.getParameter("amount"));
			
			add newAdd = new add();
			cashier newBill = new cashier();
			
			newAdd.setcost_type(cost_type);
			newAdd.setamount(amount);
		
			addService addser = new addService();
			addser.addCostService(newAdd);
			
			refferIncomeService ris = new refferIncomeService();
			ris.refferIncome(newBill);
			
			mav.setViewName("addProfit.jsp");
			
		}
		return mav;
		
	}
	
	@RequestMapping("/viewData")
	
	public ModelAndView viewData(HttpServletRequest request,HttpServletResponse response,@RequestParam("myRadio") String mcost,String mreport,String ygraphs)throws ClassNotFoundException, SQLException{
		
		String value = request.getParameter("myRadio");
		ModelAndView mav = new ModelAndView();
		
		if(value.equals("mcost")){
						
			cashier newBill = new cashier();
			String View = request.getParameter("View");
			System.out.println(View);
			view object = new view();
			object.setView(View);
		
			refferIncomeService ris = new refferIncomeService();
			ris.refferIncome(newBill);
			
			viewService vs = new viewService();
			ArrayList view_list = vs.displayService(object);
		
			mav.setViewName("displayTable.jsp");
			mav.addObject("result",view_list);
			
			
			
		}else if(value.equals("dmreport")){
			
			cashier newBill = new cashier();
			
			refferIncomeService ris = new refferIncomeService();
			ris.refferIncome(newBill);
			
			mav.setViewName("reportButtons.jsp");
			
		}else if(value.equals("mreport")){
			cashier newBill = new cashier();
			refferIncomeService ris = new refferIncomeService();
			ris.refferIncome(newBill);
			mav.setViewName("addDateDiffMonthlyReport.jsp");
			
			
		}
				
				return mav;		
		
	}
	

	@RequestMapping("/deleteData")
	public ModelAndView deleteUpdate(HttpServletRequest request,HttpServletResponse respond) throws ClassNotFoundException, SQLException
	{
		String value = request.getParameter("del");
		ModelAndView mav = new ModelAndView();
		if(value.equals("delete")){
		
			long Id = Long.parseLong(request.getParameter("Id"));
			add nAdd = new add();
			nAdd.setId(Id);
			deleteServiceHarini ds = new deleteServiceHarini();
			ds.removeService(nAdd);
			String View = request.getParameter("View");
			System.out.println(View);
			view object = new view();
			object.setView(View);
			viewService vs = new viewService();
			ArrayList view_list = vs.displayService(object);
			mav.setViewName("displayTable.jsp");
			mav.addObject("result",view_list);
			
		}
	
		
		return mav;
	}

	
	@RequestMapping("/mdReport")
	public ModelAndView viewReport(HttpServletRequest request,HttpServletResponse respond) throws ClassNotFoundException, SQLException
	{
		String value = request.getParameter("report");
		ArrayList list = null;
		if(value.equals("dreport")){
			
			cashier newBill = new cashier();
			String View = request.getParameter("View");
			
			System.out.println(View);
			view object = new view();
			object.setView(View);
		
			refferIncomeService ris = new refferIncomeService();
			ris.refferIncome(newBill);
		
			viewDailyProfitService vdps = new viewDailyProfitService();
			list = vdps.dailyProfitService(object);
			
			
		
			dailyReportPDFViewer pdf =  new dailyReportPDFViewer();
		}else if(value.equals("mreport")){
			ModelAndView mav = new ModelAndView();
			
			cashier newBill = new cashier();
			refferIncomeService ris = new refferIncomeService();
			ris.refferIncome(newBill);
			
			mav.setViewName("addDateDiffMonthlyReport.jsp");
			
		
			return mav;
		}
		
			return new ModelAndView(new dailyReportPDFViewer(),"result",list);
		
	}
	
	@RequestMapping("/monthrep")
	public ModelAndView viewMonthlyReport(HttpServletRequest request,HttpServletResponse respond) throws ClassNotFoundException, SQLException, ParseException
	{
		
		String value = request.getParameter("repmon");
		ModelAndView mav = new ModelAndView();
		ArrayList list = null;
		if(value.equals("addDate")){
			cashier newBill = new cashier();
			
			
			String str = request.getParameter("startDate");
			String end = request.getParameter("endDate");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
			
			
			monthlyProfitReport mpr = new monthlyProfitReport();
			mpr.setStartDate(str);
			mpr.setEndDate(end);
			
			newDateService mds = new newDateService();
			list = mds.addDateService(mpr);
			System.out.println("hello");
			
			
		
			
			
			refferIncomeService ris = new refferIncomeService();
			ris.refferIncome(newBill);
		
			dailyReportPDFViewer pdf =  new dailyReportPDFViewer();
			System.out.println("qqq");
			//mav.setViewName("addDateDiffMonthlyReport.jsp");
			
			
			
			 
			
			
			
			
			
		
			
			
		}
		return new ModelAndView(new monthlyReportPDFViewer(),"result",list);
	}	
	
}
