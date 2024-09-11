package com.junes.fitness.fitnesshelper.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.junes.fitness.fitnesshelper.entities.All_Exercise;

@Repository
public interface All_ExerciseRepository extends JpaRepository<All_Exercise, Long> {

}
