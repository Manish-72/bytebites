package com.bytebites.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bytebites.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
