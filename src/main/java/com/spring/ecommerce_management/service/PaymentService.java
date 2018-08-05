/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ecommerce_management.service;

import com.spring.ecommerce_management.dao.IPaymentDao;
import com.spring.ecommerce_management.domain.Payment;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Younus
 */
@Service
public class PaymentService implements IPaymentService{
 @Autowired
    private IPaymentDao paymentDao;
    
    @Override
    public List<Payment> getAllPayments() {
        return paymentDao.getAllPayments();
    }

    @Override
    public Payment getPaymentById(int paymentId) {
        Payment obj = paymentDao.getPaymentById(paymentId);
        return obj;
    }

    @Override
    public synchronized boolean addPayment(Payment payment) {
          if (paymentDao.paymentExists(payment.getPaymentType())) {
            return false;
        } else {
            paymentDao.addPayment(payment);
            return true;
        }
    }

    @Override
    public void updatePayment(Payment payment) {
       paymentDao.updatePayment(payment); 
    }

    @Override
    public void deletePayment(int paymentId) {
        paymentDao.deletePayment(paymentId);
    }
    
}
