package com.test.itemsonsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.itemsonsale.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>, ItemRepositoryService{

}
