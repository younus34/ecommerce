/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ecommerce_management.dao;


import com.spring.ecommerce_management.domain.Purchase;
import java.util.List;

/**
 *
 * @author B11
 */
public interface IPurchaseDao {
     List<Purchase> getAllProductInventories();

    Purchase getPurchaseById(int inventoryId);

    void addPurchase(Purchase product);

    void updatePurchase(Purchase product);

    void deletePurchase(int inventoryId);

}
