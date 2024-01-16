package org.generation.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.generation.app.entity.Product;
import org.generation.app.repository.ProductRepository;
import org.generation.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepository;

	@Override
	public Product getProductById(Long id) {
	Optional<Product> productOptional = productRepository.findById(id);
		
		if( productOptional.isPresent()) return productOptional.get();
		else throw new IllegalStateException("Product does not exist with id " + id);
	}

	@Override
	public Product createProduct(Product product) {
		Product newProduct = productRepository.save( product );
		return newProduct;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = (List<Product>) productRepository.findAll();
		return products;
	}

	@Override // Se puede mejorar
	public void deleteProduct(Long id) {
		Product existingProduct = getProductById(id);
		productRepository.delete(existingProduct);
	}

	@Override // Se puede mejorar creo¿
	public Product updateProduct(Product product, Long id) {
		Product existingProduct = getProductById(id);
		existingProduct.setTitle( product.getTitle() );
		existingProduct.setPrice( product.getPrice() );
		existingProduct.setDescription( product.getDescription() );
		existingProduct.setWidth( product.getWidth() );
		existingProduct.setHeigth( product.getHeigth() );
		existingProduct.setColor( product.getColor() );
		existingProduct.setImg( product.getImg() );
		return productRepository.save( existingProduct );
	}
	
}
