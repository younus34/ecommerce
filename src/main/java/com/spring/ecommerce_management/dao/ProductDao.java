package com.spring.ecommerce_management.dao;

import com.spring.ecommerce_management.domain.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ProductDao implements IProductDao {
    
    @Autowired
    private HibernateTemplate hibernateTemplate;    
    
    @Override
    public List<Product> getAllProduct() {
        String hql = "FROM Product p  LEFT JOIN FETCH p.category LEFT JOIN FETCH p.subCategory ORDER BY p.productId";
        return (List<Product>) hibernateTemplate.find(hql);
    }
    
    @Override
    public Product getProductById(int productId) {
        return hibernateTemplate.get(Product.class, productId);
    }
    
    @Override
    public void addProduct(Product product) {
        hibernateTemplate.save(product);
    }
    
    @Override
    public void updateProduct(Product product) {
        Product p = getProductById(product.getProductId());
       
        p.setSubCategory(product.getSubCategory());
        p.setCategory(product.getCategory());
        p.setProductDesc(product.getProductDesc());
     p.setProductUrl(product.getProductUrl());
        p.setProductName(product.getProductName());
        p.setProductQty(product.getProductQty());
        p.setProductSize(product.getProductSize());
        
        hibernateTemplate.update(p);
    }
    
    @Override
    public void deleteProduct(int productId) {
        hibernateTemplate.delete(getProductById(productId));        
    }
    
    @Override
    public boolean productExists(String productName) {
        String hql = "FROM Product as p WHERE p.productName=?";
        List<Product> lst = (List<Product>) hibernateTemplate.find(hql, productName);
        return lst.size() > 0 ? true : false;
    }
    
}
