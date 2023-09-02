package com.sahibinden.app.Product.Controller;

import com.sahibinden.app.Product.Dto.Request.ProductCreateDto;
import com.sahibinden.app.Product.Dto.Request.ProductUpdateDto;
import com.sahibinden.app.Product.Model.Product;
import com.sahibinden.app.Product.Service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Tag(name = "Product Controller", description = "Product Controller")
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/create")
    public Product Create(@RequestBody ProductCreateDto productCreateDto){
        return productService.Create(productCreateDto);
    }

    @PutMapping("/update")
    public Product Update(@RequestBody ProductUpdateDto productUpdateDto){
        return productService.Update(productUpdateDto);
    }

    @GetMapping("/soft-delete/{id}")
    public Product SoftDelete(@RequestParam Long id){
        return productService.SoftDelete(id);
    }

    @GetMapping("/detail/{id}")
    public Product Detail(@RequestParam Long id){
        return productService.Detail(id);
    }
}
