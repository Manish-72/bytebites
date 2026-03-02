package com.bytebites.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bytebites.model.PasswordResetToken;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Integer> {
	PasswordResetToken findByToken(String token);
}
