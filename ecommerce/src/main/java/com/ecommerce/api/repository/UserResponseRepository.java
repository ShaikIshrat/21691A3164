package com.ecommerce.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.api.model.UserResponse;

public interface UserResponseRepository extends JpaRepository<UserResponse, String> {

}
