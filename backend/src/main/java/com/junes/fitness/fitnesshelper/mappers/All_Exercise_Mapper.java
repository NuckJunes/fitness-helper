package com.junes.fitness.fitnesshelper.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.junes.fitness.fitnesshelper.dtos.All_Exercise_DTO;
import com.junes.fitness.fitnesshelper.entities.All_Exercise;

@Mapper(componentModel = "spring")
public interface All_Exercise_Mapper {

	List<All_Exercise_DTO> EntitiesToDTOs(List<All_Exercise> all);

}
