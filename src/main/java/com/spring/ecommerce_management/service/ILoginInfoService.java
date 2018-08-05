/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ecommerce_management.service;

import com.spring.ecommerce_management.domain.LoginInfo;
import java.util.List;

/**
 *
 * @author Younus
 */
public interface ILoginInfoService {
     List<LoginInfo > getAllLoginInfos();

    LoginInfo  getLoginInfoById(int priceId);

    void addLoginInfo (LoginInfo  price);

    void updateLoginInfo (LoginInfo  price);

    void deleteLoginInfo (int priceId);
}
