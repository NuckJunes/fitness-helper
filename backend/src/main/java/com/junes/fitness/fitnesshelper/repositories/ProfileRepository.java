package com.junes.fitness.fitnesshelper.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.junes.fitness.fitnesshelper.entities.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

	Profile findByUsername(String username);

	Profile findByPassword(String password);

}
