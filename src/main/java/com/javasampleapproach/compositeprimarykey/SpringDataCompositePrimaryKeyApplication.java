package com.javasampleapproach.compositeprimarykey;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javasampleapproach.compositeprimarykey.model.Customer;
import com.javasampleapproach.compositeprimarykey.model.CustomerId;
import com.javasampleapproach.compositeprimarykey.model.OrderDetail;
import com.javasampleapproach.compositeprimarykey.model.Product;
import com.javasampleapproach.compositeprimarykey.service.CustomerServices;
import com.javasampleapproach.compositeprimarykey.service.OrderServices;

@SpringBootApplication
public class SpringDataCompositePrimaryKeyApplication implements CommandLineRunner{

	@Autowired
	CustomerServices customerService;
	
	@Autowired
	OrderServices orderServices;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataCompositePrimaryKeyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		deleteAll();
		//saveData();
		//showAll();
	}
	
	public void deleteAll(){
		System.out.println("===============Delete All Customers===============");
		
		orderServices.deleteAll();
		customerService.deleteAll();
	}
	
	public void saveData(){
		System.out.println("===============Storing Customers===============");
		
		// ===============Create customers===============
		// 1. Jack
		CustomerId jackId = new CustomerId(1000, "azc");
		Customer jack = new Customer(jackId, "A & Z", "Jack");

		Product product1 = new Product(123, "IPhone 7", "Apple IPhone 7");
		Product product2 = new Product(165, "IPad Mini 3", "Apple IPad Mini 3");
		
		OrderDetail jackIphoneOrder = new OrderDetail("001", jack, product1);
		OrderDetail jackIPadMiniOrder = new OrderDetail("002", jack, product2);
		
		Set<OrderDetail> jackOrderDetails = new HashSet<OrderDetail>(Arrays.asList(jackIphoneOrder, jackIPadMiniOrder));
		
		jack.setOrderDetails(jackOrderDetails);
		
		// 2. Mary
		CustomerId maryId = new CustomerId(2000, "mkl");
		Customer mary = new Customer(maryId, "Fashion Company", "Mary");
		
		Product product3 = new Product(123, "Galaxy Note 7", "Samsung Galaxy Note 7");
		
		OrderDetail maryNote7Order = new OrderDetail("003", mary, product3);
		
		Set<OrderDetail> maryOrderDetails = new HashSet<OrderDetail>(Arrays.asList(maryNote7Order));
		
		mary.setOrderDetails(maryOrderDetails);
		
		// ===============Saving to DB===============
		
		customerService.save(jack);
		customerService.save(mary);
		
	}
	
	public void showAll(){
		System.out.println("===============Show All Customers' Info===============");
		customerService.showAll();
	}
}
