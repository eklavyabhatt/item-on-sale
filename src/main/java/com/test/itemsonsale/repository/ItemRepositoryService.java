package com.test.itemsonsale.repository;

import java.util.LinkedHashSet;
import java.util.List;

import com.test.itemsonsale.entity.Item;

public interface ItemRepositoryService {

	List<Integer> getItemsOnSale (LinkedHashSet<Integer> orderedWishedDealAsSet);
	List<Item> getItemsOnSaleWithSortedUserRatings(List<Integer> itemsOnSale, String userid);
	List<Item> getItemsOnSaleWithSortedRatings(List<Integer> itemsOnSale);
}
