
package com.spring.ecommerce_management.service;

import com.spring.ecommerce_management.domain.CustomerRegi;
import java.util.List;


public interface ICustomerService {
    List<CustomerRegi> getAllCustomers();

    CustomerRegi getCustomerById(int customerId);

    boolean addCustomer(CustomerRegi customer);

    void updateCustomer(CustomerRegi customer);

    void deleteCustomer(int customerId);

    
    
}
