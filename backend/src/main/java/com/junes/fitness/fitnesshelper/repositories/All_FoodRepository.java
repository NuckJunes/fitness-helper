package com.junes.fitness.fitnesshelper.repositories;

import org.springframework.stereotype.Repository;

import com.junes.fitness.fitnesshelper.entities.All_Food;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface All_FoodRepository extends JpaRepository<All_Food, Long> {

}
