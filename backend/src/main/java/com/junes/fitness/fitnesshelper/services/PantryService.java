package com.junes.fitness.fitnesshelper.services;

import java.util.List;

import com.junes.fitness.fitnesshelper.dtos.PantryResponseDTO;

public interface PantryService {

	List<PantryResponseDTO> getPantryItems(long profileID);

}
