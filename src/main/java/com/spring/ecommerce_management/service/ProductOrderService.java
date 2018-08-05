/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ecommerce_management.service;

import com.spring.ecommerce_management.dao.IproductOrderDao;
import com.spring.ecommerce_management.domain.ProductOrder;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductOrderService implements IProductOrderService{
    
    @Autowired
    private  IproductOrderDao orderDao;

    @Override
    public List<ProductOrder> getAllProductOrders() {
        return orderDao.getAllProductOrders();
    }

    @Override
    public ProductOrder getProductOrderById(int orderId) {
         ProductOrder obj = orderDao.getProductOrderById(orderId);
        return obj;
    }

    @Override
    public synchronized boolean addProductOrder(ProductOrder order) {
         if (orderDao.productOrdeExists( order.getOrderItem())) {
            return false;
        } else {
            orderDao.addProductOrder(order);
            return true;
        }
    }

    @Override
    public void updateProductOrder(ProductOrder order) {
        orderDao.updateProductOrder(order);
    }

    @Override
    public void deleteProductOrder(int orderId) {
         orderDao.deleteProductOrder(orderId);
    }
    
}
