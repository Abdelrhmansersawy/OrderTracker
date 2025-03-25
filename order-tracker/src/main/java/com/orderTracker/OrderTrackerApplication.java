package com.orderTracker;

import com.orderTracker.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrderTrackerApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrderTrackerApplication.class, args);
	}
//
	@Bean
	public CommandLineRunner commandLineRunner(
		CustomerRepository customerRepository,
		InventoryItemRepository inventoryItemRepository,
		InventoryRepository inventoryRepository,
		OrderItemRepository orderItemRepository,
		OrderRepository orderRepository,
		ProductRepository productRepository,
		VendorRepository vendorRepository
	) {
		return args -> {
//			Customer c1 = new Customer();
//			c1.setName("Ahmed");
//			c1.setEmail("Ahmed@fee.com");
//			c1.setPassword("ahmed123");
//			c1.setPhoneNumber("0111213");

//			Customer c2 = new Customer();
//			c2.setName("Hani");
//			c2.setEmail("hani@fee.com");
//			c2.setPassword("hani123");
//			c2.setPhoneNumber("0112");
//			Customer c3 = new Customer();
//			c3.setName("Sami");
//			c3.setEmail("sami@fee.com");
//			c3.setPassword("sami123");
//			c3.setPhoneNumber("0113");
//
//			Product p1 = new Product();
//			p1.setName("Samsung S20 Ultra");
//			p1.setDescription("A samsung phone");
//			p1.setCategory(ProductCategory.MOBILE_PHONES);
//			Product p2 = new Product();
//			p2.setName("Iphone 15 Pro Max");
//			p2.setDescription("An iphone phone");
//			p2.setCategory(ProductCategory.MOBILE_PHONES);
//			Product p3 = new Product();
//			p3.setName("Realme 6 Pro");
//			p3.setDescription("A realme phone");
//			p3.setCategory(ProductCategory.MOBILE_PHONES);
//
//			Vendor v1 = new Vendor();
//			v1.setName("Ahmed");
//			v1.setPhoneNumber("01011");
//			Vendor v2 = new Vendor();
//			v2.setName("Sameh");
//			v2.setPhoneNumber("01012");
//
//			Inventory i1 = new Inventory();
//			i1.setVendor(v1);
//			i1.setLocation("Menouf");
//			Inventory i2 = new Inventory();
//			i2.setVendor(v2);
//			i2.setLocation("Shebeen");
//
//			i1.setVendor(v1);
//			i2.setVendor(v2);
//
//			InventoryItem ii1 = new InventoryItem();
//			ii1.setProduct(p1);
//			ii1.setInventory(i1);
//			ii1.setStockQuantity(5);
//			ii1.setPrice(50000.0);
//			InventoryItem ii2 = new InventoryItem();
//			ii2.setProduct(p2);
//			ii2.setInventory(i2);
//			ii2.setStockQuantity(3);
//			ii2.setPrice(100000.0);
//			InventoryItem ii3 = new InventoryItem();
//			ii3.setProduct(p3);
//			ii3.setInventory(i2);
//			ii3.setStockQuantity(10);
//			ii3.setPrice(10000.0);
//
//			customerRepository.save(c1);
//			customerRepository.save(c2);
//			customerRepository.save(c3);
//
//			productRepository.save(p1);
//			productRepository.save(p2);
//			productRepository.save(p3);
//
//			vendorRepository.save(v1);
//			vendorRepository.save(v2);
//
//			inventoryRepository.save(i1);
//			inventoryRepository.save(i2);
//
//			inventoryItemRepository.save(ii1);
//			inventoryItemRepository.save(ii2);
//			inventoryItemRepository.save(ii3);
		};
	}
}
