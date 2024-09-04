package com.junes.fitness.fitnesshelper.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class All_Food_DTO {

	private String name;
	
	private String description;
	
	private String type;
	
	private String imageURL;
}
