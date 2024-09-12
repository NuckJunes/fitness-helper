package com.junes.fitness.fitnesshelper.mappers;

import org.mapstruct.Mapper;

import com.junes.fitness.fitnesshelper.dtos.ExerciseDTO;
import com.junes.fitness.fitnesshelper.entities.Exercise;

@Mapper(componentModel = "spring", uses = {All_Exercise_Mapper.class})
public interface ExerciseMapper {
	
	ExerciseDTO EntityToDTO(Exercise exercise);

	Exercise DTOToEntity(ExerciseDTO exerciseDTO);
}
