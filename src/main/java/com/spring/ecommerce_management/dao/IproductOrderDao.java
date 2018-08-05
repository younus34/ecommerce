
package com.spring.ecommerce_management.dao;

import com.spring.ecommerce_management.domain.ProductOrder;
import java.util.List;


public interface IproductOrderDao {
    List<ProductOrder> getAllProductOrders();

    ProductOrder getProductOrderById(int orderId);

    void addProductOrder(ProductOrder order);

    void updateProductOrder(ProductOrder order);

    void deleteProductOrder(int orderId);

    boolean productOrdeExists(String orderItem);
    
    
}
