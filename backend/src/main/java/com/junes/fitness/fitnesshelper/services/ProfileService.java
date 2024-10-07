package com.junes.fitness.fitnesshelper.services;

import com.junes.fitness.fitnesshelper.dtos.ProfileRequestDTO;
import com.junes.fitness.fitnesshelper.dtos.ProfileResponseDTO;

public interface ProfileService {

	ProfileResponseDTO login(ProfileRequestDTO profileRequestDTO);

}
