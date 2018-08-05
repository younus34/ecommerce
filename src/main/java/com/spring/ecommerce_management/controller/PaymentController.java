/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ecommerce_management.controller;


import com.spring.ecommerce_management.domain.Payment;
import com.spring.ecommerce_management.service.IPaymentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/pay")
public class PaymentController {
    
     @Autowired
    private IPaymentService paymentService;

    @RequestMapping("/home")
    public String home() {
        return "payment";
    }
    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public ResponseEntity<List<Payment>> getAllFaculty() {
        List<Payment> list = paymentService.getAllPayments();
        return new ResponseEntity<List<Payment>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/payment/{id}", method = RequestMethod.GET)
    public ResponseEntity<Payment> getObjectById(@PathVariable("id") Integer id) {
        Payment subcategory = paymentService.getPaymentById(id);
        return new ResponseEntity<Payment>(subcategory, HttpStatus.OK);
    }

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody Payment subcategory, UriComponentsBuilder builder) {
        boolean flag = paymentService.addPayment(subcategory);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/payment/{id}").buildAndExpand(subcategory.getPaymentId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/payment/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Payment> updatePayment(@RequestBody Payment category) {
        paymentService.updatePayment(category);
        return new ResponseEntity<Payment>(category, HttpStatus.OK);
    }

    @RequestMapping(value = "/payment/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        paymentService.deletePayment(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    
}
