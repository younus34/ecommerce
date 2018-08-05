
package com.spring.ecommerce_management.controller;


import com.spring.ecommerce_management.domain.Category;
import com.spring.ecommerce_management.service.ICategoryService;
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
@RequestMapping("/com")
public class CategoryController {
    
    @Autowired
    private ICategoryService categoryService;
    
    @RequestMapping("/home")
    public String home() {
        return "category";
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Integer id) {
        Category category = categoryService.getCategoryById(id);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> list = categoryService.getAllCategories();
        return new ResponseEntity<List<Category>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public ResponseEntity<Void> addCategory(@RequestBody Category category, UriComponentsBuilder builder) {
        boolean flag = categoryService.addCategory(category);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/category/{id}").buildAndExpand(category.getCatId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        categoryService.updateCategory(category);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Integer id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    
}
