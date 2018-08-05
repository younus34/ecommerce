package com.spring.ecommerce_management.domain;
// Generated Jul 20, 2018 10:14:47 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Sale generated by hbm2java
 */
@Entity
@Table(name="sale"
    ,catalog="changed"
)
public class Sale  implements java.io.Serializable {


     private Integer saleId;
     private Payment payment;
     private Product product;
     private double unitSalePrice;
     private Date saleDate;
     private int productQty;
     private double totalSalePrice;

    public Sale() {
    }

    public Sale(Payment payment, Product product, double unitSalePrice, Date saleDate, int productQty, double totalSalePrice) {
       this.payment = payment;
       this.product = product;
       this.unitSalePrice = unitSalePrice;
       this.saleDate = saleDate;
       this.productQty = productQty;
       this.totalSalePrice = totalSalePrice;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="sale_id", unique=true, nullable=false)
    public Integer getSaleId() {
        return this.saleId;
    }
    
    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="payment_id", nullable=false)
    public Payment getPayment() {
        return this.payment;
    }
    
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product_id", nullable=false)
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }

    
    @Column(name="unit_sale_price", nullable=false, precision=22, scale=0)
    public double getUnitSalePrice() {
        return this.unitSalePrice;
    }
    
    public void setUnitSalePrice(double unitSalePrice) {
        this.unitSalePrice = unitSalePrice;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="sale_date", nullable=false, length=10)
    public Date getSaleDate() {
        return this.saleDate;
    }
    
    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    
    @Column(name="product_qty", nullable=false)
    public int getProductQty() {
        return this.productQty;
    }
    
    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    
    @Column(name="total_sale_price", nullable=false, precision=22, scale=0)
    public double getTotalSalePrice() {
        return this.totalSalePrice;
    }
    
    public void setTotalSalePrice(double totalSalePrice) {
        this.totalSalePrice = totalSalePrice;
    }




}


