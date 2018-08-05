
package com.spring.ecommerce_management.controller;

import com.spring.ecommerce_management.domain.SupplierInfo;
import com.spring.ecommerce_management.service.ISupplierService;
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
@RequestMapping("/info")
public class SupplierController {
    
     @Autowired
    private ISupplierService supplierService;

    @RequestMapping("/home")
    public String home() {
        return "supplierinfo";
    }

    @RequestMapping(value = "/supplier/{id}", method = RequestMethod.GET)
    public ResponseEntity<SupplierInfo> getSupplierById(@PathVariable("id") Integer id) {
        SupplierInfo supplier = supplierService.getSupplierById(id);
        return new ResponseEntity<SupplierInfo>(supplier, HttpStatus.OK);
    }

    @RequestMapping(value = "/supplier", method = RequestMethod.GET)
    public ResponseEntity<List<SupplierInfo>> getAllSuppliers() {
        List<SupplierInfo> list = supplierService.getAllSuppliers();
        return new ResponseEntity<List<SupplierInfo>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/supplier", method = RequestMethod.POST)
    public ResponseEntity<Void> addSupplier(@RequestBody SupplierInfo supplier, UriComponentsBuilder builder) {
        boolean flag = supplierService.addSupplier(supplier);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/supplier/{id}").buildAndExpand(supplier.getSupplierId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/supplier/{id}", method = RequestMethod.PUT)
    public ResponseEntity<SupplierInfo> updateSupplier(@RequestBody SupplierInfo supplier) {
        supplierService.updateSupplier(supplier);
        return new ResponseEntity<SupplierInfo>(supplier, HttpStatus.OK);
    }

    @RequestMapping(value = "/supplier/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteSupplier(@PathVariable("id") Integer id) {
        supplierService.deleteSupplier(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    
}
