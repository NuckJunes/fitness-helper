package com.junes.fitness.fitnesshelper.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.junes.fitness.fitnesshelper.entities.Pantry;

@Repository
public interface PantryRepository extends JpaRepository<Pantry, Long>{

}
