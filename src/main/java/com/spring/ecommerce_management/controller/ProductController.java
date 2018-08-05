
package com.spring.ecommerce_management.controller;



import com.spring.ecommerce_management.domain.Product;
import com.spring.ecommerce_management.service.IProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/pro")
public class ProductController {
    
     @Autowired
    private IProductService productService;
     
     
     @RequestMapping("/home")
    public String home() {
        return "product";
    }
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAllFaculty() {
        List<Product> list = productService.getAllProduct();
        return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> getObjectById(@PathVariable("id") Integer id) {
        Product product = productService.getProductById(id);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody Product product, UriComponentsBuilder builder) {
        boolean flag = productService.addProduct(product);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/product/{id}").buildAndExpand(product.getProductId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        productService.deleteProduct(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    
    
}
