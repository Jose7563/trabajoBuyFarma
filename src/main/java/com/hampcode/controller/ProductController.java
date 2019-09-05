package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import com.hampcode.business.ProductBusiness;
import com.hampcode.model.entity.Product;
import com.hampcode.util.Message;

@Named
public class ProductController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProductBusiness productBusiness;

	private List<Product> products;
	
	private Product product; 
	
	

	@PostConstruct
	public void init() {
		products=new ArrayList<Product>();
		getAllProducts();
	}
	
	public void getAllProducts() {
		try {
			products=productBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de Productos");
		}
	}

	
	public String newProduct() {
		return "/product/insert.xhtml";
	}
	
	public String goListProduct() {
		return "/product/list.xhtml";
	}
	
//	public String save() throws Exception {
//		productBusiness.insert(product);
//		return "/product/list.xhtml";
//	}
//	
	
	
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
