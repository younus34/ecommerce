
package com.spring.ecommerce_management.service;

import com.spring.ecommerce_management.domain.SubCategory;
import java.util.List;


public interface ISubCategoryService {
    List<SubCategory> getAllSubCategories();

    SubCategory getSubCategoryById(int subCatId);

    boolean addSubCategory(SubCategory subCategory);

    void updateSubCategory(SubCategory subCategory);

    void deleteSubCategory(int subCatId);
    
}
