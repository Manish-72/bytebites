package com.bytebites.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bytebites.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
