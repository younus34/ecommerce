package com.spring.ecommerce_management.domain;
// Generated Jul 20, 2018 10:14:47 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * LoginInfo generated by hbm2java
 */
@Entity
@Table(name="login_info"
    ,catalog="changed"
)
public class LoginInfo  implements java.io.Serializable {


     private Integer loginId;
     private String username;
     private String password;
     private String email;

    public LoginInfo() {
    }

    public LoginInfo(String username, String password, String email) {
       this.username = username;
       this.password = password;
       this.email = email;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="login_id", unique=true, nullable=false)
    public Integer getLoginId() {
        return this.loginId;
    }
    
    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    
    @Column(name="username", nullable=false, length=45)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    
    @Column(name="password", nullable=false, length=45)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="email", nullable=false, length=45)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }




}


