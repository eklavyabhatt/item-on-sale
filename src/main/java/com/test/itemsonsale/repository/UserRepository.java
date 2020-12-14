package com.test.itemsonsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.itemsonsale.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
