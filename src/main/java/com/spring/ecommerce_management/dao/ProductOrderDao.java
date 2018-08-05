/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ecommerce_management.dao;

import com.spring.ecommerce_management.domain.ProductOrder;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public class ProductOrderDao implements IproductOrderDao {
    
    @Autowired
    private HibernateTemplate hibernateTemplate;
    
    @Override
    public List<ProductOrder> getAllProductOrders() {
        String hql = "FROM ProductOrder p LEFT JOIN FETCH p.purchase LEFT JOIN FETCH p.product LEFT JOIN FETCH p.customerRegi  ORDER BY p.orderId";
        return (List<ProductOrder>) hibernateTemplate.find(hql);
    }
    
    @Override
    public ProductOrder getProductOrderById(int orderId) {
        return hibernateTemplate.get(ProductOrder.class, orderId);
    }
    
    @Override
    public void addProductOrder(ProductOrder order) {
        hibernateTemplate.save(order);
    }
    
    @Override
    public void updateProductOrder(ProductOrder order) {
        ProductOrder p = getProductOrderById(order.getOrderId());
        p.setCustomerRegi(order.getCustomerRegi());
        p.setPurchase(order.getPurchase());
        p.setProduct(order.getProduct());
        p.setOrderItem(order.getOrderItem());
        p.setOrderDate(order.getOrderDate());
        p.setItemQty(order.getItemQty());
        p.setPrice(order.getPrice());
        p.setTotalPrice(order.getTotalPrice());
        p.setOrderStatus(order.getOrderStatus());
        
          hibernateTemplate.update(p);
    }
    
    @Override
    public void deleteProductOrder(int orderId) {
        hibernateTemplate.delete(getProductOrderById(orderId));
    }
    
    @Override
    public boolean productOrdeExists(String orderItem) {
        String hql = "FROM ProductOrder as p WHERE p.orderItem=?";
        List<ProductOrder> lst = (List<ProductOrder>) hibernateTemplate.find(hql, orderItem);
        return lst.size() > 0 ? true : false;
    }
    
}
