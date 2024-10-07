package com.junes.fitness.fitnesshelper.mappers;

import org.mapstruct.Mapper;

import com.junes.fitness.fitnesshelper.dtos.ProfileRequestDTO;
import com.junes.fitness.fitnesshelper.dtos.ProfileResponseDTO;
import com.junes.fitness.fitnesshelper.entities.Profile;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

	Profile DTOToEntity(ProfileRequestDTO profileRequestDTO);

	ProfileResponseDTO entityToDTO(Profile byUsername);

}
