/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ecommerce_management.controller;


import com.spring.ecommerce_management.domain.ProductOrder;
import com.spring.ecommerce_management.service.IProductOrderService;
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
 * @author Younus
 */
@Controller
@RequestMapping("/order")
public class ProductOrderController {
    
     @Autowired
    private IProductOrderService productOrderService;

    @RequestMapping("/home")
    public String home() {
        return "order";
    }
    @RequestMapping(value = "/productOrder", method = RequestMethod.GET)
    public ResponseEntity<List<ProductOrder>> getAllFaculty() {
        List<ProductOrder> list = productOrderService.getAllProductOrders();
        return new ResponseEntity<List<ProductOrder>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/productOrder/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductOrder> getObjectById(@PathVariable("id") Integer id) {
        ProductOrder productOrder = productOrderService.getProductOrderById(id);
        return new ResponseEntity<ProductOrder>(productOrder, HttpStatus.OK);
    }

    @RequestMapping(value = "/productOrder", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody ProductOrder productOrder, UriComponentsBuilder builder) {
        boolean flag = productOrderService.addProductOrder(productOrder);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/productOrder/{id}").buildAndExpand(productOrder.getOrderId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/productOrder/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ProductOrder> updateOrder(@RequestBody ProductOrder order) {
        productOrderService.updateProductOrder(order);
        return new ResponseEntity<ProductOrder>(order, HttpStatus.OK);
    }

    @RequestMapping(value = "/productOrder/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        productOrderService.deleteProductOrder(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    
}
