package org.generation.app.controller;

import java.util.List;

import org.generation.app.entity.Order;
import org.generation.app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping
	ResponseEntity<Order> setOrders(@RequestBody Order order){
		Order newOrder = orderService.createOrder(order);
		return new ResponseEntity<>( newOrder, HttpStatus.CREATED);
	}
	
	@GetMapping
	ResponseEntity< List<Order> > getAllOrders(){
		List<Order> orders = orderService.getAllOrders();
		return new ResponseEntity<>( orders, HttpStatus.OK);
	}
}
