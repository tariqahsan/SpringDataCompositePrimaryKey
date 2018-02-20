package com.javasampleapproach.compositeprimarykey.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="order_detail")
public class OrderDetail {
	
	@Id
	@Column(name="order_id")
	private String orderId;
	
    @ManyToOne
    @JsonBackReference
    @JoinColumns({
        @JoinColumn(name = "brandcode", referencedColumnName = "brandcode"),
        @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    })
    private Customer customer;
    
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id", referencedColumnName = "product_id")
	private Product product;

    
    public OrderDetail(){}
    
    public OrderDetail(String orderId, Customer customer, Product product) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.product = product;
	}

    
    public void setOrderId(String orderId){
    	this.orderId = orderId;
    }
    
    public String getOrderId(){
    	return this.orderId;
    }
    
    public void setCustomer(Customer customer){
    	this.customer = customer;
    }
    
    public Customer getCustomer(){
    	return this.customer;
    }

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
    
}