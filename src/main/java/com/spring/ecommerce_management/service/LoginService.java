/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ecommerce_management.service;

import com.spring.ecommerce_management.domain.LoginInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;
import com.spring.ecommerce_management.dao.ILoginInfo;

/**
 *
 * @author Younus
 */
@Service
public class LoginService implements ILoginInfoService{
    
     @Autowired
    private ILoginInfo priceDao;


    @Override
    public List<LoginInfo> getAllLoginInfos() {
        return priceDao.getAllLoginInfos();
    }

    @Override
    public LoginInfo getLoginInfoById(int priceId) {
         LoginInfo obj = priceDao.getLoginInfoById(priceId);
        return obj;
    }

    @Override
    public void addLoginInfo(LoginInfo price) {
        priceDao.addLoginInfo(price);
    }

    @Override
    public void updateLoginInfo(LoginInfo price) {
         priceDao.updateLoginInfo(price);
    }

    @Override
    public void deleteLoginInfo(int priceId) {
        priceDao.deleteLoginInfo(priceId);
    }
    
}
