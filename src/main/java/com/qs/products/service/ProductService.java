package com.qs.products.service;

import java.util.List;

import com.qs.products.entity.Product;

public interface ProductService {
	
	/*
	 * Java en las interfaces asume que si no le pones un modificador de accesso su acceso será público
	 * no necesitas el pubic Product ....
	 */
	List<Product> findByName(String dato);
	List<Product> ProductAll();
	Product getForId(Long id);
	Product save(Product product);
	void delete(Long id);
	
	
	
	
}
