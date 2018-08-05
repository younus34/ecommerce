package com.spring.ecommerce_management.dao;

import com.spring.ecommerce_management.domain.SupplierInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class SupplierDao implements ISupplierDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
    @Override
    public List<SupplierInfo> getAllSuppliers() {
        String hql = "FROM SupplierInfo as p ORDER BY p.supplierId";
        return (List<SupplierInfo>) hibernateTemplate.find(hql);
    }

    @Override
    public SupplierInfo getSupplierById(int supplierId) {

        return hibernateTemplate.get(SupplierInfo.class, supplierId);
    }

    @Override
    public void addSupplier(SupplierInfo supplier) {
        hibernateTemplate.save(supplier);
    }

    @Override
    public void updateSupplier(SupplierInfo supplier) {

        SupplierInfo p = getSupplierById(supplier.getSupplierId());
        p.setSupplierName(supplier.getSupplierName());
        p.setSupplierAddress(supplier.getSupplierAddress());
        p.setSupplierState(supplier.getSupplierState());
        p.setSupplierZip(supplier.getSupplierZip());
        p.setSupplierCity(supplier.getSupplierCity());
        p.setSupplierEmail(supplier.getSupplierEmail());
        p.setSupplierCompany(supplier.getSupplierCompany());
        p.setSupplierJoinDate(supplier.getSupplierJoinDate());
        
        hibernateTemplate.update(p);
    }

    @Override
    public void deleteSupplier(int supplierId) {
        hibernateTemplate.delete(getSupplierById(supplierId));
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean supplierExists(String supplier_name, String supplier_email) {
        String hql = "FROM SupplierInfo as p WHERE p.supplierName = ? and p.supplierEmail = ?";
        List<SupplierInfo> suppliers = (List<SupplierInfo>) hibernateTemplate.find(hql, supplier_name, supplier_email);
        return suppliers.size() > 0 ? true : false;
    }

}
