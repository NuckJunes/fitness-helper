package com.junes.fitness.fitnesshelper.dtos;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileResponseDTO {

	@NonNull
	private long id;
	
	private String username;
}
