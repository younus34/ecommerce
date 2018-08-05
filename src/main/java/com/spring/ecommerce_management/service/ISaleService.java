/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ecommerce_management.service;

import com.spring.ecommerce_management.domain.Sale;
import java.util.List;

/**
 *
 * @author B11
 */
public interface ISaleService {
    
     List<Sale> getAllProductInventories();

    Sale getSaleById(int inventoryId);

    void addSale(Sale product);

    void updateSale(Sale product);

    void deleteSale(int inventoryId);

}
