package com.jotaempresas.curso_springBoot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jotaempresas.curso_springBoot.entites.Category;
import com.jotaempresas.curso_springBoot.servicies.CategoryService;


@RestController 
@RequestMapping ("/categories/") 
public class CategoryResource {
	
	@Autowired
	private CategoryService orderService; 	
	
	@GetMapping   
	public ResponseEntity<List<Category>> findAll(){ 
		List<Category> list = orderService.findAll();		
		return ResponseEntity.ok().body(list);		
	};
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = orderService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

	

}
