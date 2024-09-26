package com.junes.fitness.fitnesshelper.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.junes.fitness.fitnesshelper.entities.Ingredient;

import jakarta.transaction.Transactional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

	@Modifying
	@Transactional
	@Query("DELETE FROM Ingredient i WHERE i.recipe IS NULL")
	Integer deleteByRecipeIsNull();
}
