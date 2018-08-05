/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ecommerce_management.dao;

import com.spring.ecommerce_management.domain.LoginInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Younus
 */
@Transactional
@Repository
public class LoginInfoDao implements ILoginInfo{
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<LoginInfo> getAllLoginInfos() {
         String hql = "FROM LoginInfo as p ORDER BY p.loginId";
        return (List<LoginInfo>) hibernateTemplate.find(hql);
    }

    @Override
    public LoginInfo getLoginInfoById(int loginId) {
        return hibernateTemplate.get(LoginInfo.class, loginId);
    }

    @Override
    public void addLoginInfo(LoginInfo login) {
        hibernateTemplate.save(login);
    }

    @Override
    public void updateLoginInfo(LoginInfo login) {
        LoginInfo p = getLoginInfoById(login.getLoginId());
       p.setUsername(login.getUsername());
       p.setPassword(login.getPassword());
       p.setEmail(login.getEmail());
       
        
         hibernateTemplate.update(p);
    }

    @Override
    public void deleteLoginInfo(int loginId) {
      hibernateTemplate.delete(getLoginInfoById(loginId));
    }
    
}
