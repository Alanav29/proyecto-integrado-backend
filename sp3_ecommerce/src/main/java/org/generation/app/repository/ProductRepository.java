package org.generation.app.repository;
import java.util.Optional;
import org.generation.app.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
	Optional<Product> findById(Long id);
}
