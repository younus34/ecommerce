/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ecommerce_management.service;



import com.spring.ecommerce_management.domain.Sale;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.ecommerce_management.dao.ISaleDao;

/**
 *
 * @author B11
 */
@Service
public class SaleService implements ISaleService{
     @Autowired
    private ISaleDao inventoryDao;
    

    @Override
    public List<Sale> getAllProductInventories() {
         return inventoryDao.getAllProductInventories();
        
    }

    @Override
    public Sale getSaleById(int inventoryId) {
       Sale obj = inventoryDao.getSaleById(inventoryId);
        return obj;
    }

    @Override
    public void addSale(Sale product) {
        inventoryDao.addSale(product);
    }

    @Override
    public void updateSale(Sale product) {
        inventoryDao.updateSale(product);
    }

    @Override
    public void deleteSale(int inventoryId) {
        inventoryDao.deleteSale(inventoryId);
    }
    
}
