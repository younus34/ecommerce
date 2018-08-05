/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ecommerce_management.dao;

import com.spring.ecommerce_management.domain.CustomerRegi;
import com.spring.ecommerce_management.domain.Payment;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class PaymentDao implements IPaymentDao {
    
    @Autowired
    private HibernateTemplate hibernateTemplate;    
    
    @Override
    public List<Payment> getAllPayments() {
        String hql = "FROM Payment p LEFT JOIN FETCH  p.customerRegi LEFT JOIN FETCH p.productOrder ORDER BY p.paymentId";
        return (List<Payment>) hibernateTemplate.find(hql);
    }
    
    @Override
    public Payment getPaymentById(int paymentId) {
        return hibernateTemplate.get(Payment.class, paymentId);
    }
    
    @Override
    public void addPayment(Payment payment) {
        hibernateTemplate.save(payment);
    }
    
    @Override
    public void updatePayment(Payment payment) {
        Payment p = getPaymentById(payment.getPaymentId());
        p.setProductOrder(payment.getProductOrder());
        p.setCustomerRegi(payment.getCustomerRegi());
        p.setPaymentType(payment.getPaymentType());
        p.setPaymentDate(payment.getPaymentDate());
        p.setDeliveryZone(payment.getDeliveryZone());
        p.setDiscount(payment.getDiscount());
        p.setGrandTotal(payment.getGrandTotal());
        p.setNetpayment(payment.getNetpayment());
        p.setDeliveryAddress(payment.getDeliveryAddress());
        p.setPaymentStatus(payment.getPaymentStatus());
        hibernateTemplate.update(p);
    }
    
    @Override
    public void deletePayment(int paymentId) {
        hibernateTemplate.delete(getPaymentById(paymentId));
    }
    
    @Override
    public boolean paymentExists(String paymentType) {
        String hql = "FROM Payment as p WHERE p.paymentType= ? ";
        List<Payment> lst = (List<Payment>) hibernateTemplate.find(hql, paymentType);
        return lst.size() > 0 ? true : false;
    }
    
}
