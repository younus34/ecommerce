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
 * Product generated by hbm2java
 */
@Entity
@Table(name="product"
    ,catalog="changed"
)
public class Product  implements java.io.Serializable {


     private Integer productId;
     private Category category;
     private SubCategory subCategory;
     private String productName;
     private String productDesc;
     private String productSize;
     private String productUrl;
     private int productQty;
     private Set<Sale> sales = new HashSet<Sale>(0);
     private Set<ProductOrder> productOrders = new HashSet<ProductOrder>(0);
     private Set<Purchase> purchases = new HashSet<Purchase>(0);

    public Product() {
    }

	
    public Product(Category category, SubCategory subCategory, String productName, String productDesc, String productSize, String productUrl, int productQty) {
        this.category = category;
        this.subCategory = subCategory;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productSize = productSize;
        this.productUrl = productUrl;
        this.productQty = productQty;
    }
    public Product(Category category, SubCategory subCategory, String productName, String productDesc, String productSize, String productUrl, int productQty, Set<Sale> sales, Set<ProductOrder> productOrders, Set<Purchase> purchases) {
       this.category = category;
       this.subCategory = subCategory;
       this.productName = productName;
       this.productDesc = productDesc;
       this.productSize = productSize;
       this.productUrl = productUrl;
       this.productQty = productQty;
       this.sales = sales;
       this.productOrders = productOrders;
       this.purchases = purchases;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="product_id", unique=true, nullable=false)
    public Integer getProductId() {
        return this.productId;
    }
    
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cat_id", nullable=false)
    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="sub_cat_id", nullable=false)
    public SubCategory getSubCategory() {
        return this.subCategory;
    }
    
    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    
    @Column(name="product_name", nullable=false, length=45)
    public String getProductName() {
        return this.productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }

    
    @Column(name="product_desc", nullable=false, length=45)
    public String getProductDesc() {
        return this.productDesc;
    }
    
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    
    @Column(name="product_size", nullable=false, length=45)
    public String getProductSize() {
        return this.productSize;
    }
    
    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    
    @Column(name="product_url", nullable=false, length=45)
    public String getProductUrl() {
        return this.productUrl;
    }
    
    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    
    @Column(name="product_qty", nullable=false)
    public int getProductQty() {
        return this.productQty;
    }
    
    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="product")
    public Set<Sale> getSales() {
        return this.sales;
    }
    
    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="product")
    public Set<ProductOrder> getProductOrders() {
        return this.productOrders;
    }
    
    public void setProductOrders(Set<ProductOrder> productOrders) {
        this.productOrders = productOrders;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="product")
    public Set<Purchase> getPurchases() {
        return this.purchases;
    }
    
    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }




}

