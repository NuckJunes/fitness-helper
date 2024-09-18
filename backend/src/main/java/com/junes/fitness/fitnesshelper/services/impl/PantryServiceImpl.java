package com.junes.fitness.fitnesshelper.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.junes.fitness.fitnesshelper.dtos.PantryResponseDTO;
import com.junes.fitness.fitnesshelper.mappers.PantryMapper;
import com.junes.fitness.fitnesshelper.repositories.PantryRepository;
import com.junes.fitness.fitnesshelper.services.PantryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PantryServiceImpl implements PantryService{
	
	private final PantryRepository pantryRepository;
	private final PantryMapper pantryMapper;

	@Override
	public List<PantryResponseDTO> getPantryItems(long profileID) {
		return pantryMapper.entitiesToDTOs(pantryRepository.findAllByProfileId(profileID));
	}

}
