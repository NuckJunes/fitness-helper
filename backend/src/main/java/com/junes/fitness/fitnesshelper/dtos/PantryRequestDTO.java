package com.junes.fitness.fitnesshelper.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PantryRequestDTO {

	private double amount;
	
	private String measurement;
	
	private All_Food_DTO All_Food;
}
