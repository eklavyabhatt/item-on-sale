package com.test.itemsonsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.itemsonsale.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long>, OrdersRepositoryService {

}
