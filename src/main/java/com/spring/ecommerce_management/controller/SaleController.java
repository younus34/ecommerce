/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ecommerce_management.controller;



import com.spring.ecommerce_management.domain.Sale;
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
import com.spring.ecommerce_management.service.ISaleService;


@Controller
@RequestMapping("/sale")
public class SaleController {
     @Autowired
    private ISaleService iinventoryService;
     
     
     @RequestMapping("/home")
    public String home() {
        return "sale";
    }
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ResponseEntity<List<Sale>> getAllFaculty() {
        List<Sale> list = iinventoryService.getAllProductInventories();
        return new ResponseEntity<List<Sale>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public ResponseEntity<Sale> getObjectById(@PathVariable("id") Integer id) {
        Sale product = iinventoryService.getSaleById(id);
        return new ResponseEntity<Sale>(product, HttpStatus.OK);
    }

//    @RequestMapping(value = "/product", method = RequestMethod.POST)
//    public ResponseEntity<Void> addObject(@RequestBody Sale product, UriComponentsBuilder builder) {
////        boolean flag = iinventoryService.addSale(product);
////        if (flag == false) {
////            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
////        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/product/{id}").buildAndExpand(product.getInventoryId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }
    
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ResponseEntity<Sale> addSale(@RequestBody Sale product) {
        iinventoryService.addSale(product);
        return new ResponseEntity<Sale>(product, HttpStatus.OK);
    }
    

    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Sale> updateSale(@RequestBody Sale product) {
        iinventoryService.updateSale(product);
        return new ResponseEntity<Sale>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        iinventoryService.deleteSale(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    
}
