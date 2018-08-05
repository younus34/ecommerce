
package com.spring.ecommerce_management.dao;

import com.spring.ecommerce_management.domain.CustomerRegi;
import java.util.List;


public interface ICustomerDao {
    List<CustomerRegi> getAllCustomers();

    CustomerRegi getCustomerById(int customerId);

    void addCustomer(CustomerRegi customer);

    void updateCustomer(CustomerRegi customer);

    void deleteCustomer(int customerId);

    boolean customerExists(String customerEmail, String password);
}
