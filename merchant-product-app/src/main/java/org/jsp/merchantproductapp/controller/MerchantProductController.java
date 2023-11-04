package org.jsp.merchantproductapp.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.merchantproductapp.MerchantProductConfig;
import org.jsp.merchantproductapp.dao.MerchantDao;
import org.jsp.merchantproductapp.dao.ProductDao;
import org.jsp.merchantproductapp.dto.Merchant;
import org.jsp.merchantproductapp.dto.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MerchantProductController {
	static Scanner s = new Scanner(System.in);
	static MerchantDao merchantDao;
	static ProductDao productDao;
	static {
		ApplicationContext context = new AnnotationConfigApplicationContext(MerchantProductConfig.class);
		merchantDao = context.getBean(MerchantDao.class);
		productDao = context.getBean(ProductDao.class);
	}

	public static void main(String[] args) {
		System.out.println("1.Save Merchant");
		System.out.println("2.Update Merchant");
		System.out.println("3.Add Product");
		System.out.println("4.Update Product");
		System.out.println("5.Verify Merchant By Phone and Password");
		System.out.println("6.Verify Merchant By Email and Password");
		System.out.println("7.Find Products by Brand");
		System.out.println("8.Find Products by Category");
		System.out.println("9.Find product by Merchant Id");
		System.out.println("10.Find Products by Merchant's Phone and Password");
		int choice = s.nextInt();
		switch (choice) {
		case 1: {
			saveMerchant();
			break;
		}
		case 2: {
			updateMerchant();
			break;
		}
		case 3: {
			addProduct();
			break;
		}
		case 4: {
			updateProduct();
			break;
		}
		case 5: {
			verifyMerchantByPhoneAndPassword();
			break;
		}
		case 6: {
			verifyMerchantByEmailAndPassword();
			;
			break;
		}
		case 7: {
			findProductsByBrand();
			break;
		}
		case 8: {
			findProductsByCategory();
			break;
		}
		case 9: {
			findProductsByMerchantId();
			break;
		}
		case 10: {
			findProductsByMerchantPhoneAndPassword();
			break;
		}
		default: {
			System.out.println("Invalid Choice!");
		}
		}
	}

	public static void saveMerchant() {
		System.out.println("Enter the name, phone, email and password");
		Merchant m = new Merchant();
		m.setName(s.next());
		m.setPhone(s.nextLong());
		m.setEmail(s.next());
		m.setPassword(s.next());
		m = merchantDao.saveMerchant(m);
		System.out.println("Merchant saved with id: " + m.getId());
	}

	public static void updateMerchant() {
		System.out.println("Enter Merchant Id to Update Merchant");
		int m_id = s.nextInt();
		System.out.println("Enter the name, phone, email and password");
		Merchant m = new Merchant();
		m.setId(m_id);
		m.setName(s.next());
		m.setPhone(s.nextLong());
		m.setEmail(s.next());
		m.setPassword(s.next());
		merchantDao.updateMerchant(m);
		System.out.println("Merchant updated successsfully!");
	}

	public static void addProduct() {
		System.out.println("Enter the Merchant Id to add the Product");
		int merchant_id = s.nextInt();
		System.out.println("Enter the Name, Brand, Category, Cost, Imageurl");
		Product p = new Product();
		p.setName(s.next());
		p.setBrand(s.next());
		p.setCategory(s.next());
		p.setCost(s.nextDouble());
		p.setImageurl(s.next());
		p = productDao.saveProduct(p, merchant_id);
		if (p != null) {
			System.out.println("Product added with id: " + p.getId());
		} else {
			System.err.println("You have entered an invalid Merchant Id");
		}
	}

	public static void updateProduct() {
		System.out.println("Enter the Merchant Id to update Product");
		int merchant_id = s.nextInt();
		System.out.println("Enter the Product Id, Name, Brand, Category, Cost, Imageurl to update");
		Product p = new Product();
		p.setId(s.nextInt());
		p.setName(s.next());
		p.setBrand(s.next());
		p.setCategory(s.next());
		p.setCost(s.nextDouble());
		p.setImageurl(s.next());
		productDao.updateProduct(p, merchant_id);
		System.out.println("Product Updated Successsfully!");
	}

	public static void findProductsByMerchantId() {
		System.out.println("Enter the Merchant Id to view Products");
		int merchant_id = s.nextInt();
		List<Product> products = productDao.findProductsByMerchantId(merchant_id);
		if (products.size() > 0) {
			for (Product p : products) {
				System.out.println("Product Id:" + p.getId());
				System.out.println("Product Name:" + p.getName());
				System.out.println("Brand:" + p.getBrand());
				System.out.println("Category:" + p.getCategory());
				System.out.println("Cost:" + p.getCost());
				System.out.println("Image: " + p.getImageurl());
				System.out.println("_____________________________");
			}
		} else {
			System.out.println("You have entered an Invalid Merchant id");
		}
	}

	public static void findProductsByBrand() {
		System.out.println("Enter the Brand to view Products");
		String brand = s.next();
		List<Product> products = productDao.findProductsByBrand(brand);
		if (products.size() > 0) {
			for (Product p : products) {
				System.out.println("Product Id:" + p.getId());
				System.out.println("Product Name:" + p.getName());
				System.out.println("Brand:" + p.getBrand());
				System.out.println("Category:" + p.getCategory());
				System.out.println("Cost:" + p.getCost());
				System.out.println("Image: " + p.getImageurl());
				System.out.println("_______________________");
			}
		} else {
			System.out.println("No Product present with the entered Brand");
		}
	}

	public static void findProductsByCategory() {
		System.out.println("Enter the Category to view Products");
		String category = s.next();
		List<Product> products = productDao.findProductsByCategory(category);
		if (products.size() > 0) {
			for (Product p : products) {
				System.out.println("Product Id:" + p.getId());
				System.out.println("Product Name:" + p.getName());
				System.out.println("Brand:" + p.getBrand());
				System.out.println("Category:" + p.getCategory());
				System.out.println("Cost:" + p.getCost());
				System.out.println("Image: " + p.getImageurl());
				System.out.println("_______________________");
			}
		} else {
			System.out.println("No Product present with the entered Category");
		}
	}

	public static void findProductsByMerchantPhoneAndPassword() {
		System.out.println("Enter the Merchant's Phone and Password to view Products");
		long phone = s.nextLong();
		String password = s.next();
		List<Product> products = productDao.findProductByMerchantPhonePassword(phone, password);
		if (products.size() > 0) {
			for (Product p : products) {
				System.out.println("Product Id:" + p.getId());
				System.out.println("Product Name:" + p.getName());
				System.out.println("Brand:" + p.getBrand());
				System.out.println("Category:" + p.getCategory());
				System.out.println("Cost:" + p.getCost());
				System.out.println("Image: " + p.getImageurl());
				System.out.println("_____________________________");
			}
		} else {
			System.out.println("No Products found with Merchant's Phone Number or Password");
		}
	}

	public static void verifyMerchantByPhoneAndPassword() {
		System.out.println("Enter Phone and Password to verify Merchant");
		Merchant m = merchantDao.verifyMerchantByPhonePassword(s.nextLong(), s.next());

		if (m != null) {
			System.out.println("Verification Successful!");
			System.out.println("User id: " + m.getId());
			System.out.println("User Name: " + m.getName());
			System.out.println("Phone: " + m.getPhone());
			System.out.println("Email: " + m.getEmail());
		} else {
			System.err.println("Invalid Phone Number and Password!");
		}
	}

	public static void verifyMerchantByEmailAndPassword() {
		System.out.println("Enter Email and Password to verify Merchant");
		Merchant m = merchantDao.verfifyMerchantByEmailPassword(s.next(), s.next());

		if (m != null) {
			System.out.println("Verification Successful!");
			System.out.println("User id: " + m.getId());
			System.out.println("User Name: " + m.getName());
			System.out.println("Phone: " + m.getPhone());
			System.out.println("Email: " + m.getEmail());
		} else {
			System.err.println("Invalid Email and Password!");
		}
	}
}
