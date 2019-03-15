package com.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.Order;
import com.model.ViewClass;
import com.service.ConfirmOrder;
import com.service.DeleteOrder;
import com.service.InsertOrder;
import com.service.ReadData;
import com.service.UpdateOrder;
import com.service.ViewOrders;
@Controller
public class OrderController {
	
	@RequestMapping("/orderInsert")
	public ModelAndView insert(HttpServletRequest request,HttpServletResponse respond) throws ClassNotFoundException, SQLException
	{
		String val = request.getParameter("st");
		System.out.println(val);
		ModelAndView mv = new ModelAndView();
		
		if(val.equals("add")){
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		//int fina = Integer.parseInt(request.getParameter("final"));
		int contact = Integer.parseInt(request.getParameter("contact"));	
		String item = request.getParameter("item");
		int quantity = Integer.parseInt(request.getParameter("quantity"));//quentity
		int delivery = Integer.parseInt(request.getParameter("delivery"));//delivery price
		int amount = Integer.parseInt(request.getParameter("amount"));//item price
		
		
		Order obj = new Order();
		
		obj.setOrderNo(no);
		obj.setName(name);
		obj.setAddress(address);
		obj.setTellNo(contact);
		obj.setItem(item);
		obj.setAmount(amount);
		obj.setCharges(delivery);
		//obj.setFamount(fina);
		obj.setQuantity(quantity);
		
		InsertOrder us = new InsertOrder();
		us.InsertOrderr(obj);
		
		
		System.out.println(no);
		System.out.println(name);
		
		Order r = new Order();
		r.setOrderNo(no);
		ReadData rs = new ReadData();
		ArrayList list =rs.OrderRead(r);
		mv.setViewName("GetOrderFinal.jsp");
		mv.addObject("result",list);
		
		
		
		}
		
		else if(val.equals("update")){
			
			String no = request.getParameter("no");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			//int fina = Integer.parseInt(request.getParameter("final"));
			int contact = Integer.parseInt(request.getParameter("contact"));	
			String item = request.getParameter("item");
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			int delivery = Integer.parseInt(request.getParameter("delivery"));
			int amount = Integer.parseInt(request.getParameter("amount"));
			int billno = Integer.parseInt(request.getParameter("billno"));
			
			
			Order obj = new Order();
			
			obj.setOrderNo(no);
			obj.setName(name);
			obj.setAddress(address);
			obj.setTellNo(contact);
			obj.setItem(item);
			obj.setAmount(amount);
			obj.setCharges(delivery);
			//obj.setFamount(fina);
			obj.setQuantity(quantity);
			obj.setBilno(billno);
			
			UpdateOrder us = new UpdateOrder();
			us.updateOrderr(obj);
			
			
			System.out.println(no);
			System.out.println(name);
			
			Order r = new Order();
			r.setOrderNo(no);
			ReadData rs = new ReadData();
			ArrayList list =rs.OrderRead(r);
			mv.setViewName("UpdateCalculate.jsp");
			mv.addObject("result",list);
			
			
			
			
			
			
			
		}
		return mv;
		
		
	}
	@RequestMapping("/order")	
	public ModelAndView orderViewItem(HttpServletRequest request,HttpServletResponse respond) throws SQLException, ClassNotFoundException{
	
		String val = request.getParameter("st");
		System.out.println(val);
		
		ModelAndView mv = new ModelAndView();
		
            if(val.equals("addget")){
			
			mv.setViewName("GetOrder.jsp");
	}
		else if(val.equals("reports")){
			mv.setViewName("Reports.jsp");
		}
		else if(val.equals("view")){
			ViewClass v = new ViewClass();
			v.setSt(val);
			ViewOrders vs = new ViewOrders();
			ArrayList list =  vs.OrderViewDisplay(v);
			System.out.println(list);
			mv.setViewName("view.jsp");
			mv.addObject("result",list);
		}
		
		return mv;
	}
	
	@RequestMapping("/readOrder")
	public ModelAndView orderRead(HttpServletRequest request,HttpServletResponse respond) throws SQLException, ClassNotFoundException{
		String val = request.getParameter("st");
		System.out.println(val);
		
		ModelAndView mv = new ModelAndView();
		
		if(val.equals("Update")){
			String no = request.getParameter("no");
			System.out.println(no);
			
			
				Order r = new Order();
				r.setOrderNo(no);
				ReadData rs = new ReadData();
				ArrayList list =rs.OrderRead(r);
				mv.setViewName("updateForm.jsp");
				mv.addObject("result",list);
		}
		if(val.equals("Delete")){
			String no = request.getParameter("no");
			System.out.println(no);
			
			
				Order r = new Order();
				r.setOrderNo(no);
				ReadData rs = new ReadData();
				ArrayList list =rs.OrderRead(r);
				mv.setViewName("deleteForm.jsp");
				mv.addObject("result",list);
		}
		if(val.equals("confirm")){
			String no = request.getParameter("no");
			System.out.println(no);
			
			Order obj = new Order();
			obj.setOrderNo(no);
			ConfirmOrder us = new ConfirmOrder();
			us.confirmOrderr(obj);
		
		mv.setViewName("success.jsp");
		}
		return mv;
	}
	
	@RequestMapping("/orderDelete")
	public ModelAndView OrderDelete(HttpServletRequest request,HttpServletResponse respond) throws SQLException, ClassNotFoundException{
		String val = request.getParameter("st");
		System.out.println(val);
		
		ModelAndView mv = new ModelAndView();
		
		if(val.equals("Cancel")){
			mv.setViewName("FirstOrder.jsp");
			
		}
		
		if(val.equals("delete")){
			String no = request.getParameter("no");
			Order obj = new Order();
			obj.setOrderNo(no);
			DeleteOrder us = new DeleteOrder();
			us.deleteOrderr(obj);
			mv.setViewName("success.jsp");
			//mv.setViewName("FirstOrder.jsp");
		}
		
		return mv;
		
		}
	
	@RequestMapping("/homeOrder")
	public ModelAndView MainFuntion(HttpServletRequest request,HttpServletResponse respond) throws SQLException, ClassNotFoundException{
		String val = request.getParameter("st");
		System.out.println(val);
		
		ModelAndView mv = new ModelAndView();
		if(val.equals("home")){
			mv.setViewName("FirstOrder.jsp");
		}
		
		return mv;
	}
	
	@RequestMapping("/amount_calculate")	
	public ModelAndView amountCalculate(HttpServletRequest request,HttpServletResponse respond) throws SQLException, ClassNotFoundException{
	
		String val = request.getParameter("st");
		System.out.println(val);
		
		ModelAndView mv = new ModelAndView();
		
            if(val.equals("calculate_finalamount")){
			
			mv.setViewName("GetOrderFinal.jsp");
	}
		else if(val.equals("add_finalamount")){
			mv.setViewName("success.jsp");
		}
            return mv;
	}
	
	@RequestMapping("/final")	
	public ModelAndView updateamountCalculate(HttpServletRequest request,HttpServletResponse respond) throws SQLException, ClassNotFoundException{
	
		String val = request.getParameter("st");
		System.out.println(val);
		
		ModelAndView mv = new ModelAndView();
		
            if(val.equals("cal")){
			
			mv.setViewName("UpdateCalculate.jsp");
	}
		else if(val.equals("sucsess")){
			mv.setViewName("success.jsp");
		}
            return mv;
	}
	
}
