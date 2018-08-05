
package com.spring.ecommerce_management.service;

import com.spring.ecommerce_management.dao.ICategoryDao;
import com.spring.ecommerce_management.domain.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService{
    
    @Autowired
    private ICategoryDao categoryDao;

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
       
    }

    @Override
    public Category getCategoryById(int catId) {
        Category obj=categoryDao.getCategoryById(catId);
        return obj;
    }

    @Override
    public synchronized boolean addCategory(Category category) {
        if (categoryDao.categoryExists(category.getCatName() )) {
            return false;
        } else {
            categoryDao.addCategory(category);
            return true;
        }
    }

    @Override
    public void updateCategory(Category category) {
        categoryDao.updateCategory(category);
    }

    @Override
    public void deleteCategory(int catId) {
        categoryDao.deleteCategory(catId);
    }
    
    
}
