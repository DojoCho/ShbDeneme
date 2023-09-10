package com.sahibinden.app.Product.Controller;

import com.sahibinden.app.Product.Dto.Request.ProductCreateDto;
import com.sahibinden.app.Product.Dto.Request.ProductUpdateDto;
import com.sahibinden.app.Product.Model.Product;
import com.sahibinden.app.Product.Service.ProductService;
import com.sahibinden.app.Utils.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Product Controller", description = "Product Controller")
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/create")
    public BaseResponse<Product> create(@RequestBody ProductCreateDto productCreateDto){
        return productService.Create(productCreateDto);
    }

    @PutMapping("/update/{id}")
    public BaseResponse<Product> update(@PathVariable(value="id") Long id, @RequestBody ProductUpdateDto productUpdateDto){
        return productService.Update(id, productUpdateDto);
    }

    @GetMapping("/soft-delete/{id}")
    public BaseResponse<Product> softDelete(@PathVariable(value="id") Long id){
        return productService.SoftDelete(id);
    }

    @GetMapping("/list")
    public List<Product> list() {
        return productService.unDeletedList();
    }
    @GetMapping("/list-deleted")
    public List<Product> listDeleted() {
        return productService.DeletedList();
    }
}
