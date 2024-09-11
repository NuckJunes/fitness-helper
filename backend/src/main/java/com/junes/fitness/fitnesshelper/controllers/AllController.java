package com.junes.fitness.fitnesshelper.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junes.fitness.fitnesshelper.dtos.All_Exercise_DTO;
import com.junes.fitness.fitnesshelper.dtos.All_Food_DTO;
import com.junes.fitness.fitnesshelper.services.AllService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/all")
public class AllController {

	private final AllService allService;
	
	@GetMapping("/exercises")
	public List<All_Exercise_DTO> getAllExercises() {
		return allService.getAllExercises();
	}
	
	@GetMapping("/food")
	public List<All_Food_DTO> getAllFood() {
		return allService.getAllFood();
	}
}
