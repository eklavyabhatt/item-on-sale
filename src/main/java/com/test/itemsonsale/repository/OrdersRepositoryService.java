package com.test.itemsonsale.repository;

import java.util.List;


public interface OrdersRepositoryService {

	List<Integer> myOrderedItems(String userid);
	
}
