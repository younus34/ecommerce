
package com.spring.ecommerce_management.service;

import com.spring.ecommerce_management.domain.Product;
import java.util.List;


public interface IProductService {
     List<Product> getAllProduct();

    Product getProductById(int productId);

    boolean addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int productId);

    
}
