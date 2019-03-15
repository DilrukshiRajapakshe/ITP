package com.controller;

	
	import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
	import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.ModelMap;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.servlet.ModelAndView;

import com.model.ViewClass;
import com.model.supSearch;
import com.model.supplier;
import com.mysql.fabric.xmlrpc.base.Data;
import com.service.InsertOrder;
import com.service.ReadCal;
import com.service.ReadCost;
import com.service.ReadDeleteSup;
import com.service.ReadSupplier;
import com.service.RemoveSupplierDelete;
import com.service.SupplierDelete;
import com.service.SupplierSearchService;
import com.service.SupplierService;
import com.service.SupplierUpdate;
import com.service.ViewServiceSup;
import com.service.ViewSupOrder;
import com.service.ViewdeleteSup;
import com.service.Vieworders;
	

	@Controller
	public class SupplierController {
		
		@RequestMapping("/supInsert")
		public ModelAndView insert(HttpServletRequest request,HttpServletResponse respond) throws ClassNotFoundException, SQLException
		{
			String val = request.getParameter("st");
			System.out.println(val);
			ModelAndView mv = new ModelAndView();
			
			
			if(val.equals("addsuplier")){
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String mail = request.getParameter("mail");
			int contact = Integer.parseInt(request.getParameter("contact"));	
			String item = request.getParameter("item");
			String date = request.getParameter("date");
			
			
			supplier obj = new supplier();
			
			obj.setId(id);
			obj.setJoinDate(date);
			obj.setAddress(address);
			obj.setEmail(mail);
			obj.setItem(item);
			obj.setName(name);
			obj.setContact(contact);
			
			
			SupplierService us = new SupplierService();
			us.addSupplierService(obj);
			
			
			System.out.println(id);
			System.out.println(name);
			mv.setViewName("success.jsp");
			}
			
			else if(val.equals("Updatesup")){
				
				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String address = request.getParameter("address");
				String mail = request.getParameter("mail");
				int contact = Integer.parseInt(request.getParameter("contact"));	
				//int qua = Integer.parseInt(request.getParameter("contact"));
				String item = request.getParameter("item");
				String date = request.getParameter("date");
				
				
				supplier obj = new supplier();
				
				obj.setId(id);
				obj.setJoinDate(date);
				obj.setAddress(address);
				obj.setEmail(mail);
				obj.setItem(item);
				obj.setName(name);
				obj.setContact(contact);
				
				
				SupplierUpdate us = new SupplierUpdate();
				us.updateSupplierService(obj);
				mv.setViewName("success.jsp");
			}
			else if(val.equals("calculatedd")){
				
				String orderid = request.getParameter("orderid");
				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String item = request.getParameter("item");
				String date = request.getParameter("date");
				String warranty = request.getParameter("warranty");
				int itemprice = Integer.parseInt(request.getParameter("itemprice"));
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				double discount = Double.parseDouble(request.getParameter("discount"));
				

				supplier obj = new supplier();
				
				obj.setId(id);
				obj.setItem(item);
				obj.setName(name);
				obj.setOrderId(orderid);
				obj.setOrderDate(date);
				obj.setWarranty(warranty);
				obj.setPrice(itemprice);
				obj.setQuantity(quantity);
				obj.setDiscount(discount);
				

				InsertOrder us = new InsertOrder();
				us.addSupplierOder(obj);
				
				System.out.println(orderid);
				
				ReadCost rs = new ReadCost();
				ArrayList list =rs.SupplierCostRead(obj);
				mv.setViewName("SupplierCostCalFinal.jsp");
				mv.addObject("result",list);
			}
			
			
			
			
			return mv;
		}
		


		
		@RequestMapping("/delete")
		public ModelAndView delete(HttpServletRequest request,HttpServletResponse respond)
		{ 
			String val = request.getParameter("st");
			System.out.println(val);
			
			ModelAndView mv = new ModelAndView();
			
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String mail = request.getParameter("mail");
			int contact = Integer.parseInt(request.getParameter("contact"));
			String item = request.getParameter("item");	
			String reason = request.getParameter("reason");
			String date = request.getParameter("date");
			String address = request.getParameter("address");
			
			
			supplier obj = new supplier();
			
			obj.setId(id);
			obj.setName(name);
			obj.setEmail(mail);
			obj.setContact(contact);
			obj.setItem(item);
			obj.setRemoveReason(reason);
			obj.setRemoveDate(date);
			obj.setAddress("address");
			obj.setJoinDate(date);
		
			
			
			if(val.equals("backup")){
			
			//InseartRemoveSupplier rs = new InseartRemoveSupplier();
			//rs.addRemoveSupplierService(obj);
			
			
			System.out.println(id);
			System.out.println(name);
			}
			else if(val.equals("delete")) {

//			supplier obj = new supplier();
			
//			obj.setId(id);
			
			SupplierDelete us = new SupplierDelete();
			us.deleteSupplierService(obj);
			
			
			
			//ModelAndView mv = new ModelAndView();
			
			}
			mv.setViewName("success.jsp");
			return mv;
		}
		
		@RequestMapping("/removeSupplier")
		public ModelAndView removeSupplier(HttpServletRequest request,HttpServletResponse respond)
		{ 
			ModelAndView mv = new ModelAndView();
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			supplier obj = new supplier();
			obj.setId(id);
			RemoveSupplierDelete us = new RemoveSupplierDelete();
			us.deleteremoveSupplierService(obj);
			mv.setViewName("success.jsp");
			return mv;
		}
		
		//first.jsp
		@RequestMapping("/supplier")	
		public ModelAndView supplierViewItem(HttpServletRequest request,HttpServletResponse respond) throws SQLException, ClassNotFoundException{
		
			String val = request.getParameter("st");
			System.out.println(val);
			
			ModelAndView mv = new ModelAndView();
			
			if(val.equals("addsup")){
				
				mv.setViewName("AddSupplier.jsp");
		}
			else if(val.equals("noti")){
				
				mv.setViewName("Notification.jsp");
			}
			else if(val.equals("reports")){
				mv.setViewName("Reports.jsp");
			}
			else if(val.equals("supplier")){
				ViewClass v = new ViewClass();
				v.setSt(val);
				ViewServiceSup vs = new ViewServiceSup();
				ArrayList list =  vs.supplierViewDisplay(v);
				System.out.println(list);
				mv.setViewName("MainSup.jsp");
				mv.addObject("result",list);
			}
			else if(val.equals("cost")){
				ViewClass v = new ViewClass();
				v.setSt(val);
				ViewSupOrder vs = new ViewSupOrder();
				ArrayList list =  vs.supplierOrderViewDisplay(v);
				System.out.println(list);
				mv.setViewName("Suppliercost.jsp");
				mv.addObject("result",list);
				
				
			}
			else if(val.equals("removesupplier")){
				ViewClass v = new ViewClass();
				v.setSt(val);
				ViewdeleteSup vs = new ViewdeleteSup();
				ArrayList list =  vs.viewDeleteDisplay(v);
				System.out.println(list);
				mv.setViewName("deletebackup.jsp");
				mv.addObject("result",list);
			}
			
			return mv;
		}
		
		
		@RequestMapping("/readSupplier")
		public ModelAndView supplierRead(HttpServletRequest request,HttpServletResponse respond) throws SQLException, ClassNotFoundException{
			String val = request.getParameter("st");
			System.out.println(val);
			
			ModelAndView mv = new ModelAndView();
			
			if(val.equals("Updatesupp")){
				int Id =Integer.parseInt( request.getParameter("Id"));
				System.out.println(Id);
				
				
					supplier s = new supplier();
					s.setId(Id);
					ReadSupplier rs = new ReadSupplier();
					ArrayList list =rs.SupplierRead(s);
					mv.setViewName("UpdateSupplier.jsp");
					mv.addObject("result",list);
			}
			else if(val.equals("Delete")){
				
				int Id = Integer.parseInt(request.getParameter("Id"));
			System.out.println(Id);
			
			
			supplier s = new supplier();
			s.setId(Id);
			ReadDeleteSup rs = new ReadDeleteSup();
			ArrayList list =rs.SupplierReadDelete(s);
			mv.setViewName("DeleteSupplier.jsp");
			mv.addObject("result",list);
			
			}
			else if(val.equals("Order")){
				
				int Id = Integer.parseInt(request.getParameter("Id"));
			System.out.println(Id);
			
			
			supplier s = new supplier();
			s.setId(Id);
			ReadCal rs = new ReadCal();
			ArrayList list =rs.SupplierCaltRead(s);
			mv.setViewName("SupplierCostCal.jsp");
			mv.addObject("result",list);
			
			}
			else if(val.equals("Orderview")){
				
				int Id = Integer.parseInt(request.getParameter("Id"));
			System.out.println(Id);
			
			
			supplier s = new supplier();
			s.setId(Id);
			Vieworders rs = new Vieworders();
			ArrayList list =rs.SupplierOrdertView(s);
			mv.setViewName("ViewOrder.jsp");
			mv.addObject("result",list);
			
			}
			return mv;
		}
		
		@RequestMapping("/first")
		public ModelAndView MainFuntion(HttpServletRequest request,HttpServletResponse respond) throws SQLException, ClassNotFoundException{
			String val = request.getParameter("st");
			System.out.println(val);
			
			ModelAndView mv = new ModelAndView();
			if(val.equals("home")){
				mv.setViewName("first.jsp");
			}
			
			return mv;
		}
//		@RequestMapping("/orderInsert")
//		public ModelAndView caiculateSupCost(HttpServletRequest request,HttpServletResponse respond) throws ClassNotFoundException, SQLException
//		{
//			String val = request.getParameter("st");
//			System.out.println(val);
//			ModelAndView mv = new ModelAndView();
//			
//			if(val.equals("calculate")){
//				
//				String orderid = request.getParameter("orderid");
//				int id = Integer.parseInt(request.getParameter("id"));
//				String name = request.getParameter("name");
//				String item = request.getParameter("item");
//				String date = request.getParameter("date");
//				String warranty = request.getParameter("warranty");
//				int itemprice = Integer.parseInt(request.getParameter("itemprice"));
//				int quantity = Integer.parseInt(request.getParameter("quantity"));
//				double discount = Double.parseDouble(request.getParameter("discount"));
//				
//
//				supplier obj = new supplier();
//				
//				obj.setId(id);
//				obj.setItem(item);
//				obj.setName(name);
//				obj.setOrderId(orderid);
//				obj.setOrderDate(date);
//				obj.setWarranty(warranty);
//				obj.setItemPrice(itemprice);
//				obj.setQuantity(quantity);
//				obj.setDiscount(discount);
//				
//				
//				System.out.println(orderid);
//				
//				ReadCost rs = new ReadCost();
//				ArrayList list =rs.SupplierCostRead(obj);
//				mv.setViewName("SupplierCostCalFinal.jsp");
//				mv.addObject("result",list);
//			}
//			
//			return mv;
//			}
		@RequestMapping("/calculate")
		public ModelAndView calfinal(HttpServletRequest request,HttpServletResponse respond) throws SQLException, ClassNotFoundException{
			String val = request.getParameter("st");
			System.out.println(val);
			
			ModelAndView mv = new ModelAndView();
			if(val.equals("calculateadd")){
				mv.setViewName("SupplierCostCalFinal.jsp");
			}
			else if(val.equals("confirm")) {
				mv.setViewName("success.jsp");
			}
			
			return mv;
		}

}
