/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ecommerce_management.service;

import com.spring.ecommerce_management.domain.ProductOrder;
import java.util.List;

/**
 *
 * @author Younus
 */
public interface IProductOrderService {
     List<ProductOrder> getAllProductOrders();

    ProductOrder getProductOrderById(int orderId);

    boolean addProductOrder(ProductOrder order);

    void updateProductOrder(ProductOrder order);

    void deleteProductOrder(int orderId);
}
