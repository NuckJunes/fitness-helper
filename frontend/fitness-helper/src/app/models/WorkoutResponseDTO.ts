import ExerciseDTO from "./ExerciseDTO"

export default interface WorkoutResponseDTO {
    id: number,
    name: String,
    muscle: String,
    time_minutes: number,
    imageURL: String,
    exercises: ExerciseDTO[]
}