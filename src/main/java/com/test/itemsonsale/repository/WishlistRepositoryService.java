package com.test.itemsonsale.repository;

import java.util.List;

public interface WishlistRepositoryService {

	List<Integer> myWishedItems(String userid);
}
