package com.tts.Market.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tts.Market.Model.Product;
import com.tts.Market.Service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping("/product/{id}")
	public String show(@PathVariable long id, Model model) {
		Product product = productService.findById(id); // Grabs The Product Object ID from Saved from the Repository
		model.addAttribute(product); // adds o
		return"product";
	}
	@RequestMapping(value ="/product", method = {RequestMethod.POST, RequestMethod.PUT})
	public String createOrUpdate(@Valid Product product) {// takes a PRoduct object that passes through Validation to make sure its a actual product
		productService.save(product);
		return"redirect:/product/"+product.getId();
	}
}
