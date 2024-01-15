package org.generation.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.generation.app.entity.Order;
import org.generation.app.repository.OrderRepository;
import org.generation.app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository orderRepository;

	@Override
	public Order getOrderById(Long id) {
		Optional<Order> orderOptional = orderRepository.findById(id);
		
		if( orderOptional.isPresent()) return orderOptional.get();
		else throw new IllegalStateException("Order does not exist with id " + id);
	}

	@Override
	public Order createOrder(Order order) {
		Order newOrder = orderRepository.save( order );
		return newOrder;
	}

	@Override
	public List<Order> getAllOrders() {
		List<Order> orders = (List<Order>) orderRepository.findAll();
		return orders;
	}
	

	@Override
	public void deleteOrder(Long id) {
	//No se deben borrar ordenes para evitar conflictos en base de datos
		
	}

}
