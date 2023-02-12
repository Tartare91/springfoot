package com.maigrot.springfoot.repository;

import com.maigrot.springfoot.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {



}