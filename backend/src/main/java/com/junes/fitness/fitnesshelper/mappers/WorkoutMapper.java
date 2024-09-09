package com.junes.fitness.fitnesshelper.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.junes.fitness.fitnesshelper.dtos.WorkoutResponseDTO;
import com.junes.fitness.fitnesshelper.entities.Workout;

@Mapper(componentModel = "spring", uses = {ExerciseMapper.class})
public interface WorkoutMapper {

	List<WorkoutResponseDTO> entitiesToDTOs(List<Workout> workouts);

}
