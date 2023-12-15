package com.api.mycarsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.mycarsystem.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
