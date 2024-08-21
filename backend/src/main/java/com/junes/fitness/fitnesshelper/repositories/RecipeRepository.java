package com.junes.fitness.fitnesshelper.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.junes.fitness.fitnesshelper.entities.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long>{

}
