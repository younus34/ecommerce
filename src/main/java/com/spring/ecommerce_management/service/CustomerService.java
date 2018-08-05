
package com.spring.ecommerce_management.service;


import com.spring.ecommerce_management.dao.ICustomerDao;
import com.spring.ecommerce_management.domain.CustomerRegi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService{

     @Autowired
    private ICustomerDao customerDao;

    
    @Override
    public List<CustomerRegi> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    @Override
    public CustomerRegi getCustomerById(int customerId) {
         CustomerRegi obj = customerDao.getCustomerById(customerId);
        return obj;
    }

    @Override
    public synchronized boolean addCustomer(CustomerRegi customer) {
        if (customerDao.customerExists(customer.getCustomerEmail(), customer.getPassword())) {
            return false;
        } else {
            customerDao.addCustomer(customer);
            return true;
        }
    }

    @Override
    public void updateCustomer(CustomerRegi customer) {
        customerDao.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(int customerId) {
        customerDao.deleteCustomer(customerId);
    }
    
}
