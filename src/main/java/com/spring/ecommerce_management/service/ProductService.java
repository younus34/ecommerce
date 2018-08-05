
package com.spring.ecommerce_management.service;

import com.spring.ecommerce_management.dao.IProductDao;
import com.spring.ecommerce_management.domain.Product;
import com.spring.ecommerce_management.service.IProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{
    
    @Autowired
    private IProductDao productDao;
    

    @Override
    public List<Product> getAllProduct() {
        return productDao.getAllProduct();
    }

    @Override
    public Product getProductById(int productId) {
         Product obj = productDao.getProductById(productId);
        return obj;
    }

    @Override
    public synchronized boolean addProduct(Product product) {
         if (productDao.productExists(product.getProductName())) {
            return false;
        } else {
            productDao.addProduct(product);
            return true;
        }
    }

    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    @Override
    public void deleteProduct(int productId) {
         productDao.deleteProduct(productId);
    }
    
}
