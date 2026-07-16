package com.coforge.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.coforge.ems.model.Employee;
import com.coforge.ems.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired // Annotation based configuration
	private EmployeeService service;
	
	@RequestMapping("home")
	public ModelAndView loadHomePage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EmployeeHomePage"); // this will go to dispatcher servlet and use suffix and will get to know that it is in views->.jsp extension 
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "employee" , params = "Insert")
	//ModelAttribute annotation helps us create and store in  bean object automatically
	public ModelAndView createEmployee(@ModelAttribute Employee employee) {
		ModelAndView mv =new ModelAndView();
		mv.setViewName("EmployeeHomePage");
		
		String result = "";
		boolean status = service.createEmployee(employee);
		
		if(status) {
			result = "SUCCESS : Employee Object Saved ";
		} else {
			result = "FAILED : Employee Object NotSaved";
		}
		mv.addObject("result", result);
		
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "employee" , params = "Update")
	//ModelAttribute annotation helps us create and store in  bean object automatically
	public ModelAndView updateEmployee(@ModelAttribute Employee employee) {
		ModelAndView mv =new ModelAndView();
		mv.setViewName("EmployeeHomePage");
		
		String result = "";
		boolean status = service.updateEmployee(employee);
		
		if(status) {
			result = "SUCCESS : Employee Object Updated ";
		} else {
			result = "FAILED : Employee Object Not Updated";
		}
		mv.addObject("result", result);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "employee" , params = "Delete")
	public ModelAndView deleteEmployee(@RequestParam  int eid) {
		ModelAndView mv =new ModelAndView();
		mv.setViewName("EmployeeHomePage");
		
		String result = "";
		boolean status = service.deleteEmployee(eid);
		
		if(status) {
			result = "SUCCESS : Employee Object Deleted ";
		} else {
			result = "FAILED : Employee Object Not Deleted";
		}
		mv.addObject("result", result);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "employee" , params = "Find")
	//ModelAttribute annotation helps us create and store in  bean object automatically
	public ModelAndView findEmployee(@RequestParam  int eid) {
		ModelAndView mv =new ModelAndView();
		mv.setViewName("EmployeeHomePage");
		
		String result = "";
		Employee employee = service.findEmployee(eid);
		
		if(employee != null) {
			result = employee.toString();
		} else {
			result = "FAILED : Employee Object Not Found";
		}
		mv.addObject("result", result);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "employee" , params = "FindAll")
	public ModelAndView findAllEmployee() {
		ModelAndView mv =new ModelAndView();
		mv.setViewName("EmployeeHomePage");
		
		List <Employee> employees = service.findAllEmployee();
		
		mv.addObject("result", employees);
		return mv;
	}
	
}
