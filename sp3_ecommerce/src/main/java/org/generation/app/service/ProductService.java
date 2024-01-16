package org.generation.app.service;

import java.util.List;
import org.generation.app.entity.Product;

public interface ProductService {
	Product getProductById(Long id);
	Product createProduct(Product product);
	List<Product> getAllProducts();
	Product updateProduct(Product product, Long id); // No estoy seguro si está bien, era (Product user)
	void deleteProduct(Long id);
}
