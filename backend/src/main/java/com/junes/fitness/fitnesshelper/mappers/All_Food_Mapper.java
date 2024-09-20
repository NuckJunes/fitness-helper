package com.junes.fitness.fitnesshelper.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.junes.fitness.fitnesshelper.dtos.All_Food_DTO;
import com.junes.fitness.fitnesshelper.entities.All_Food;

@Mapper(componentModel = "spring")
public interface All_Food_Mapper {

	List<All_Food_DTO> EntitiesToDTOs(List<All_Food> list);

	All_Food DTOToEntity(All_Food_DTO all_food_dto);
}
