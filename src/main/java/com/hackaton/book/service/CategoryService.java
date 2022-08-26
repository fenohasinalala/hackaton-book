package com.hackaton.book.service;

import com.hackaton.book.model.Category;
import com.hackaton.book.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository repository;

    //GET MAPPING
    public List<Category> allCategory(){
        return repository.findAll();
    }
    public List<Category> getCategoryByName(String categoryName){
        return repository.findByNameCategoryContainingIgnoreCase(categoryName);
    }
    public Optional<Category> getCategoryById(Long id){
        return repository.findById(id);
    }

    //POST MAPPING
    public void insertCategory(Category category){
        repository.save(category);
    }

    //DELETE MAPPING
    public void deleteById(Long id){
        repository.deleteById(id);
    }

    //PUT MAPPING
    public void putUpdateCategory(Long id, Category newCategory){
        List<Category> categories = allCategory();
        for(Category categoryInfo : categories){
            if(categoryInfo.getIdCategory() == id){
                if (!(newCategory.getNameCategory() == null)){
                    categoryInfo.setNameCategory(newCategory.getNameCategory());
                }
                repository.save(categoryInfo);
            }
        }
    }

    //PATCH MAPPING
    public void patchUpdateCategory(Long id, Category newCategory){
        List<Category> categories = allCategory();
        for(Category categoryInfo : categories){
            if(categoryInfo.getIdCategory() == id){
                categoryInfo.setNameCategory(newCategory.getNameCategory());
                repository.save(categoryInfo);
            }
        }
    }
}