package com.uni.baker.service;

import com.uni.baker.entity.Category;
import com.uni.baker.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

import com.uni.baker.utils.*;

@Service
public class CategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    public List<Category> getAllCategories()
    {
        return categoryRepository.findAll();
    }
    public Category getCategoryById(Long id)
    {
        return categoryRepository.findById(id).orElse(null);
    }
    public Category save(Category category)
    {
        return categoryRepository.save(category);
    }

    public void addCategory(Category category)
    {
        String slug = SlugUtils.createSlug(category.getName());
        category.setSlug(slug);
        save(category);
    }
    public void deleteCategory(Long id)
    {
        categoryRepository.deleteById(id);
    }
    public void updateCategory(Category category)
    {
        save(category);
    }
}
