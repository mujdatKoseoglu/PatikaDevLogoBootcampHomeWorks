package com.logo.repository;

import com.logo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    //ürünleri sakladığımız listemiz
    static List<Product> productList=new ArrayList<>();
    //ürünleri oluşturduğumuz metod
    public Product createProduct(Product product) {
         productList.add(product);
         return product;
    }
    //isme göre ürünümüzü geri döndüren metodumuz
    public Product getByNameProduct(String nameRequest) {
        Product product1=productList.stream().filter(k->k.getName().equals(nameRequest)).findFirst().orElseThrow();
        return product1;
    }
    //ürün güncelleme metodumuz
    public Product updateName(String name, Product product) {
        Product product1=productList.stream().filter(k->k.getName().equals(name)).findFirst().orElseThrow();
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        return product1;

    }
    //ürün silme metodumuz
    public Product deleteProduct(String nameRequest) {
        Product product1=productList.stream().filter(k->k.getName().equals(nameRequest)).findFirst().orElseThrow();
        productList.remove(product1);
        return product1;
    }
    //tüm ürünlerimizi geri döndüren metodumuz
    public List<Product> getByAllProduct() {
        return productList;
    }
}
