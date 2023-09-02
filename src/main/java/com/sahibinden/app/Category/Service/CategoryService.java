package com.sahibinden.app.Category.Service;

import com.sahibinden.app.Category.Dto.Request.CategoryCreateDto;
import com.sahibinden.app.Category.Dto.Request.CategoryUpdateDto;
import com.sahibinden.app.Category.Model.Category;
import com.sahibinden.app.Category.Repository.CategoryRepo;
import com.sahibinden.app.Utils.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;
    public BaseResponse<Category> create(CategoryCreateDto categoryCreateDto){
        Category newCategory = new Category();
        newCategory.setName(categoryCreateDto.getName());
        categoryRepo.save(newCategory);
        return new BaseResponse<>(true, "OK", newCategory);
    }

    public BaseResponse<Category> update(Long id, CategoryUpdateDto categoryUpdateDto){
        Optional<Category> updatedCategory = categoryRepo.findById(id);
        if (!updatedCategory.isPresent())
        {
            return new BaseResponse<>(false,"Category not found", null);
        }
        updatedCategory.get().setName(categoryUpdateDto.getName());
        categoryRepo.save(updatedCategory.get());
        return new BaseResponse<>(true,"", updatedCategory.get());
    }
    public BaseResponse<Category> softDelete(Long id){
        Optional<Category> updatedCategory = categoryRepo.findById(id);
        if (!updatedCategory.isPresent())
        {
            return new BaseResponse<>(false,"Category not found", null);
        }
        updatedCategory.get().setDeleted(true);
        categoryRepo.save(updatedCategory.get());
        return new BaseResponse<>(true,"", updatedCategory.get());
    }
    public List<Category> unDeletedList(){
        return categoryRepo.GetUnDeletedCategory();
    }
    public List<Category> DeletedList(){
        return categoryRepo.GetDeletedCategory();
    }

}
