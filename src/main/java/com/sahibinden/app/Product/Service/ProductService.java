package com.sahibinden.app.Product.Service;

import com.sahibinden.app.Product.Dto.Request.ProductCreateDto;
import com.sahibinden.app.Product.Dto.Request.ProductUpdateDto;
import com.sahibinden.app.Product.Model.Product;
import com.sahibinden.app.Product.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public Product Create(ProductCreateDto productCreateDto){
        return new Product();
    }

    public Product Update(ProductUpdateDto productUpdateDto){
        return new Product();
    }

    public Product SoftDelete(Long id){
        return new Product();
    }

    public Product Detail(Long id){
        return new Product();
    }


}
