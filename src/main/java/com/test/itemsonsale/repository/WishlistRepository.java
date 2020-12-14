package com.test.itemsonsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.itemsonsale.entity.Wishlist;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long>, WishlistRepositoryService {

}
