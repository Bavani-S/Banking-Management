package com.banking.management.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.management.customerservice.entity.UserDetail;

public interface UserRepository extends JpaRepository<UserDetail, Long> {

}
