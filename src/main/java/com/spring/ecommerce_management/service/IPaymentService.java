/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ecommerce_management.service;

import com.spring.ecommerce_management.domain.Payment;
import java.util.List;

/**
 *
 * @author B11
 */
public interface IPaymentService {
     List<Payment> getAllPayments();

    Payment getPaymentById(int paymentId);

   boolean addPayment(Payment payment);

    void updatePayment(Payment payment);

    void deletePayment(int paymentId);
}
