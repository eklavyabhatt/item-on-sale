package com.test.itemsonsale.controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.itemsonsale.entity.Item;
import com.test.itemsonsale.entity.Recommendations;
import com.test.itemsonsale.repository.HotdealsRepositoryServiceImpl;
import com.test.itemsonsale.repository.ItemRepositoryServiceImpl;
import com.test.itemsonsale.repository.OrdersRepositoryServiceImpl;
import com.test.itemsonsale.repository.WishlistRepositoryServiceImpl;

@CrossOrigin(origins = "https://shopping.rbc.com")
@RestController
@RequestMapping("/items-on-sale")
public class ItemsOnSaleController {

	@Autowired
	private OrdersRepositoryServiceImpl orderRepositoryServiceImpl;

	@Autowired
	private WishlistRepositoryServiceImpl wishlistRepositoryServiceImpl;

	@Autowired
	private HotdealsRepositoryServiceImpl hotdealsRepositoryServiceImpl;

	@Autowired
	private ItemRepositoryServiceImpl itemRepositoryServiceImpl;
	
	
	@GetMapping(value = "/recommendations/{userid}")
	@PreAuthorize("isAuthenticated()")  
	public ResponseEntity<Recommendations> getRecommendations(@PathVariable(name = "userid") String userid) {
		Recommendations recommendations = new Recommendations();
		List<Item> recommendedItems = new ArrayList<Item>();
		List<Integer> orderdWishedDeal = new ArrayList<Integer>();

		if (userid.isEmpty() || null == userid) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		try {
			List<Integer> myOrderdItems = orderRepositoryServiceImpl.myOrderedItems(userid);
			orderdWishedDeal.addAll(myOrderdItems);

			List<Integer> myWishedItems = wishlistRepositoryServiceImpl.myWishedItems(userid);
			orderdWishedDeal.addAll(myWishedItems);

			List<Integer> hotDealItems = hotdealsRepositoryServiceImpl.hotDealItems();
			orderdWishedDeal.addAll(hotDealItems);

			LinkedHashSet<Integer> orderedWishedDealAsSet = new LinkedHashSet<Integer>(orderdWishedDeal);

			List<Integer> itemsOnSale = itemRepositoryServiceImpl.getItemsOnSale(orderedWishedDealAsSet);

			List<Item> itemsOnSaleWithSortedRatingsByUser = itemRepositoryServiceImpl
					.getItemsOnSaleWithSortedUserRatings(itemsOnSale, userid);

			recommendedItems.addAll(itemsOnSaleWithSortedRatingsByUser);

			List<Item> itemsOnSaleWithSortedRatings = itemRepositoryServiceImpl
					.getItemsOnSaleWithSortedRatings(itemsOnSale);

			recommendedItems.addAll(itemsOnSaleWithSortedRatings);

			LinkedHashSet<Item> recommendedItemsSet = new LinkedHashSet<Item>(recommendedItems);

			recommendations.setRecommendations(new ArrayList<Item>(recommendedItemsSet));
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return ResponseEntity.ok(recommendations);

	}

}
