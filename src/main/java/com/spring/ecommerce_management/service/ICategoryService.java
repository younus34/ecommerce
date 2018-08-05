
package com.spring.ecommerce_management.service;

import com.spring.ecommerce_management.domain.Category;
import java.util.List;


public interface ICategoryService {
    List<Category> getAllCategories();

    Category getCategoryById(int catId);

    boolean addCategory(Category category);

    void updateCategory(Category category);

    void deleteCategory(int catId);
    
}
