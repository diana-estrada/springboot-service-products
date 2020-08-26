package com.app.products.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
	
	@Id
	private Integer id;
	private String name;
	private String description;
	private String type;
	private Double price;
	private Integer quantity;
	private Integer minQuantity;
	
	@Transient
	private Integer port;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Integer id, String name, String description, String type, Double price, Integer quantity,
			Integer minQuantity) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
		this.minQuantity = minQuantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getMinQuantity() {
		return minQuantity;
	}

	public void setMinQuantity(Integer minQuantity) {
		this.minQuantity = minQuantity;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

}

