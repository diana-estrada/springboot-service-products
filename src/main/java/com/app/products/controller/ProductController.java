package com.app.products.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.commons.models.Product;
import com.app.products.service.IProductService;


@RestController
//@RequestMapping("/api/products")
public class ProductController {
	
//	@Autowired
//	private Environment env;
	
	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	private IProductService productService;

	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable Integer id) {
		Product product = productService.findProduct(id);
		//product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		product.setPort(port);
		
//		boolean ok = false;
//		if(ok==false) {
//			throw new Exception("NO SE PUDO CARGAR EL PRODUCTO");
//		}
		
//		try {
//			Thread.sleep(2000L);	
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return product;
	}
	
	@GetMapping("/products/")
	public List<Product> getProducts(){
		return productService.findAll().stream().map(product ->{
			//product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			product.setPort(port);
			return product;
		} ).collect(Collectors.toList());
	}
	
	@PostMapping("/products/")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Product save(@RequestBody Product product) {
		return productService.save(product);
	}
	
	
	@PutMapping("/products/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Product update(@RequestBody Product product, @PathVariable Integer id) {
		Product productoDB = productService.findProduct(id);
		productoDB.setName(product.getName());
		productoDB.setDescription(product.getDescription());
		productoDB.setPrice(product.getPrice());
		
		return productService.save(productoDB);
	}
	
	@DeleteMapping("/products/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		productService.deleteById(id);
	}
}
