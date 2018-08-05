package com.spring.ecommerce_management.domain;
// Generated Jul 20, 2018 10:14:47 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Category generated by hbm2java
 */
@Entity
@Table(name="category"
    ,catalog="changed"
)
public class Category  implements java.io.Serializable {


     private Integer catId;
     private String catName;
     private String catDesc;
     private Set<Product> products = new HashSet<Product>(0);
     private Set<SubCategory> subCategories = new HashSet<SubCategory>(0);

    public Category() {
    }

	
    public Category(String catName, String catDesc) {
        this.catName = catName;
        this.catDesc = catDesc;
    }
    public Category(String catName, String catDesc, Set<Product> products, Set<SubCategory> subCategories) {
       this.catName = catName;
       this.catDesc = catDesc;
       this.products = products;
       this.subCategories = subCategories;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="cat_id", unique=true, nullable=false)
    public Integer getCatId() {
        return this.catId;
    }
    
    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    
    @Column(name="cat_name", nullable=false, length=45)
    public String getCatName() {
        return this.catName;
    }
    
    public void setCatName(String catName) {
        this.catName = catName;
    }

    
    @Column(name="cat_desc", nullable=false, length=45)
    public String getCatDesc() {
        return this.catDesc;
    }
    
    public void setCatDesc(String catDesc) {
        this.catDesc = catDesc;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="category")
    public Set<Product> getProducts() {
        return this.products;
    }
    
    public void setProducts(Set<Product> products) {
        this.products = products;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="category")
    public Set<SubCategory> getSubCategories() {
        return this.subCategories;
    }
    
    public void setSubCategories(Set<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }




}


