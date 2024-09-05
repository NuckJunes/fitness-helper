package com.junes.fitness.fitnesshelper.mappers;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ExerciseMapper.class})
public interface WorkoutMapper {

}
