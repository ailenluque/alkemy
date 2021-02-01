package com.alkemy.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alkemy.challenge.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

}
