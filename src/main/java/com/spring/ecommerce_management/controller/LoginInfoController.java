/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ecommerce_management.controller;

import com.spring.ecommerce_management.domain.LoginInfo;
import com.spring.ecommerce_management.service.ILoginInfoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Younus
 */
@Controller
@RequestMapping("/login")
public class LoginInfoController {
    
    @Autowired
    private ILoginInfoService loginuserService;
     
     @RequestMapping("/home")
    public String home() {
        return "login";
    }

    @RequestMapping(value = "/loginuser/{id}", method = RequestMethod.GET)
    public ResponseEntity<LoginInfo> getSupplierById(@PathVariable("id") Integer id) {
        LoginInfo loginuser = loginuserService.getLoginInfoById(id);
        return new ResponseEntity<LoginInfo>(loginuser, HttpStatus.OK);
    }

    @RequestMapping(value = "/loginuser", method = RequestMethod.GET)
    public ResponseEntity<List<LoginInfo>> getAllSuppliers() {
        List<LoginInfo> list = loginuserService.getAllLoginInfos();
        return new ResponseEntity<List<LoginInfo>>(list, HttpStatus.OK);
    }

    
//    public ResponseEntity<Void> addSupplier(@RequestBody LoginInfo loginuser, UriComponentsBuilder builder) {
////        boolean flag = loginuserService.addLoginInfo(loginuser);
////        if (flag == false) {
////            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
////        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/loginuser/{id}").buildAndExpand(loginuser.getLoginInfoId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }
    @RequestMapping(value = "/loginuser", method = RequestMethod.POST)
     public ResponseEntity<LoginInfo> addSupplier(@RequestBody LoginInfo loginuser) {
        loginuserService.addLoginInfo(loginuser);
        return new ResponseEntity<LoginInfo>(loginuser, HttpStatus.OK);
    }
    
    

    @RequestMapping(value = "/loginuser/{id}", method = RequestMethod.PUT)
    public ResponseEntity<LoginInfo> updateLogin(@RequestBody LoginInfo loginuser) {
        loginuserService.updateLoginInfo(loginuser);
        return new ResponseEntity<LoginInfo>(loginuser, HttpStatus.OK);
    }

    @RequestMapping(value = "/loginuser/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteSupplier(@PathVariable("id") Integer id) {
        loginuserService.deleteLoginInfo(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    
}
