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
import com.model.employee;
import com.service.CalculateEmpSalary;
import com.service.DeleteView;
import com.service.ReadCalculateSalary;
import com.service.ReadData;
import com.service.ReadDelete;
import com.service.ReadeSalary;
import com.service.VievEmployeeSalary;
import com.service.ViewEmpSalary;
import com.service.ViewService;
import com.service.deleteEmp;
import com.service.insertEmp;
import com.service.removedelete;
import com.service.updateEmp;

	

	@Controller
	public class empContoller {
		
		@RequestMapping("/add")
		public ModelAndView insert(HttpServletRequest request,HttpServletResponse respond)
		{
			String val = request.getParameter("st");
			System.out.println(val);
			
			if(val.equals("add")){
				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String nic = request.getParameter("nic");
				String occupation = request.getParameter("occupation");
				int salary = Integer.parseInt(request.getParameter("salary"));	
				//int qua = Integer.parseInt(request.getParameter("contact"));
				String bdate = request.getParameter("bdate");
				String gender = request.getParameter("gender");
				int contact = Integer.parseInt(request.getParameter("contact"));
				String email = request.getParameter("email");
				String address = request.getParameter("address");
				String nationality = request.getParameter("nationality");
				String jdate = request.getParameter("jdate");
				
				
				employee obj = new employee();
				
				obj.setBdate(bdate);
				obj.setSalary(salary);
				obj.setEmail(email);
				obj.setAddress(address);
				obj.setNic(nic);
				obj.setJoindate(jdate);
				obj.setName(name);
				obj.setId(id);
				obj.setContact(contact);
				obj.setOccupation(occupation);
				obj.setGender(gender);
				obj.setNationality(nationality);
				
				
				insertEmp us = new insertEmp();
				us.addEmployeeService(obj);
				
				
				System.out.println(id);
				System.out.println(name);
			}
			
			else if(val.equals("Update")){
				
				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String nic = request.getParameter("nic");
				String occupation = request.getParameter("occupation");
				int salary = Integer.parseInt(request.getParameter("salary"));
				String bdate = request.getParameter("bdate");
				String gender = request.getParameter("gender");
				int contact = Integer.parseInt(request.getParameter("contact"));
				String email = request.getParameter("email");
				String address = request.getParameter("address");
				String nationality = request.getParameter("nationality");
				String jdate = request.getParameter("jdate");
				
				
				employee obj = new employee();
				
				obj.setBdate(bdate);
				obj.setSalary(salary);
				obj.setEmail(email);
				obj.setAddress(address);
				obj.setNic(nic);
				obj.setJoindate(jdate);
				obj.setName(name);
				obj.setId(id);
				obj.setContact(contact);
				obj.setOccupation(occupation);
				obj.setGender(gender);
				obj.setNationality(nationality);
				
				updateEmp us = new updateEmp();
				us.updateEmployeeService(obj);
				
				
				//System.out.println(id);
				//System.out.println(name);
			}
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("success.jsp");
			
			
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
			String occupation = request.getParameter("occupation");
			int salary = Integer.parseInt(request.getParameter("salary"));	
			String reason = request.getParameter("reason");
			String date = request.getParameter("date");
			
			
			
			employee obj = new employee();
			
			obj.setId(id);
			obj.setName(name);
			obj.setEmail(mail);
			obj.setContact(contact);
			obj.setOccupation(occupation);
			obj.setRreason(reason);
			obj.setRadte(date);
			obj.setSalary(salary);
		
			
			
			if(val.equals("backup")){
			
			//InseartRemoveSupplier rs = new InseartRemoveSupplier();
			//rs.addRemoveSupplierService(obj);
			
			
			System.out.println(id);
			System.out.println(name);
			}
			else if(val.equals("delete")) {

//			supplier obj = new supplier();
			
//			obj.setId(id);
			
				deleteEmp us = new deleteEmp();
			us.deleteEmployeeService(obj);
			
			
			
			//ModelAndView mv = new ModelAndView();
			
			}
			mv.setViewName("success.jsp");
			return mv;
		}
		
		@RequestMapping("/removeEmployee")
		public ModelAndView removeSupplier(HttpServletRequest request,HttpServletResponse respond)
		{ 
			ModelAndView mv = new ModelAndView();
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			employee obj = new employee();
			obj.setId(id);
			removedelete us = new removedelete();
			us.deleteremoveSupplierService(obj);
			mv.setViewName("success.jsp");
			return mv;
		}
		
		
		@RequestMapping("/employee")	
		public ModelAndView supplierViewItem(HttpServletRequest request,HttpServletResponse respond) throws SQLException, ClassNotFoundException{
		
			String val = request.getParameter("st");
			System.out.println(val);
			
			ModelAndView mv = new ModelAndView();
			
			if(val.equals("add")){
				
				mv.setViewName("Add.jsp");
		}
			else if(val.equals("reports")){
				
				mv.setViewName("Reports.jsp");
			}
			else if(val.equals("employee")){
				ViewClass v = new ViewClass();
				v.setSt(val);
				ViewService vs = new ViewService();
				ArrayList list =  vs.employeeViewDisplay(v);
				System.out.println(list);
				mv.setViewName("Main.jsp");
				mv.addObject("result",list);
			}
			else if(val.equals("salary")){
				ViewClass v = new ViewClass();
				v.setSt(val);
				ViewEmpSalary vs = new ViewEmpSalary();
				ArrayList list =  vs.viewsalartDisplay(v);
				System.out.println(list);
				mv.setViewName("Salary.jsp");
				mv.addObject("result",list);
				
				
			}
			else if(val.equals("removemployee")){
				ViewClass v = new ViewClass();
				v.setSt(val);
				DeleteView vs = new DeleteView();
				ArrayList list =  vs.viewDeleteDisplay(v);
				System.out.println(list);
				mv.setViewName("RemoveEmployee.jsp");
				mv.addObject("result",list);
			}
			
			return mv;
		}
		
		
		@RequestMapping("/readTable")
		public ModelAndView supplierRead(HttpServletRequest request,HttpServletResponse respond) throws SQLException, ClassNotFoundException{
			String val = request.getParameter("st");
			System.out.println(val);
			
			ModelAndView mv = new ModelAndView();
			
			if(val.equals("Update")){
				int Id = Integer.parseInt(request.getParameter("Id"));
				System.out.println(Id);
				
				
					employee s = new employee();
					s.setId(Id);
					ReadData rs = new ReadData();
					ArrayList list =rs.employeeRead(s);
					mv.setViewName("Update.jsp");
					mv.addObject("result",list);
			}
			else if(val.equals("Delete")){
				
				int Id = Integer.parseInt(request.getParameter("Id"));
			System.out.println(Id);
			
			
			employee s = new employee();
			s.setId(Id);
			ReadDelete rs = new ReadDelete();
			ArrayList list =rs.EmployeeReadDelete(s);
			mv.setViewName("Delete.jsp");
			mv.addObject("result",list);
			
			}
			return mv;
		}
		
		@RequestMapping("/home")
		public ModelAndView MainFuntion(HttpServletRequest request,HttpServletResponse respond) throws SQLException, ClassNotFoundException{
			String val = request.getParameter("st");
			System.out.println(val);
			
			ModelAndView mv = new ModelAndView();
			if(val.equals("home")){
				mv.setViewName("index.jsp");
			}
			
			return mv;
		}
		
		@RequestMapping("/salarycal")
		public ModelAndView CalculateSalary(HttpServletRequest request,HttpServletResponse respond) throws SQLException, ClassNotFoundException{
			String val = request.getParameter("st");
			System.out.println(val);
			
			ModelAndView mv = new ModelAndView();
			
			if(val.equals("calculate")){
				int Id = Integer.parseInt(request.getParameter("Id"));
				System.out.println(Id);
				
				
					employee s = new employee();
					s.setId(Id);
					ReadeSalary rs = new ReadeSalary();
					ArrayList list =rs.SalaryRead(s);
					mv.setViewName("CalSalary.jsp");
					mv.addObject("result",list);
			}
			else if(val.equals("viewSalary")){
				
				int Id = Integer.parseInt(request.getParameter("Id"));
			System.out.println(Id);
			
			
			employee s = new employee();
			s.setId(Id);
			VievEmployeeSalary rs = new VievEmployeeSalary();
			ArrayList list =rs.employeeSalaryRead(s);
			mv.setViewName("ViewSalary.jsp");
			mv.addObject("result",list);
			
			}
			return mv;
		}

		
		@RequestMapping("/EmployeeSalary")
		public ModelAndView EmployeeSalary(HttpServletRequest request,HttpServletResponse respond) throws SQLException, ClassNotFoundException{
			String val = request.getParameter("st");
			System.out.println(val);
			
			ModelAndView mv = new ModelAndView();
			
			if(val.equals("calculatesalary")){
				
				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String occupation = request.getParameter("occupation");
				int salary = Integer.parseInt(request.getParameter("salary"));
				String year = request.getParameter("year");
				String month = request.getParameter("month");
				int allowance = Integer.parseInt(request.getParameter("allowance"));
				int bonus = Integer.parseInt(request.getParameter("bonus"));
				int loans = Integer.parseInt(request.getParameter("loans"));
				
				employee obj = new employee();
				
				obj.setSalary(salary);
				obj.setName(name);
				obj.setId(id);
				obj.setOccupation(occupation);
				obj.setYear(year);
				obj.setMonth(month);
				obj.setAllowans(allowance);
				obj.setBonus(bonus);
				obj.setLoan(loans);
				
				
				CalculateEmpSalary us = new CalculateEmpSalary();
				us.insertSalary(obj);
				
				ReadCalculateSalary rs = new ReadCalculateSalary();
				ArrayList list =rs.employeeCalSalaryRead(obj);
				mv.setViewName("CalSalaryFinal.jsp");
				mv.addObject("result",list);
				
			}
			else if(val.equals("Delete")){
				
				int Id = Integer.parseInt(request.getParameter("Id"));
			System.out.println(Id);
			
			
			employee s = new employee();
			s.setId(Id);
			ReadDelete rs = new ReadDelete();
			ArrayList list =rs.EmployeeReadDelete(s);
			mv.setViewName("Delete.jsp");
			mv.addObject("result",list);
			
			}
			return mv;
		}
		
		@RequestMapping("/Next")
		public ModelAndView CalNext(HttpServletRequest request,HttpServletResponse respond) throws SQLException, ClassNotFoundException{
			String val = request.getParameter("st");
			System.out.println(val);
			
			ModelAndView mv = new ModelAndView();
			if(val.equals("confirm1")){
				mv.setViewName("CalSalary.jsp");
			}
			else if(val.equals("confirm2")){
				mv.setViewName("success.jsp");
			}
			else if(val.equals("calculatesalary")){
				mv.setViewName("CalSalaryFinal.jsp");
			}
			
			return mv;
		}

}
