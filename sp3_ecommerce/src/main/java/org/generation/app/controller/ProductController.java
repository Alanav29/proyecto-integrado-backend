package org.generation.app.controller;

import java.util.List;

import org.generation.app.entity.Product;
import org.generation.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/products")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping
	ResponseEntity< List<Product> > getAllProducts(){
		List<Product> products = productService.getAllProducts();
		return new ResponseEntity<>( products, HttpStatus.OK);
	}
	@GetMapping("{id}")
	ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
		Product product = productService.getProductById(id);
		return new ResponseEntity<>(product, HttpStatus.OK );
	}
	@PostMapping
	ResponseEntity<Product> createProduct(@Validated @RequestBody Product product) {	
		Product newProduct = productService.createProduct(product);
		return new ResponseEntity<>(newProduct, HttpStatus.CREATED );
	}
	

	@PutMapping("{id}")
	ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("id") Long id) {
		Product updatedProduct = productService.updateProduct(product, id);
		return new ResponseEntity<>(updatedProduct, HttpStatus.OK );
	}

}
