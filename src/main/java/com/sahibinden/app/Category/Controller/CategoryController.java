package com.sahibinden.app.Category.Controller;

import com.sahibinden.app.Category.Dto.Request.CategoryCreateDto;
import com.sahibinden.app.Category.Dto.Request.CategoryUpdateDto;
import com.sahibinden.app.Category.Model.Category;
import com.sahibinden.app.Category.Service.CategoryService;
import com.sahibinden.app.Utils.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Category Controller", description = "Category Controller")
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public BaseResponse<Category> create(@RequestBody CategoryCreateDto categoryCreateDto) {
        return categoryService.create(categoryCreateDto);
    }

    @PutMapping("/update/{id}")
    public BaseResponse<Category> update(@PathVariable(value="id") Long id, @RequestBody CategoryUpdateDto categoryUpdateDto) {
        return categoryService.update(id, categoryUpdateDto);
    }

    @GetMapping("/softdelete/{id}")
    public BaseResponse<Category> softDelete(@PathVariable(value="id") Long id) {
        return categoryService.softDelete(id);
    }

    @GetMapping("/list")
    public List<Category> list() {
        return categoryService.unDeletedList();
    }
    @GetMapping("/list-deleted")
    public List<Category> listDeleted() {
        return categoryService.DeletedList();
    }

}
