package org.generation.app.service.impl;

import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.generation.app.entity.Product;
import org.generation.app.repository.ProductRepository;
import org.generation.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

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
		product.setId(null);
		Optional<Product> productOptional = productRepository.findByTitle(product.getTitle());
		if( productOptional.isPresent() && productOptional.get().getActive() == true) { 
			throw new IllegalStateException("Product already exist ");
		} else {
			Cloudinary cloudinary = new Cloudinary("cloudinary://992384659953544:Ff7CsjP8fpYGNDPRWPnEGamkal4@dtyazhppg");
			try {
				String base64Image = product.getImg();
				int commaIndex = base64Image.indexOf(",");
				String base64Data = base64Image.substring(commaIndex + 1);
				byte[] imageBytes = Base64.getDecoder().decode(base64Data);
	
	            // Subir la imagen a Cloudinary
	            Map uploadResult = cloudinary.uploader().upload(imageBytes, ObjectUtils.emptyMap());
	            String secureUrl = (String) uploadResult.get("secure_url");
	            product.setImg(secureUrl);
	            product.setActive(true);
	            Product newProduct = productRepository.save( product );
	            return newProduct;
	            
	        } catch (Exception e) {
	        	
	        	throw new IllegalStateException("Cannot upload img " );
	        }
		}
		
		
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = (List<Product>) productRepository.findAllByActive(true);
		return products;
	}

	@Override // Se puede mejorar
	public Product deleteProduct(Long id) {
		Product existingProduct = getProductById(id);
		existingProduct.setActive(false);
		return productRepository.save( existingProduct );
	}

	@Override // Se puede mejorar creo¿
	public Product updateProduct(Product product, Long id) {
		Product existingProduct = getProductById(id);
		
		if(!product.getTitle().equals(""))existingProduct.setTitle( product.getTitle() );
		if(product.getPrice() != 0)existingProduct.setPrice( product.getPrice() );
		if(!product.getTechnique().equals(""))existingProduct.setTechnique( product.getTechnique() );
		if(product.getWidth() != 0)existingProduct.setWidth( product.getWidth() );
		if(product.getHeight() != 0)existingProduct.setHeight( product.getHeight() );
		if(!product.getColor().equals(""))existingProduct.setColor( product.getColor() );
		if(!product.getImg().equals("")) {
			
			Cloudinary cloudinary = new Cloudinary("cloudinary://992384659953544:Ff7CsjP8fpYGNDPRWPnEGamkal4@dtyazhppg");
			try {
				String base64Image = product.getImg();
				int commaIndex = base64Image.indexOf(",");
				String base64Data = base64Image.substring(commaIndex + 1);
				byte[] imageBytes = Base64.getDecoder().decode(base64Data);
	
	            // Subir la imagen a Cloudinary
	            Map uploadResult = cloudinary.uploader().upload(imageBytes, ObjectUtils.emptyMap());
	            String secureUrl = (String) uploadResult.get("secure_url");
	            existingProduct.setImg(secureUrl);
	            
	            
	            
	        } catch (Exception e) {
	        	
	        	throw new IllegalStateException("Cannot upload img " );
	        }
			
		}
		return productRepository.save( existingProduct );
	}
	
}
