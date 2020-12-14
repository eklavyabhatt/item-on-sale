package com.test.itemsonsale.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class HotdealsRepositoryServiceImpl implements HotdealsRepositoryService {

	private String getHotDealItems = "SELECT DEALS.ITEMID FROM HOTDEALS DEALS";

	@PersistenceContext
	private EntityManager hotDealsEntityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> hotDealItems() {

		return (List<Integer>) hotDealsEntityManager.createNativeQuery(getHotDealItems).getResultList();
	}

}
