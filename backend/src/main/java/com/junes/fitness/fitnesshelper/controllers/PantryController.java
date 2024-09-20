package com.junes.fitness.fitnesshelper.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junes.fitness.fitnesshelper.dtos.PantryRequestDTO;
import com.junes.fitness.fitnesshelper.dtos.PantryResponseDTO;
import com.junes.fitness.fitnesshelper.services.PantryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pantry")
public class PantryController {

	private final PantryService pantryService;
	
	@GetMapping("/{profileID}")
	public List<PantryResponseDTO> getPantryItems(@PathVariable long profileID) {
		return pantryService.getPantryItems(profileID);
	}
	
	@PostMapping("/{profileID}")
	public PantryResponseDTO addPantryItem(@PathVariable long profileID, @RequestBody PantryRequestDTO pantryRequestDTO) {
		return pantryService.addPantryItem(profileID, pantryRequestDTO);
	}
	
	@PatchMapping("/{pantryID}")
	public PantryResponseDTO editPantryItem(@PathVariable long pantryID, @RequestBody PantryRequestDTO pantryRequestDTO) {
		return pantryService.editPantryItem(pantryID, pantryRequestDTO);
	}
	
	@DeleteMapping("/{pantryID}")
	public PantryResponseDTO deletePantryItem(@PathVariable long pantryID) {
		return pantryService.deletePantryItem(pantryID);
	}
}
