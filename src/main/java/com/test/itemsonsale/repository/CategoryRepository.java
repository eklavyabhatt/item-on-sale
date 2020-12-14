package com.test.itemsonsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.itemsonsale.entity.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
