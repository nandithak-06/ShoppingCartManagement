package com.myproject.demo.repository;
import com.myproject.demo.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartItem, Long> {}
