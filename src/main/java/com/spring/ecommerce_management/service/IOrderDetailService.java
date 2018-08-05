/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ecommerce_management.service;

import com.spring.ecommerce_management.domain.OrderDetails;
import java.util.List;

/**
 *
 * @author B11
 */
public interface IOrderDetailService {
    List<OrderDetails> getAllOrderDetails();

    OrderDetails getOrderDetailsById(int orderDetailId);

    boolean addOrderDetails(OrderDetails order);

    void updateOrderDetails(OrderDetails order);

    void deleteOrderDetails(int orderDetailId);
    
}
