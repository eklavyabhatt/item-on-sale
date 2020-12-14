package com.test.itemsonsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.itemsonsale.entity.Hotdeals;

@Repository
public interface HotdealsRepository extends JpaRepository<Hotdeals, Long>, HotdealsRepositoryService{

}
