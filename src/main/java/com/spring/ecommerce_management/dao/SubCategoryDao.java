
package com.spring.ecommerce_management.dao;

import com.spring.ecommerce_management.domain.SubCategory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class SubCategoryDao implements ISubCategoryDao{

    
     @Autowired
    private HibernateTemplate hibernateTemplate;    
     
     
    @Override
    public List<SubCategory> getAllSubCategories() {
         String hql = "FROM SubCategory p LEFT JOIN FETCH  p.category ORDER BY p.subCatId";
        return (List<SubCategory>) hibernateTemplate.find(hql);
    }

    @Override
    public SubCategory getSubCategoryById(int subCatId) {
         return hibernateTemplate.get(SubCategory.class, subCatId );
    }

    @Override
    public void addSubCategory(SubCategory subCategory) {
         hibernateTemplate.save(subCategory);
    }

    @Override
    public void updateSubCategory(SubCategory subCategory) {
        SubCategory p = getSubCategoryById(subCategory.getSubCatId());
        p.setCategory(subCategory.getCategory());
        p.setSubCatName(subCategory.getSubCatName());
        p.setSubCatDesc(subCategory.getSubCatDesc());
        hibernateTemplate.update(p);
        
    }

    @Override
    public void deleteSubCategory(int subCatId) {
         hibernateTemplate.delete(getSubCategoryById(subCatId));
    }

    @Override
    public boolean subCategoryExists(int catId, String subCatName) {
        String hql = "FROM SubCategory as p WHERE p.category.catId = ? and p.subCatName=?";
        List<SubCategory> lst = (List<SubCategory>) hibernateTemplate.find(hql, catId, subCatName);
        return lst.size() > 0 ? true : false;
    }
    
    
}
