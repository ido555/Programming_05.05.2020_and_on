package com.example.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.Product;

@RestController
@RequestMapping("products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductsController {
	private List<Product> products = new ArrayList<Product>();

	@GetMapping
	public List<Product> getAllProducts() {
		products.clear();
		products.add(new Product("Laptop", 9000, new Date(System.currentTimeMillis())));
		products.add(new Product("N95 Mask", 60, new Date(System.currentTimeMillis())));
		products.add(new Product("Labradoodle", 1800, new Date(System.currentTimeMillis())));
		products.add(new Product("Poodledoodle", 900, new Date(System.currentTimeMillis())));
		return products;
	}

	// getOne/id
	@GetMapping("/{id}")
	public ResponseEntity<?> getOneProduct(@PathVariable long id) {
		for (Product product : products) {
			if (product.getId() == id) {
				return ResponseEntity.ok(product);
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("product id not found");
	}
}
