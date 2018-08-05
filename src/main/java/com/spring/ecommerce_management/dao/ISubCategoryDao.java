
package com.spring.ecommerce_management.dao;

import com.spring.ecommerce_management.domain.SubCategory;
import java.util.List;


public interface ISubCategoryDao {
     List<SubCategory> getAllSubCategories();

    SubCategory getSubCategoryById(int subCatId);

    void addSubCategory(SubCategory subCategory);

    void updateSubCategory(SubCategory subCategory);

    void deleteSubCategory(int subCatId);
    boolean subCategoryExists(int catId, String subCatName);
    
}
