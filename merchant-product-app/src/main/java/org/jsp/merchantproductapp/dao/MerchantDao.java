package org.jsp.merchantproductapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jsp.merchantproductapp.dto.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantDao {
	@Autowired
	private EntityManager manager;

	public Merchant saveMerchant(Merchant merchant) {
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(merchant);
		transaction.begin();
		transaction.commit();
		return merchant;
	}

	public Merchant updateMerchant(Merchant merchant) {
		EntityTransaction transaction = manager.getTransaction();
		manager.merge(merchant);
		transaction.begin();
		transaction.commit();
		return merchant;
	}

	public Merchant verifyMerchantByPhonePassword(long phone, String password) {
		String qry = "select m from Merchant m where m.phone=?1 and m.password=?2";
		Query q = manager.createQuery(qry);
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			return (Merchant) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Merchant verfifyMerchantByEmailPassword(String email, String password) {
		String qry = "select m from Merchant m where m.email=?1 and m.password=?2";
		Query q = manager.createQuery(qry);
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
			return (Merchant) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
