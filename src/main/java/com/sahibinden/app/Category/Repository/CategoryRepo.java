package com.sahibinden.app.Category.Repository;

import com.sahibinden.app.Category.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    @Query("select c from Category c where c.deleted = false")
    public List<Category> GetUnDeletedCategory();

    @Query("select c from Category c where c.deleted = true")
    public List<Category> GetDeletedCategory();

}
