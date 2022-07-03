package com.logo.controller;

import com.logo.model.Product;
import com.logo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    //güncelleme yapma
    @PutMapping("/{product}")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }
    //ürün silme
    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable("productname") Integer id){
        return productService.deleteProduct(id);
    }

}
