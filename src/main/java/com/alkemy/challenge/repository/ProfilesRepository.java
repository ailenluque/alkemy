package com.alkemy.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alkemy.challenge.model.Profiles;

public interface ProfilesRepository extends JpaRepository<Profiles, Integer> {

}
