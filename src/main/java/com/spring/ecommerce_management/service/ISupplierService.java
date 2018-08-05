
package com.spring.ecommerce_management.service;

import com.spring.ecommerce_management.domain.SupplierInfo;
import java.util.List;


public interface ISupplierService {
    
     List<SupplierInfo> getAllSuppliers();

    SupplierInfo getSupplierById(int supplier_id);

    boolean addSupplier(SupplierInfo supplier);

    void updateSupplier(SupplierInfo supplier);

    void deleteSupplier(int supplier_id);
    
}
