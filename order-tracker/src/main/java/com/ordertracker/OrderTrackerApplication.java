package com.ordertracker;

import com.ordertracker.entities.*;
import com.ordertracker.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class OrderTrackerApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrderTrackerApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(
		CustomerRepository customerRepository,
		InventoryProductRepository inventoryProductRepository,
		InventoryRepository inventoryRepository,
		OrderRepository orderRepository,
		ProductRepository productRepository,
		VendorRepository vendorRepository
	) {
		return args -> {
			Customer c1 = new Customer();
			c1.setName("Ali");
			c1.setEmail("ali@fee.com");
			c1.setPassword("ali123");
			c1.setPhoneNumber("0111");
			Customer c2 = new Customer();
			c2.setName("Hani");
			c2.setEmail("hani@fee.com");
			c2.setPassword("hani123");
			c2.setPhoneNumber("0112");
			Customer c3 = new Customer();
			c3.setName("Sami");
			c3.setEmail("sami@fee.com");
			c3.setPassword("Sami123");
			c3.setPhoneNumber("0113");
			
			Product p1 = new Product();
			p1.setName("Samsung S20 Ultra");
			p1.setDescription("A samsung phone");
			Product p2 = new Product();
			p2.setName("Iphone 15 Pro Max");
			p2.setDescription("An iphone phone");
			Product p3 = new Product();
			p3.setName("Realme 6 Pro");
			p3.setDescription("A realme phone");
			
			Vendor v1 = new Vendor();
			v1.setName("Ahmed");
			v1.setContactInfo("1111");
			Vendor v2 = new Vendor();
			v2.setName("Sameh");
			v2.setContactInfo("2222");
			
			Inventory i1 = new Inventory();
			i1.setVendor(v1);
			Inventory i2 = new Inventory();
			i2.setVendor(v2);
			
			v1.setInventories(List.of(i1));
			v2.setInventories(List.of(i2));
			
			InventoryProduct iv1 = new InventoryProduct();
			iv1.setProduct(p1);
			iv1.setInventory(i1);
			iv1.setQuantity(5);
			iv1.setPrice(50000.0);
			InventoryProduct iv2 = new InventoryProduct();
			iv2.setProduct(p2);
			iv2.setInventory(i2);
			iv2.setQuantity(3);
			iv2.setPrice(100000.0);
			InventoryProduct iv3 = new InventoryProduct();
			iv3.setProduct(p3);
			iv3.setInventory(i2);
			iv3.setQuantity(10);
			iv3.setPrice(10000.0);
			
			i1.setInventoryProducts(List.of(iv1));
			i2.setInventoryProducts(List.of(iv2, iv3));
			
			p1.setProductInventories(List.of(iv1));
			p2.setProductInventories(List.of(iv2));
			p3.setProductInventories(List.of(iv3));
			
			customerRepository.save(c1);
			customerRepository.save(c2);
			customerRepository.save(c3);
			
			productRepository.save(p1);
			productRepository.save(p2);
			productRepository.save(p3);

			vendorRepository.save(v1);
			vendorRepository.save(v2);

			inventoryRepository.save(i1);
			inventoryRepository.save(i2);

			inventoryProductRepository.save(iv1);
			inventoryProductRepository.save(iv2);
			inventoryProductRepository.save(iv3);
		};
	}
}
