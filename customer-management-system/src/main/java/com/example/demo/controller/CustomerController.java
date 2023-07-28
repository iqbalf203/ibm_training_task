package com.example.demo.controller;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@GetMapping("/list")
	public String listCustomers(Model theModel) {

		List<Customer> theCustomers = null;
		theCustomers = customerService.getAllCustomers();
		theModel.addAttribute("customers", theCustomers);
		return "customer-list";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Customer customer=new Customer();
		
		theModel.addAttribute("customer",customer);
		return "customer-form";

	}
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer)
	{
		theCustomer.setCustomerId(new Random().nextInt(10000));
		customerService.saveCustomer(theCustomer);
		return "redirect:/customers/list";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int customerId,Model theModel)
	{
		Customer customer=customerService.findCustomerById(customerId);
		theModel.addAttribute("customer",customer);
		return "customer-form-update";
	}
	@PostMapping("/update")
	public String updateCustomer(@ModelAttribute("customer") Customer theCustomer)
	{
	
		customerService.updateCustomer(theCustomer);
		return "redirect:/customers/list";
	}
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId")int customerId,Model theModel) {
		Customer customer=customerService.findCustomerById(customerId);
		customerService.deleteCustomer(customer);
		return "redirect:/customers/list";
	}
}
	
