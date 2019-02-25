package com.qs.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qs.products.entity.Product;
import com.qs.products.service.ProductService;

@RestController
@RequestMapping("/producto" )
public class ProductController {

	/*
	 * Date cuenta que aqui estas llamando a la interfáz
	 * spring va a buscar que clase implementa la interfaz y si hay mas de una clase que lo implementa
	 * te va a pedir que le digas quien es con @Qualifier
	 */
	@Autowired
	private ProductService productservice; 
	
	
	@GetMapping("/get/name/{dato}")
	public ResponseEntity<List<Product>> findByName(@PathVariable("dato")String dato){
		List<Product> produ = productservice.findByName(dato);
		
		// 200 OK , 201 Creado, 203 Acceptado, 400 Error de validacion, 404 no encontrado, 500 Error interno
		return new ResponseEntity<List<Product>>(produ, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>> all(){
		List<Product> produ = productservice.ProductAll();
		
		// 200 OK , 201 Creado, 203 Acceptado, 400 Error de validacion, 404 no encontrado, 500 Error interno
		return new ResponseEntity<List<Product>>(produ, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public HttpEntity<Product> getProductForId(@PathVariable("id")Long id){
		// productservice.getForId(id); 
		
		Product product = productservice.getForId(id);
		
		// 200 OK , 201 Creado, 203 Acceptado, 400 Error de validacion, 404 no encontrado, 500 Error interno
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}


	@PostMapping("/save")
	public HttpEntity<Product> save(@RequestBody Product product){
		Product produ = productservice.save(product);
		
		// 200 OK , 201 Creado, 203 Acceptado, 400 Error de validacion, 404 no encontrado, 500 Error interno
		return new ResponseEntity<Product>(produ, HttpStatus.CREATED);
	}

	@DeleteMapping("/del/{id}")
	public ResponseEntity<Void> del(@PathVariable long id){
		productservice.delete(id);
		
		// 200 OK , 201 Creado, 203 Acceptado, 400 Error de validacion, 404 no encontrado, 500 Error interno
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
