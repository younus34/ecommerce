
package com.spring.ecommerce_management.controller;



import com.spring.ecommerce_management.domain.CustomerRegi;
import com.spring.ecommerce_management.service.ICustomerService;
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
@RequestMapping("/cust")
public class CustomerController {
     @Autowired
    private ICustomerService customerService;
     
     @RequestMapping("/home")
    public String home() {
        return "customer";
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public ResponseEntity<CustomerRegi> getSupplierById(@PathVariable("id") Integer id) {
        CustomerRegi customer = customerService.getCustomerById(id);
        return new ResponseEntity<CustomerRegi>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public ResponseEntity<List<CustomerRegi>> getAllSuppliers() {
        List<CustomerRegi> list = customerService.getAllCustomers();
        return new ResponseEntity<List<CustomerRegi>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public ResponseEntity<Void> addSupplier(@RequestBody CustomerRegi customer, UriComponentsBuilder builder) {
        boolean flag = customerService.addCustomer(customer);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/customer/{id}").buildAndExpand(customer.getCustomerId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CustomerRegi> updateSupplier(@RequestBody CustomerRegi customer) {
        customerService.updateCustomer(customer);
        return new ResponseEntity<CustomerRegi>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteSupplier(@PathVariable("id") Integer id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    
}
