package com.junes.fitness.fitnesshelper.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.junes.fitness.fitnesshelper.dtos.PantryRequestDTO;
import com.junes.fitness.fitnesshelper.dtos.PantryResponseDTO;
import com.junes.fitness.fitnesshelper.entities.Pantry;
import com.junes.fitness.fitnesshelper.entities.Profile;

@Mapper(componentModel = "spring", uses = {All_Food_Mapper.class})
public interface PantryMapper {

	List<PantryResponseDTO> entitiesToDTOs(List<Pantry> allByProfileID);

	Pantry DTOToEntity(PantryRequestDTO pantryRequestDTO);

	PantryResponseDTO EntityToDTO(Pantry pantryToAdd);

}
