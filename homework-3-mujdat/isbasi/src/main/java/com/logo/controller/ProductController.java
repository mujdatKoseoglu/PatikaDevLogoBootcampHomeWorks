package com.logo.controller;

import com.logo.model.Product;
import com.logo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    //ekleme yapma
    @PostMapping
    public Product createProduct(@RequestBody Product productRequest){
        return productService.createProduct(productRequest);
    }
    //productname'e göre ürün getirme
    @GetMapping("/{productname}")
    public Product getByNameProduct(@PathVariable("productname") String productname){
        return productService.getByNameProduct(productname);
    }
    //güncelleme yapma
    @PutMapping("/{productname}")
    public Product updateName(@PathVariable("productname") String productname,@RequestBody Product product){
        return productService.updateName(productname,product);
    }
    //ürün silme
    @DeleteMapping("/{productname}")
    public Product deleteProduct(@PathVariable("productname") String productname){
        return productService.deleteProduct(productname);
    }
    //bütün ürünleri getirme
    @GetMapping
    public List<Product> getByAllProduct(){
        return productService.getByAllProduct();
    }
}
