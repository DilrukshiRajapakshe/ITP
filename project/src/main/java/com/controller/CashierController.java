/** IT17159036– Attanayake A.M.O.M */
package com.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

//import java.sql.SQLException;
//import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.JsonViewResponseBodyAdvice;

import com.model.BillSearch;
import com.model.cashier;
import com.model.disc;
import com.service.DeleteServiceBill;
//import com.model.BillSearch;
import com.service.cashierService;
import com.service.discountService;
import com.service.searchServiceBill;
@Controller
public class CashierController {
	

		@RequestMapping("/sch")
		public ModelAndView sch(HttpServletRequest request, HttpServletResponse respond)throws ClassNotFoundException,SQLException{
			
			String search = request.getParameter("sch");
			BillSearch obj = new BillSearch();
			obj.setSch(search);
			
			searchServiceBill bill = new searchServiceBill();
			bill.searchbill(obj);
		
			String table = bill.printTable();
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("viewbill.jsp");
			mv.addObject("result",table);
			return mv;
		}
		
		@RequestMapping("/dis")
		public ModelAndView dis(HttpServletRequest request, HttpServletResponse respond)throws ClassNotFoundException,SQLException{
			
			String bid = request.getParameter("dis");
			disc ob = new disc();
			ob.setbid(bid);
			
			discountService ds = new discountService();
			ds.discountSch(ob);
			
			String table = ds.printTable();
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("disc2.jsp");
			mv.addObject("res",table);
			
			return mv;
		} 
	

		@RequestMapping("/orderDeleteCash")
		public ModelAndView OrderDelete(HttpServletRequest request,HttpServletResponse respond) throws SQLException, ClassNotFoundException{
			String icode = request.getParameter("icode");
			
			
			ModelAndView mv = new ModelAndView();
			
			
			if(icode.equals("delete")){
				String i = request.getParameter("icode");
				BillSearch obj = new BillSearch();
				obj.setbid(i);
				DeleteServiceBill us = new DeleteServiceBill();
				us.deleteItem(obj);
				mv.setViewName("added.jsp");
				//mv.setViewName("FirstOrder.jsp");
			}
			
			return mv;
			
			}
		
		@RequestMapping("/insert")
		public ModelAndView insert (HttpServletRequest request, HttpServletResponse respond) {
		 
			String emp2  = request.getParameter("emp2");
			
			if(emp2.equals("yess")) {
				
				//do {
					Calendar cal = Calendar.getInstance();
					
				  int year = cal.get(Calendar.YEAR);
			      int month = cal.get(Calendar.MONTH);   
			      int day = cal.get(Calendar.DAY_OF_MONTH);
			      int hour = cal.get(Calendar.HOUR_OF_DAY);
			      int minute = cal.get(Calendar.MINUTE);
			      int second = cal.get(Calendar.SECOND);
				
			      String yr = Integer.toString(year);
			      String mnth = Integer.toString(month);
			      String d = Integer.toString(day);
			      String hr = Integer.toString(hour);
			      String min = Integer.toString(minute);
			      String sec = Integer.toString(second);
			      
			      String billId = yr + mnth + d + hr + min + sec;
			      	
			      cashier ob = new cashier();
			      ob.tempBidSetter(billId);
			

				String icode = request.getParameter("ItemCode");
				String price = request.getParameter("ItemPrice");
				String qty = request.getParameter("Qty");
				String disc = request.getParameter("Disc");
				
		   float dis = Float.parseFloat(disc);	
           float p = Float.parseFloat(price);
           int q = Integer.parseInt(qty);
           
           float np;
           
           if(dis == 0) {
        	   np = q * p;
           }
           else {
        	   np = (q * p) - dis;
           }
               String nprice = Float.toString(np); 
   			
              // cashier ob = new cashier();
               
			String id = ob.TemgetBillID();
			ob.setBillID(id);
			ob.setIcode(icode);
			ob.setPrice(price);
			ob.setQty(qty);
			ob.setNetPrice(nprice);
			ob.setDisc(disc);
			
			cashierService cs = new cashierService();
			cs.addcashierService(ob);
			

			}
			//}
			ModelAndView mw = new ModelAndView();
			mw.setViewName("updateBill.jsp");
			return mw;
			
		}


/*
	@RequestMapping("/genid")
	public ModelAndView GenID(HttpServletRequest request,HttpServletResponse respond) {
		
		String emp = request.getParameter("emp");
		
		if(emp.equals("yes")) {
			
			Calendar cal = Calendar.getInstance();
			
			  int year = cal.get(Calendar.YEAR);
		      int month = cal.get(Calendar.MONTH);   
		      int day = cal.get(Calendar.DAY_OF_MONTH);
		      int hour = cal.get(Calendar.HOUR_OF_DAY);
		      int minute = cal.get(Calendar.MINUTE);
		      int second = cal.get(Calendar.SECOND);
			
		      String yr = Integer.toString(year);
		      String mnth = Integer.toString(month);
		      String d = Integer.toString(day);
		      String hr = Integer.toString(hour);
		      String min = Integer.toString(minute);
		      String sec = Integer.toString(second);
		      
		      String billId = yr + mnth + d + hr + min + sec;

		      cashier ob = new cashier();
		      ob.tempBidSetter(billId);
		
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Cashier.jsp");
		return mv;
		
	}*/
	/*
	@RequestMapping(value ="/deleteemp/{id}",method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable int )
*/
}


