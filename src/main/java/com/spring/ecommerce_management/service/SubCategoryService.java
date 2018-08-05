
package com.spring.ecommerce_management.service;

import com.spring.ecommerce_management.dao.ISubCategoryDao;
import com.spring.ecommerce_management.domain.SubCategory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryService implements ISubCategoryService{

    
    @Autowired
    private ISubCategoryDao subCategoryDao;
    
    @Override
    public List<SubCategory> getAllSubCategories() {
        return subCategoryDao.getAllSubCategories();
    }

    @Override
    public SubCategory getSubCategoryById(int subCatId) {
        SubCategory obj = subCategoryDao.getSubCategoryById(subCatId);
        return obj;
    }

    @Override
    public boolean addSubCategory(SubCategory subCategory) {
        if (subCategoryDao.subCategoryExists(subCategory.getCategory().getCatId(), subCategory.getSubCatName())) {
            return false;
        } else {
            subCategoryDao.addSubCategory(subCategory);
            return true;
        }
    }

    @Override
    public void updateSubCategory(SubCategory subCategory) {
        subCategoryDao.updateSubCategory(subCategory);
    }

    @Override
    public void deleteSubCategory(int subCatId) {
        subCategoryDao.deleteSubCategory(subCatId);
    }
    
}
