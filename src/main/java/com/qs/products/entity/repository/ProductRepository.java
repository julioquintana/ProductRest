package com.qs.products.entity.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qs.products.entity.Product;

@Repository
@Transactional
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	public List<Product> findByNameIsContaining(String name);

}
