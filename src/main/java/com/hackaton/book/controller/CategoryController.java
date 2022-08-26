package com.hackaton.book.controller;

import com.hackaton.book.model.Category;
import com.hackaton.book.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@AllArgsConstructor
public class CategoryController {
    private CategoryService service;

    @GetMapping("/categories")
    public List<Category> getAllCategories(@RequestParam(name = "name", required = false)String name){
        if(name != null){
            return service.getCategoryByName(name);
        }else{
            return service.allCategory();
        }
    }

    @GetMapping("/categories/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id){
        return service.getCategoryById(id);
    }

    @PostMapping("/categories")
    public void insertCategory(@RequestBody Category category){
        service.insertCategory(category);
    }

    @DeleteMapping("/categories/{id}")
    public void deleteId(@PathVariable(name = "id")Long id){
        service.deleteById(id);
    }

    @PutMapping("/categories/{id}")
    public void updateCategories(
            @PathVariable Long id,
            @RequestBody Category category
    ){
        service.putUpdateCategory(id, category);
    }
    @PatchMapping("/categories/{id}")
    public void patchUser(
            @PathVariable Long id,
            @RequestBody Category newCategory
    ){
        service.patchUpdateCategory(id, newCategory);
    }
}