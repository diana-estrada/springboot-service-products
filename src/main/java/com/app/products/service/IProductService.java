package com.app.products.service;

import java.util.List;

import com.app.commons.models.Product;

public interface IProductService {
	
	public Product findProduct(Integer id);
	
	public List<Product> findAll();
	
	public Product save(Product product);
	
	public void deleteById(Integer id);

}
