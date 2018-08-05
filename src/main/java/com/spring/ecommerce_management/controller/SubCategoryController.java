
package com.spring.ecommerce_management.controller;

import com.spring.ecommerce_management.domain.SubCategory;
import com.spring.ecommerce_management.service.ISubCategoryService;
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
@RequestMapping("/category")
public class SubCategoryController {
    
     @Autowired
    private ISubCategoryService subCategoryService;

    @RequestMapping("/home")
    public String home() {
        return "sub_category";
    }
    @RequestMapping(value = "/subcategory", method = RequestMethod.GET)
    public ResponseEntity<List<SubCategory>> getAllFaculty() {
        List<SubCategory> list = subCategoryService.getAllSubCategories();
        return new ResponseEntity<List<SubCategory>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/subcategory/{id}", method = RequestMethod.GET)
    public ResponseEntity<SubCategory> getObjectById(@PathVariable("id") Integer id) {
        SubCategory subcategory = subCategoryService.getSubCategoryById(id);
        return new ResponseEntity<SubCategory>(subcategory, HttpStatus.OK);
    }

    @RequestMapping(value = "/subcategory", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody SubCategory subcategory, UriComponentsBuilder builder) {
        boolean flag = subCategoryService.addSubCategory(subcategory);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/subcategory/{id}").buildAndExpand(subcategory.getSubCatId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/subcategory/{id}", method = RequestMethod.PUT)
    public ResponseEntity<SubCategory> updateSubCategory(@RequestBody SubCategory category) {
        subCategoryService.updateSubCategory(category);
        return new ResponseEntity<SubCategory>(category, HttpStatus.OK);
    }

    @RequestMapping(value = "/subcategory/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        subCategoryService.deleteSubCategory(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    
}
