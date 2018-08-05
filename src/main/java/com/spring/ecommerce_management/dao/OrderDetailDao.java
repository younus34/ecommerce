/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ecommerce_management.dao;

import com.spring.ecommerce_management.domain.OrderDetails;
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
public class OrderDetailDao implements IOrderDetailsDao{
    
      @Autowired
    private HibernateTemplate hibernateTemplate;   

    @Override
    public List<OrderDetails> getAllOrderDetails() {
         String hql = "FROM OrderDetails p LEFT JOIN FETCH  p.productOrder ORDER BY p.orderDetailId";
        return (List<OrderDetails>) hibernateTemplate.find(hql);
    }

    @Override
    public OrderDetails getOrderDetailsById(int orderDetailId) {
        return hibernateTemplate.get(OrderDetails.class, orderDetailId );
    }

    @Override
    public void addOrderDetails(OrderDetails order) {
        hibernateTemplate.save(order);
    }

    @Override
    public void updateOrderDetails(OrderDetails order) {
        OrderDetails p = getOrderDetailsById(order.getOrderDetailId());
        p.setProductOrder(order.getProductOrder());
       p.setOrderQty(order.getOrderQty());
        hibernateTemplate.update(p);
    }

    @Override
    public void deleteOrderDetails(int orderDetailId) {
         hibernateTemplate.delete(getOrderDetailsById(orderDetailId));
    }

    @Override
    public boolean subCategoryExists(int orderId) {
         String hql = "FROM OrderDetails as p WHERE p.productOrder.orderId = ? ";
        List<OrderDetails> lst = (List<OrderDetails>) hibernateTemplate.find(hql,  orderId);
        return lst.size() > 0 ? true : false;

    }
    
}
