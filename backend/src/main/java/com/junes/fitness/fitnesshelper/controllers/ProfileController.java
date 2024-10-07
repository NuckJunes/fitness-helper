package com.junes.fitness.fitnesshelper.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junes.fitness.fitnesshelper.dtos.ProfileRequestDTO;
import com.junes.fitness.fitnesshelper.dtos.ProfileResponseDTO;
import com.junes.fitness.fitnesshelper.services.ProfileService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class ProfileController {
	
	private final ProfileService profileService;
	
	@PostMapping("")
	public ProfileResponseDTO login(@RequestBody ProfileRequestDTO profileRequestDTO) {
		return profileService.login(profileRequestDTO);
	}
}
