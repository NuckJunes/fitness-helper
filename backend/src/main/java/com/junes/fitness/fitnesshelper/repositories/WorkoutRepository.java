package com.junes.fitness.fitnesshelper.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.junes.fitness.fitnesshelper.entities.Workout;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {

	List<Workout> findAllByProfileId(long profileID);

}
