/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ecommerce_management.controller;



import com.spring.ecommerce_management.domain.OrderDetails;
import com.spring.ecommerce_management.service.IOrderDetailService;
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

/**
 *
 * @author B11
 */
@Controller
@RequestMapping("/orderdetail")
public class OrderdetailController {
    
     @Autowired
    private IOrderDetailService orderDetailService;
     
     @RequestMapping("/home")
    public String home() {
        return "orderDetail";
    }
    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public ResponseEntity<List<OrderDetails>> getAllFaculty() {
        List<OrderDetails> list = orderDetailService.getAllOrderDetails();
        return new ResponseEntity<List<OrderDetails>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public ResponseEntity<OrderDetails> getObjectById(@PathVariable("id") Integer id) {
        OrderDetails details = orderDetailService.getOrderDetailsById(id);
        return new ResponseEntity<OrderDetails>(details, HttpStatus.OK);
    }

    @RequestMapping(value = "/details", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody OrderDetails details, UriComponentsBuilder builder) {
        boolean flag = orderDetailService.addOrderDetails(details);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/details/{id}").buildAndExpand(details.getOrderDetailId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.PUT)
    public ResponseEntity<OrderDetails> updateOrderDetail(@RequestBody OrderDetails category) {
        orderDetailService.updateOrderDetails(category);
        return new ResponseEntity<OrderDetails>(category, HttpStatus.OK);
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        orderDetailService.deleteOrderDetails(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    
}
