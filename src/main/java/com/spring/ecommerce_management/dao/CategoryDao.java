
package com.spring.ecommerce_management.dao;

import com.spring.ecommerce_management.domain.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class CategoryDao implements ICategoryDao{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;
    
 @SuppressWarnings("unchecked")
    @Override
    public List<Category> getAllCategories() {
        String hql="FROM Category as p ORDER BY p.catId";
        return(List<Category>) hibernateTemplate.find(hql);
    }

    @Override
    public Category getCategoryById(int catId) {
        return hibernateTemplate.get(Category.class, catId);
    }

    @Override
    public void addCategory(Category category) {
       hibernateTemplate.save(category);
    }

    @Override
    public void updateCategory(Category category) {
       Category p = getCategoryById(category.getCatId());
       p.setCatName(category.getCatName());
       p.setCatDesc(category.getCatDesc());
       hibernateTemplate.update(p);
    }

    @Override
    public void deleteCategory(int catId) {
        hibernateTemplate.delete(getCategoryById(catId));
    }

    @Override
    public boolean categoryExists(String catName) {
         String hql = "FROM Category as p WHERE p.catName = ?";
        List<Category> category = (List<Category>) hibernateTemplate.find(hql, catName);
        return category.size() > 0 ? true : false;
    }
    
    
}
