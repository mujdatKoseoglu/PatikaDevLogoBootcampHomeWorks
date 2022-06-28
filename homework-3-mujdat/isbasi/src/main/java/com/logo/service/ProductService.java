package com.logo.service;

import com.logo.model.Product;
import com.logo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Scope("prototype")
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	public String url = "default url";
	public String username = "default username";
	public String password = "default password";

	public ProductService() {
		super();
	}

	public ProductService(String url, String username, String password) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
	}
	//ürün oluşturma
	public Product createProduct(Product product) {
		return productRepository.createProduct(product);
	}
	//isme göre ürün getirme
	public Product getByNameProduct(String nameRequest) {
		return productRepository.getByNameProduct(nameRequest);
	}
	//ürün güncelleme
	public Product updateName(String name, Product product) {
		return productRepository.updateName(name,product);
	}
	//ürün silme
	public Product deleteProduct(String nameRequest) {
		return productRepository.deleteProduct(nameRequest);}
	//tüm ürünlerin listesini getirme
	public List<Product> getByAllProduct() {
		return productRepository.getByAllProduct();
	}
}
