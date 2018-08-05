/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ecommerce_management.dao;

import com.spring.ecommerce_management.domain.CustomerRegi;
import com.spring.ecommerce_management.domain.Payment;
import java.util.List;

/**
 *
 * @author B11
 */
public interface IPaymentDao {
    List<Payment> getAllPayments();

    Payment getPaymentById(int paymentId);

    void addPayment(Payment payment);

    void updatePayment(Payment payment);

    void deletePayment(int paymentId);
    boolean paymentExists(String paymentType);
    
    
   
}
