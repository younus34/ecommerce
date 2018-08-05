/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ecommerce_management.service;


import com.spring.ecommerce_management.domain.Purchase;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.ecommerce_management.dao.IPurchaseDao;

/**
 *
 * @author B11
 */
@Service
public class PurchaseService implements IPurchaseService{
     @Autowired
    private IPurchaseDao inventoryDao;
    

    @Override
    public List<Purchase> getAllProductInventories() {
         return inventoryDao.getAllProductInventories();
        
    }

    @Override
    public Purchase getPurchaseById(int inventoryId) {
       Purchase obj = inventoryDao.getPurchaseById(inventoryId);
        return obj;
    }

    @Override
    public void addPurchase(Purchase product) {
        inventoryDao.addPurchase(product);
    }

    @Override
    public void updatePurchase(Purchase product) {
        inventoryDao.updatePurchase(product);
    }

    @Override
    public void deletePurchase(int inventoryId) {
        inventoryDao.deletePurchase(inventoryId);
    }
    
}
