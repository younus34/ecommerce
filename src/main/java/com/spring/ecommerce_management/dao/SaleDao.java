/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ecommerce_management.dao;

import com.spring.ecommerce_management.domain.Sale;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author B11
 */
@Transactional
@Repository
public class SaleDao implements ISaleDao{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;  

    @Override
    public List<Sale> getAllProductInventories() {
         String hql = "FROM Sale p LEFT JOIN FETCH p.product LEFT JOIN FETCH p.payment  ORDER BY p.saleId";
        return (List<Sale>) hibernateTemplate.find(hql);
    }

    @Override
    public Sale getSaleById(int inventoryId) {
       return hibernateTemplate.get(Sale.class, inventoryId);
    }

    @Override
    public void addSale(Sale product) {
         hibernateTemplate.save(product);
    }

    @Override
    public void updateSale(Sale product) {
        Sale p = getSaleById(product.getSaleId());
        
        p.setProduct(product.getProduct());
        p.setPayment(product.getPayment());
        p.setProductQty(product.getProductQty());
        p.setUnitSalePrice(product.getUnitSalePrice());
        p.setTotalSalePrice(product.getTotalSalePrice());
        p.setSaleDate(product.getSaleDate());
        hibernateTemplate.update(p);
    }

    @Override
    public void deleteSale(int inventoryId) {
      hibernateTemplate.delete(getSaleById(inventoryId));      
    }

   
}
