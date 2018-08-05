/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ecommerce_management.dao;

import com.spring.ecommerce_management.domain.Purchase;
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
public class PurchaseDao implements IPurchaseDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Purchase> getAllProductInventories() {
        String hql = "FROM Purchase p LEFT JOIN FETCH p.product LEFT JOIN FETCH p.supplierInfo  ORDER BY p.purchaseId";
        return (List<Purchase>) hibernateTemplate.find(hql);
    }

    @Override
    public Purchase getPurchaseById(int inventoryId) {
        return hibernateTemplate.get(Purchase.class, inventoryId);
    }

    @Override
    public void addPurchase(Purchase product) {
        hibernateTemplate.save(product);
    }

    @Override
    public void updatePurchase(Purchase product) {
        Purchase p = getPurchaseById(product.getPurchaseId());

        p.setProduct(product.getProduct());
        p.setSupplierInfo(product.getSupplierInfo());
        p.setProductQty(product.getProductQty());
        p.setPurUnitPrice(product.getPurUnitPrice());
        p.setPurTotalPrice(product.getPurTotalPrice());
        p.setPurDate(product.getPurDate());

        hibernateTemplate.update(p);
    }

    @Override
    public void deletePurchase(int inventoryId) {
        hibernateTemplate.delete(getPurchaseById(inventoryId));
    }

}
