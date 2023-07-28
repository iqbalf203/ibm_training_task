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
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@Controller
@RequestMapping("/orders")
public class OrderController {
	private final ProductService productService;
	
	
	public OrderController(ProductService productService) {
		super();
		this.productService = productService;
	}
	@GetMapping("/list")
	public String list(Model theModel) {
		List<Product> theProducts = null;
		theProducts = productService.getAllProducts();
		theModel.addAttribute("products", theProducts);
		return "product-list";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Product product = new Product();
		theModel.addAttribute("product",product);
		
		return "product-form";
	}
	
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute("product") Product theProduct)
	{
		theProduct.setProductId(new Random().nextInt(10000));
		productService.saveProduct(theProduct);
		return "redirect:/orders/list";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productId") int productId,Model theModel)
	{
		Product product=productService.findProductById(productId);
		theModel.addAttribute("product",product);
		return "product-form-update";
	}
	@PostMapping("/update")
	public String updateCustomer(@ModelAttribute("product") Product theProduct)
	{
	
		productService.updateProduct(theProduct);
		return "redirect:/orders/list";
	}
	@GetMapping("/deleteProduct")
	public String deleteCustomer(@RequestParam("productId")int productId,Model theModel) {
		Product product=productService.findProductById(productId);
		productService.deleteProduct(product);
		return "redirect:/orders/list";
	}
}
