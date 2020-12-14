package com.test.itemsonsale.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class WishlistRepositoryServiceImpl implements WishlistRepositoryService {

	private String getMyWishedItems = "SELECT WISH.ITEMID FROM WISHLIST WISH WHERE WISH.USERID = :userid";

	@PersistenceContext
	private EntityManager wishListEntityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> myWishedItems(String userid) {

		return (List<Integer>) wishListEntityManager.createNativeQuery(getMyWishedItems).setParameter("userid", userid)
				.getResultList();

	}

}
