
package com.spring.ecommerce_management.dao;


import com.spring.ecommerce_management.domain.Category;
import java.util.List;


public interface ICategoryDao {
     List<Category> getAllCategories();

    Category getCategoryById(int catId);

    void addCategory(Category category);

    void updateCategory(Category category);

    void deleteCategory(int catId);
    boolean categoryExists(String catName);
}
