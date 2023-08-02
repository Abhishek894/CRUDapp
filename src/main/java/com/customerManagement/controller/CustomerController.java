package com.customerManagement.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.customerManagement.entity.Customer;
import com.customerManagement.service.CustService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustService service;
	
	@GetMapping("/")
	public String home(Model m) {
		
		List<Customer> cust=service.getAllCust();
		m.addAttribute("cust",cust);
		return "home";
	}
	@GetMapping("/addcust")
	public String addCustomerForm()
	{
		return "add_cust";
	}
	@PostMapping("/register")
	public String custRegister(@ModelAttribute Customer c, HttpSession session ) {
		
		System.out.println(c);
		service.addCust(c);
		session.setAttribute("msg", "Customer Added Successfully....");
		return "redirect:/";
		
	}
	
	@GetMapping("/edit/{id}")
	public String editCust(@PathVariable int id, Model m) {
		
		Customer c=service.getCustById(id);
		m.addAttribute("cust", c);
	
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateCust(@ModelAttribute Customer c, HttpSession session) {
		service.addCust(c);
		session.setAttribute("msg", "Customer Details updated...");
		return "redirect:/";
		
	}
	@GetMapping("/delete/{id}")
	public String deleteCust(@PathVariable int id, HttpSession session) {
		service.deleteCust(id);
		session.setAttribute("msg", "Customer Details deleted...");
		
		return "redirect:/";
		
	}
}


