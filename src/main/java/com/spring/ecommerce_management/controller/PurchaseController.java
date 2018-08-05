/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ecommerce_management.controller;



import com.spring.ecommerce_management.domain.Purchase;
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
import com.spring.ecommerce_management.service.IPurchaseService;


@Controller
@RequestMapping("/purchase")
public class PurchaseController {
     @Autowired
    private IPurchaseService iinventoryService;
     
     
     @RequestMapping("/home")
    public String home() {
        return "purchase";
    }
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ResponseEntity<List<Purchase>> getAllFaculty() {
        List<Purchase> list = iinventoryService.getAllProductInventories();
        return new ResponseEntity<List<Purchase>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public ResponseEntity<Purchase> getObjectById(@PathVariable("id") Integer id) {
        Purchase product = iinventoryService.getPurchaseById(id);
        return new ResponseEntity<Purchase>(product, HttpStatus.OK);
    }

//    @RequestMapping(value = "/product", method = RequestMethod.POST)
//    public ResponseEntity<Void> addObject(@RequestBody Purchase product, UriComponentsBuilder builder) {
////        boolean flag = iinventoryService.addPurchase(product);
////        if (flag == false) {
////            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
////        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/product/{id}").buildAndExpand(product.getInventoryId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }
    
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ResponseEntity<Purchase> addPurchase(@RequestBody Purchase product) {
        iinventoryService.addPurchase(product);
        return new ResponseEntity<Purchase>(product, HttpStatus.OK);
    }
    

    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Purchase> updatePurchase(@RequestBody Purchase product) {
        iinventoryService.updatePurchase(product);
        return new ResponseEntity<Purchase>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        iinventoryService.deletePurchase(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    
}
