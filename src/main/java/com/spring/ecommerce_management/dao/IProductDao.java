
package com.spring.ecommerce_management.dao;

import com.spring.ecommerce_management.domain.Product;
import java.util.List;


public interface IProductDao {
     List<Product> getAllProduct();

    Product getProductById(int productId);

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int productId);

    boolean productExists( String productName);
}
