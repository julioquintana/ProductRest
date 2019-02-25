package com.qs.products.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qs.products.entity.Product;
import com.qs.products.entity.repository.ProductRepository;
import com.qs.products.service.ProductService;



@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override //le estas diciendo que estas sobreescribiendo el método del contrato.
	public Product getForId(Long id) {
		return getProductFromOptional(productRepository.findById(id));
	}
	
	private Product getProductFromOptional(Optional<Product> optionalProduct){
		return optionalProduct.get();
	}
	
	private List<Product> ListAllProduct(){
		return null;
	}

	@Override
	public Product save(Product product) {
		
		product.setName(product.getName().toUpperCase());
		Product sku = productRepository.save(product);
		return sku;
	}

	@Override
	public void delete(Long id) {
		 productRepository.deleteById(id);
	}

	@Override
	public List<Product> ProductAll() {
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public List<Product> findByName(String dato) {
		// TODO Auto-generated method stub
		return (List<Product>) productRepository.findByNameIsContaining(dato);
	}
	

}
