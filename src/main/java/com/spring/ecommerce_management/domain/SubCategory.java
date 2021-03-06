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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SubCategory generated by hbm2java
 */
@Entity
@Table(name="sub_category"
    ,catalog="changed"
)
public class SubCategory  implements java.io.Serializable {


     private Integer subCatId;
     private Category category;
     private String subCatName;
     private String subCatDesc;
     private Set<Product> products = new HashSet<Product>(0);

    public SubCategory() {
    }

	
    public SubCategory(Category category, String subCatName, String subCatDesc) {
        this.category = category;
        this.subCatName = subCatName;
        this.subCatDesc = subCatDesc;
    }
    public SubCategory(Category category, String subCatName, String subCatDesc, Set<Product> products) {
       this.category = category;
       this.subCatName = subCatName;
       this.subCatDesc = subCatDesc;
       this.products = products;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="sub_cat_id", unique=true, nullable=false)
    public Integer getSubCatId() {
        return this.subCatId;
    }
    
    public void setSubCatId(Integer subCatId) {
        this.subCatId = subCatId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cat_id", nullable=false)
    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }

    
    @Column(name="sub_cat_name", nullable=false, length=45)
    public String getSubCatName() {
        return this.subCatName;
    }
    
    public void setSubCatName(String subCatName) {
        this.subCatName = subCatName;
    }

    
    @Column(name="sub_cat_desc", nullable=false, length=45)
    public String getSubCatDesc() {
        return this.subCatDesc;
    }
    
    public void setSubCatDesc(String subCatDesc) {
        this.subCatDesc = subCatDesc;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="subCategory")
    public Set<Product> getProducts() {
        return this.products;
    }
    
    public void setProducts(Set<Product> products) {
        this.products = products;
    }




}


