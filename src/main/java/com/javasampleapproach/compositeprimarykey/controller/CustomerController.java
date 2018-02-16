package com.javasampleapproach.compositeprimarykey.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.compositeprimarykey.model.Customer;
import com.javasampleapproach.compositeprimarykey.repository.CustomerRepository;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/rest/customer")
@RestController
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping(value = "/all")
    public List<Customer> getCustomer() {
    	System.out.println("Retrieving customer data into tables ...");
        return customerRepository.findAll();
    }

   /* @RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<?> addPerson(@RequestBody Customer usersContact) {
		return new ResponseEntity<>(customerRepository.save(usersContact), HttpStatus.CREATED);
	}*/
    
    @PostMapping(value = "/add")
    public List<Customer> create(@RequestBody final Customer customer){
    	System.out.println("Inserting customer data into tables ...");
    	customerRepository.save(customer); 	
    	
    	//Customer usersContact = new Customer();
        /*Users users = new Users();
        UsersLog usersLog = new UsersLog();
        usersLog.setLog("HI Youtube");

        UsersLog usersLog2 = new UsersLog();
        usersLog2.setLog("HI Viewers");

        users.setTeamName("Development")
                .setSalary(10000)
                .setName("Tausif")
                .setUsersLogs(Arrays.asList(usersLog, usersLog2));

        usersContact.setPhoneNo(11111)
                .setUsers(users);

        //persist
        customerRepository.save(usersContact);*/

    	return customerRepository.findAll();
    }
    
    @GetMapping(value = "/update/{name}")
    public List<Customer> update(@PathVariable final String name) {

        Customer customer = new Customer();
        /*Users users = new Users();
        UsersLog usersLog = new UsersLog();
        usersLog.setLog("HI Youtube");

        UsersLog usersLog2 = new UsersLog();
        usersLog2.setLog("HI Viewers");

        /*users.setTeamName("Development")
                .setSalary(10000)
                .setName(name)
                .setUsersLogs(Arrays.asList(usersLog, usersLog2));

        usersContact.setPhoneNo(11111)
                .setUsers(users);
*/
        //persist
        customerRepository.save(customer); 

        //getall
        return customerRepository.findAll();


    }


}
