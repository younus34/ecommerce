package com.spring.ecommerce_management.dao;

import com.spring.ecommerce_management.domain.CustomerRegi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class CustomerDao implements ICustomerDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
    @Override
    public List<CustomerRegi> getAllCustomers() {
        String hql = "FROM CustomerRegi as p ORDER BY p.customerId";
        return (List<CustomerRegi>) hibernateTemplate.find(hql);
    }

    @Override
    public CustomerRegi getCustomerById(int customerId) {
        return hibernateTemplate.get(CustomerRegi.class, customerId);
    }

    @Override
    public void addCustomer(CustomerRegi customer) {
        hibernateTemplate.save(customer);
    }

    @Override
    public void updateCustomer(CustomerRegi customer) {
        CustomerRegi p = getCustomerById(customer.getCustomerId());
        p.setFirstName(customer.getFirstName());
        p.setLastName(customer.getLastName());
        p.setCustomerEmail(customer.getCustomerEmail());
        p.setCustomerAddress(customer.getCustomerAddress());
        p.setCustomerCity(customer.getCustomerCity());
        p.setCustomerMobile(customer.getCustomerMobile());
        p.setGender(customer.getGender());
        p.setPassword(customer.getPassword());
        p.setJoinDate(customer.getJoinDate());

        hibernateTemplate.update(p);
    }

    @Override
    public void deleteCustomer(int customerId) {
        hibernateTemplate.delete(getCustomerById(customerId));
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean customerExists(String customerEmail, String password) {
        String hql = "FROM CustomerRegi as p WHERE p.customerEmail = ? and p.password = ?";
        List<CustomerRegi> suppliers = (List<CustomerRegi>) hibernateTemplate.find(hql, customerEmail, password);
        return suppliers.size() > 0 ? true : false;
    }

}
