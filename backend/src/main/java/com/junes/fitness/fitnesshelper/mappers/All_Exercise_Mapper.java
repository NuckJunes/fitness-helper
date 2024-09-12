package com.junes.fitness.fitnesshelper.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.junes.fitness.fitnesshelper.dtos.All_Exercise_DTO;
import com.junes.fitness.fitnesshelper.entities.All_Exercise;

@Mapper(componentModel = "spring", uses = {ExerciseMapper.class})
public interface All_Exercise_Mapper {

	List<All_Exercise_DTO> EntitiesToDTOs(List<All_Exercise> all);

	All_Exercise_DTO EntityToDTO(All_Exercise all_exercise);
	
	All_Exercise DTOToEntity(All_Exercise_DTO all_exercise_dto);
}
