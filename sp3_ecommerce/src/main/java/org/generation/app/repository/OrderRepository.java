package org.generation.app.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.generation.app.entity.Order;
import org.generation.app.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
	Optional<Order> findById(Long id);
	Optional<ArrayList<Order>> findByUser(User user);
}
