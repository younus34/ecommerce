
package com.spring.ecommerce_management.dao;

import com.spring.ecommerce_management.domain.SupplierInfo;
import java.util.List;


public interface ISupplierDao {
    
    List<SupplierInfo> getAllSuppliers();

    SupplierInfo getSupplierById(int supplierId);

    void addSupplier(SupplierInfo supplier);

    void updateSupplier(SupplierInfo supplier);

    void deleteSupplier(int supplierId);

    boolean supplierExists(String supplier_name, String supplier_email);
    
}
