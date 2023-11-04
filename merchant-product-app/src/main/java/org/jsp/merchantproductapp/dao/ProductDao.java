package org.jsp.merchantproductapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.jsp.merchantproductapp.dto.Merchant;
import org.jsp.merchantproductapp.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
	@Autowired
	private EntityManager manager;

	public Product saveProduct(Product product, int merchant_id) {
		EntityTransaction transaction = manager.getTransaction();
		Merchant m = manager.find(Merchant.class, merchant_id);
		if (m != null) {
			m.getProducts().add(product);
			product.setMerchant(m);
			manager.persist(product);
			transaction.begin();
			transaction.commit();
			return product;
		}
		return null;
	}

	public Product updateProduct(Product product, int merchant_id) {
		Merchant m = manager.find(Merchant.class, merchant_id);
		if (m != null) {
			product.setMerchant(m);
			EntityTransaction transaction = manager.getTransaction();
			manager.merge(product);
			transaction.begin();
			transaction.commit();
			return product;
		}
		return null;
	}

	public List<Product> findProductsByBrand(String brand) {
		String qry = "select p from Product p where p.brand=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, brand);
		return q.getResultList();
	}

	public List<Product> findProductsByCategory(String category) {
		String qry = "select p from Product p where p.category=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, category);
		return q.getResultList();
	}

	public List<Product> findProductsByMerchantId(int m_id) {
		String qry = "select p from Product p where p.merchant.id=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, m_id);
		return q.getResultList();
	}

	public List<Product> findProductByMerchantPhonePassword(long phone, String password) {
		String qry = "select p from Product p where p.merchant.phone=?1 and p.merchant.password=?2";
		Query q = manager.createQuery(qry);
		q.setParameter(1, phone);
		q.setParameter(2, password);
		return q.getResultList();
	}

}
