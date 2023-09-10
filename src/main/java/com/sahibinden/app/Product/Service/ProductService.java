package com.sahibinden.app.Product.Service;

import com.sahibinden.app.Product.Dto.Request.ProductCreateDto;
import com.sahibinden.app.Product.Dto.Request.ProductUpdateDto;
import com.sahibinden.app.Product.Model.Product;
import com.sahibinden.app.Product.Repository.ProductRepo;
import com.sahibinden.app.Utils.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;
    public BaseResponse<Product> Create(ProductCreateDto productCreateDto){
        Product newProduct = new Product();
        newProduct.setName(productCreateDto.getName());
        productRepo.save(newProduct);
        return new BaseResponse<>(true, "OK", newProduct);
    }
    public BaseResponse<Product> Update(Long id, ProductUpdateDto productUpdateDto){
        Optional<Product> updatedProduct = productRepo.findById(id);
        if (!updatedProduct.isPresent())
        {
            return new BaseResponse<>(false,"Product not found", null);
        }
        updatedProduct.get().setName(productUpdateDto.getName());
        productRepo.save(updatedProduct.get());
        return new BaseResponse<>(true,"", updatedProduct.get());
    }
    public BaseResponse<Product> SoftDelete(Long id){
        Optional<Product> updatedProduct = productRepo.findById(id);
        if (!updatedProduct.isPresent())
        {
            return new BaseResponse<>(false,"Product not found", null);
        }
        updatedProduct.get().setDeleted(true);
        productRepo.save(updatedProduct.get());
        return new BaseResponse<>(true,"", updatedProduct.get());
    }
    public List<Product> unDeletedList(){
        return productRepo.GetUnDeletedProduct();
    }
    public List<Product> DeletedList(){
        return productRepo.GetDeletedProduct();
    }

}
