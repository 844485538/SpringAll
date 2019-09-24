package com.springboot.bean;

import java.util.Date;

public class Product {
	
	private String description;
	
	private Double price;
	
	private Date availableFrom;

    public Product(final String description, final Double price, final Date availableFrom) {
        this.description = description;
        this.price = price;
        this.availableFrom = availableFrom;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getAvailableFrom() {
		return availableFrom;
	}

	public void setAvailableFrom(Date availableFrom) {
		this.availableFrom = availableFrom;
	}

}
