/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ecommerce_management.dao;

import com.spring.ecommerce_management.domain.LoginInfo;
import java.util.List;

/**
 *
 * @author Younus
 */
public interface ILoginInfo {
     List<LoginInfo > getAllLoginInfos();

    LoginInfo  getLoginInfoById(int loginId);

    void addLoginInfo (LoginInfo  login);

    void updateLoginInfo (LoginInfo  login);

    void deleteLoginInfo (int loginId);
   
}
