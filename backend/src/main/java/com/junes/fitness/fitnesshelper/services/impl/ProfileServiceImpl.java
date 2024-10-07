package com.junes.fitness.fitnesshelper.services.impl;

import org.springframework.stereotype.Service;

import com.junes.fitness.fitnesshelper.dtos.ProfileRequestDTO;
import com.junes.fitness.fitnesshelper.dtos.ProfileResponseDTO;
import com.junes.fitness.fitnesshelper.entities.Profile;
import com.junes.fitness.fitnesshelper.mappers.ProfileMapper;
import com.junes.fitness.fitnesshelper.repositories.ProfileRepository;
import com.junes.fitness.fitnesshelper.services.ProfileService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
	
	private final ProfileMapper profileMapper;
	private final ProfileRepository profileRepository;
	
	@Override
	public ProfileResponseDTO login(ProfileRequestDTO profileRequestDTO) {
		Profile profileToLogin = profileMapper.DTOToEntity(profileRequestDTO);
		String username = profileToLogin.getUsername();
		String password = profileToLogin.getPassword();
		
		//check if request is valid
		if(username == null || password == null) {
			//throw exception
		}
		
		//check if profile exists in system
		if(profileRepository.findByUsername(username) == null || profileRepository.findByPassword(password) == null) {
			//throw exception
		}
		
		//return if no errors thrown
		return profileMapper.entityToDTO(profileRepository.findByUsername(username));
	}

}
