package com.coforge.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.coforge.model.Customer;
import com.coforge.model.DeliveryAddress;

@Configuration // used to say container that this is my Config file(like beans.xml(xml based config) but for java based configuration)
public class BeanConfiguration {
	
	
	@Bean(name = "customer1") //Bean annotation(similar like bean object in xml file).
	public Customer getCustomer() {
		Customer customer = new Customer();
		customer.setCustomerId(101);
		customer.setCustomerName("Reshma");
		customer.setEmails(Arrays.asList("reshma@gamil.com","reshmaaailuri@gmail.coms"));
		customer.setDeliveryAddress(Arrays.asList(getDeliveryAddress1(),getDeliveryAddress2()));
		return customer;
		
	}
	
	
	@Bean(name = "deliveryAddress1") //Bean annotation(similar like bean object in xml file).
	public DeliveryAddress getDeliveryAddress1() {
		DeliveryAddress deliveryAddress1 = new DeliveryAddress();
		deliveryAddress1.setCity("City-1");
		deliveryAddress1.setState("State-1");
		return deliveryAddress1;
		
	}
	
	@Bean(name = "deliveryAddress2") //name is equal to Id in bean object in xml file.
	public DeliveryAddress getDeliveryAddress2() {
		DeliveryAddress deliveryAddress1 = new DeliveryAddress();
		return deliveryAddress1;
		
	}
}
