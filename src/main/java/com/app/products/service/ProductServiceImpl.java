package com.app.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.commons.models.Product;
import com.app.products.repository.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	private ProductRepository productRepository;


	@Override
	@Transactional(readOnly = true)
	public Product findProduct(Integer id) {
		System.out.println(productRepository.findById(id).orElse(new Product()));
		return productRepository.findById(id).orElse(new Product());
	}


	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}


	@Override
	@Transactional
	public Product save(Product product) {
		return productRepository.save(product);
	}


	@Override
	@Transactional
	public void deleteById(Integer id) {
		productRepository.deleteById(id);
	}

}
