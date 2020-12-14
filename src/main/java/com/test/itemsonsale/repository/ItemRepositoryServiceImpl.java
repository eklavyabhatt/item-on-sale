package com.test.itemsonsale.repository;

import java.util.LinkedHashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.test.itemsonsale.entity.Item;

public class ItemRepositoryServiceImpl implements ItemRepositoryService {

	private String getMyOrderedItems = "SELECT ITEMS.ITEMID FROM ITEM ITEMS WHERE ITEMS.ITEMID IN (:itemids) AND ITEMS.ISITEMONSALE = 'Y'";
	private String getItemsWithRatingsByUser = "SELECT ITEMS.* FROM ITEM ITEMS, RATING RATINGS WHERE ITEMS.ITEMID IN (:itemsOnSale) AND RATINGS.ITEMID = ITEMS.ITEMID AND RATINGS.USERID = :userid ORDER BY RATINGS.RATING DESC";
	private String getItemsWithRatings = "SELECT ITEMS.* FROM ITEM ITEMS, RATING RATINGS WHERE ITEMS.ITEMID IN (:itemsOnSale) AND RATINGS.ITEMID = ITEMS.ITEMID ORDER BY RATINGS.RATING DESC";

	@PersistenceContext
	private EntityManager itemsEntityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getItemsOnSale(LinkedHashSet<Integer> orderedWishedDealAsSet) {
		return (List<Integer>) itemsEntityManager.createNativeQuery(getMyOrderedItems)
				.setParameter("itemids", orderedWishedDealAsSet).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> getItemsOnSaleWithSortedUserRatings(List<Integer> itemsOnSale, String userid) {
		List<Item> itemsOnSaleWithSortedUserRatings = itemsEntityManager
				.createNativeQuery(getItemsWithRatingsByUser, Item.class).setParameter("itemsOnSale", itemsOnSale)
				.setParameter("userid", userid).getResultList();
		return itemsOnSaleWithSortedUserRatings;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> getItemsOnSaleWithSortedRatings(List<Integer> itemsOnSale) {
		List<Item> itemsOnSaleWithSortedRatings = itemsEntityManager.createNativeQuery(getItemsWithRatings, Item.class)
				.setParameter("itemsOnSale", itemsOnSale).getResultList();
		return itemsOnSaleWithSortedRatings;
	}

}
