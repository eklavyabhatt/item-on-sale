package com.test.itemsonsale.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class OrdersRepositoryServiceImpl implements OrdersRepositoryService {

	private String getMyOrderedItems = "SELECT ORD.ITEMID FROM ORDERS ORD WHERE ORD.USERID = :userid";

	@PersistenceContext
	private EntityManager ordersEntityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> myOrderedItems(String userid) {

		return (List<Integer>) ordersEntityManager.createNativeQuery(getMyOrderedItems).setParameter("userid", userid)
				.getResultList();

	}

}
