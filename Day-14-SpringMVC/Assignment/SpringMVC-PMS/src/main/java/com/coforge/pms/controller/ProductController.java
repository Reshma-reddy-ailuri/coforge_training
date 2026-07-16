package com.coforge.pms.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.coforge.pms.model.Product;
import com.coforge.pms.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService service;
	
	@RequestMapping("home")
	public ModelAndView loadHomePage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ProductHomePage"); // this will go to dispatcher servlet and use suffix and will get to know that it is in views->.jsp extension 
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "product" , params = "Insert")
	//ModelAttribute annotation helps us create and store in  bean object automatically
	public ModelAndView createProduct(@ModelAttribute Product product) {
		ModelAndView mv =new ModelAndView();
		mv.setViewName("ProductHomePage");
		
		String result = "";
		boolean status = service.createProduct(product);
		
		if(status) {
			result = "SUCCESS : Product Added Successfully ";
		} else {
			result = "FAILED : Product Not Added";
		}
		mv.addObject("result", result);
		
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "product" , params = "Update")
	//ModelAttribute annotation helps us create and store in  bean object automatically
	public ModelAndView updateProduct(@ModelAttribute Product product) {
		ModelAndView mv =new ModelAndView();
		mv.setViewName("ProductHomePage");
		
		String result = "";
		boolean status = service.updateProduct(product);
		
		if(status) {
			result = "SUCCESS : Product Updated ";
		} else {
			result = "FAILED : Product Not Updated";
		}
		mv.addObject("result", result);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "product" , params = "Delete")
	public ModelAndView deleteProduct(@RequestParam  int pid) {
		ModelAndView mv =new ModelAndView();
		mv.setViewName("ProductHomePage");
		
		String result = "";
		boolean status = service.deleteProduct(pid);
		
		if(status) {
			result = "SUCCESS : Product Deleted Successfully";
		} else {
			result = "FAILED : Product Not Deleted";
		}
		mv.addObject("result", result);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "product" , params = "Find")
	//ModelAttribute annotation helps us create and store in  bean object automatically
	public ModelAndView findProduct(@RequestParam  int pid) {
		ModelAndView mv =new ModelAndView();
		mv.setViewName("ProductHomePage");
		
		String result = "";
		Product product = service.findProduct(pid);
		
		if(product != null) {
			mv.addObject("result", product);
		} else {
			result = "FAILED : Product Object Not Found";
		}
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "product" , params = "FindAll")
	public ModelAndView findAllProduct() {
		ModelAndView mv =new ModelAndView();
		mv.setViewName("ProductHomePage");
		
		Collection<Product> PMap = service.findAllProducts();
		
		mv.addObject("result", PMap);
		return mv;
	}
	
	
}