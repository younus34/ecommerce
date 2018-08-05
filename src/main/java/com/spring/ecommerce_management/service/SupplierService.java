
package com.spring.ecommerce_management.service;

import com.spring.ecommerce_management.dao.ISupplierDao;
import com.spring.ecommerce_management.domain.SupplierInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService implements ISupplierService{
    
     @Autowired
    private ISupplierDao supplierDao;

    @Override
    public List<SupplierInfo> getAllSuppliers() {
         return supplierDao.getAllSuppliers();
    }

    @Override
    public SupplierInfo getSupplierById(int supplierId) {
         SupplierInfo obj = supplierDao.getSupplierById(supplierId);
        return obj;
        
    }

    @Override
    public synchronized boolean addSupplier(SupplierInfo supplier) {
         if (supplierDao.supplierExists(supplier.getSupplierName(), supplier.getSupplierEmail())) {
            return false;
        } else {
            supplierDao.addSupplier(supplier);
            return true;
        }
    }

    @Override
    public void updateSupplier(SupplierInfo supplier) {
       supplierDao.updateSupplier(supplier);
    }

    @Override
    public void deleteSupplier(int supplierId) {
        supplierDao.deleteSupplier(supplierId);
    }
    
    
}
