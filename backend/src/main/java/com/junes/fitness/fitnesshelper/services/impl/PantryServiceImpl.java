package com.junes.fitness.fitnesshelper.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.junes.fitness.fitnesshelper.dtos.PantryRequestDTO;
import com.junes.fitness.fitnesshelper.dtos.PantryResponseDTO;
import com.junes.fitness.fitnesshelper.entities.All_Food;
import com.junes.fitness.fitnesshelper.entities.Pantry;
import com.junes.fitness.fitnesshelper.entities.Profile;
import com.junes.fitness.fitnesshelper.mappers.PantryMapper;
import com.junes.fitness.fitnesshelper.repositories.All_FoodRepository;
import com.junes.fitness.fitnesshelper.repositories.PantryRepository;
import com.junes.fitness.fitnesshelper.repositories.ProfileRepository;
import com.junes.fitness.fitnesshelper.services.PantryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PantryServiceImpl implements PantryService{
	
	private final PantryRepository pantryRepository;
	private final PantryMapper pantryMapper;
	private final All_FoodRepository all_FoodRepository;
	private final ProfileRepository profileRepository;

	@Override
	public List<PantryResponseDTO> getPantryItems(long profileID) {
		return pantryMapper.entitiesToDTOs(pantryRepository.findAllByProfileId(profileID));
	}

	@Override
	public PantryResponseDTO addPantryItem(long profileID, PantryRequestDTO pantryRequestDTO) {
		Pantry pantryToAdd = pantryMapper.DTOToEntity(pantryRequestDTO);
		
		//add pantry to profile
		Profile profileToModify = profileRepository.getById(profileID);
		List<Pantry> profilePantryItems = profileToModify.getPantry_items();
		profilePantryItems.add(pantryToAdd);
		profileToModify.setPantry_items(profilePantryItems);
		
		//connect the all food to the pantry item
		All_Food tmp = all_FoodRepository.findByName(pantryToAdd.getFood_item().getName());
		List<Pantry> tmpPantry = tmp.getPantry_items();
		tmpPantry.add(pantryToAdd);
		tmp.setPantry_items(tmpPantry);
		
		//connect the profile and all food in the pantry
		pantryToAdd.setFood_item(tmp);
		pantryToAdd.setProfile(profileToModify);
		
		pantryRepository.saveAndFlush(pantryToAdd);
		profileRepository.saveAndFlush(profileToModify);
		all_FoodRepository.saveAndFlush(tmp);
		return pantryMapper.EntityToDTO(pantryToAdd);
	}

	@Override
	public PantryResponseDTO editPantryItem(long pantryID, PantryRequestDTO pantryRequestDTO) {
		
		//Check if pantry item exists
		
		Pantry newPantryDetails = pantryMapper.DTOToEntity(pantryRequestDTO);
		Pantry oldPantryDetails = pantryRepository.getById(pantryID);
		oldPantryDetails.setAmount(newPantryDetails.getAmount());
		oldPantryDetails.setMeasurement(newPantryDetails.getMeasurement());
		return pantryMapper.EntityToDTO(pantryRepository.saveAndFlush(oldPantryDetails));
	}

	@Override
	public PantryResponseDTO deletePantryItem(long pantryID) {
		
		//Check if pantry item exists
		
		Pantry pantryDeleted = pantryRepository.getById(pantryID);
		pantryRepository.deleteById(pantryID);
		return pantryMapper.EntityToDTO(pantryDeleted);
	}

}
