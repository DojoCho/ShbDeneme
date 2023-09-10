package com.sahibinden.app.Product.Repository;

import com.sahibinden.app.Product.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

    @Query("select c from Product c where c.isDeleted = false")
    public List<Product> GetUnDeletedProduct();

    @Query("select c from Product c where c.isDeleted = true")
    public List<Product> GetDeletedProduct();

}
