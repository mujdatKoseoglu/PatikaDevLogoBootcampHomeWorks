package com.logo.service;

import com.logo.Repository.ProductRepository;
import com.logo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.logo.model.Product;


@Service
//@Scope("prototype")
public class ProductService {

	@Autowired
	private ProductRepository productRepository;


	//ürün oluşturma
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	//ürün güncelleme
	public Product updateProduct(Product product) {
		Product product1 = productRepository.findById(product.getId()).get();
		product1.setName(product.getName());
		product1.setPrice(product.getPrice());
		return productRepository.save(product1);
	}

	//ürün silme
	public Product deleteProduct(Integer id) {
		Product product1 = productRepository.findById(id).get();
		productRepository.deleteById(id);
		System.out.println(id + " no lu id silindi");
		return product1;
	}
}