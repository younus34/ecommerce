/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ecommerce_management.service;


import com.spring.ecommerce_management.dao.IOrderDetailsDao;
import com.spring.ecommerce_management.domain.OrderDetails;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author B11
 */
@Service
public class OrderDetailService implements IOrderDetailService{
    
     @Autowired
    private IOrderDetailsDao orderDetailsDao;

    @Override
    public List<OrderDetails> getAllOrderDetails() {
       return orderDetailsDao.getAllOrderDetails();
    }

    @Override
    public OrderDetails getOrderDetailsById(int orderDetailId) {
        OrderDetails obj = orderDetailsDao.getOrderDetailsById(orderDetailId);
        return obj;
    }

    @Override
    public boolean addOrderDetails(OrderDetails order) {
         if (orderDetailsDao.subCategoryExists(order.getProductOrder().getOrderId() )) {
            return false;
        } else {
            orderDetailsDao.addOrderDetails(order);
            return true;
        }
    }

    @Override
    public void updateOrderDetails(OrderDetails order) {
        orderDetailsDao.updateOrderDetails(order);
    }

    @Override
    public void deleteOrderDetails(int orderDetailId) {
       orderDetailsDao.deleteOrderDetails(orderDetailId);
    }

    
    
}
