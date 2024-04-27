package com.example.giftshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.giftshop.model.GiftModel;

public interface GiftRepository extends JpaRepository<GiftModel, Integer> {
    Optional<GiftModel> findById(int id);
}
