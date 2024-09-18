package com.junes.fitness.fitnesshelper.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Pantry")
public class PantryController {

	private final PantryService pantryService;
	
}
