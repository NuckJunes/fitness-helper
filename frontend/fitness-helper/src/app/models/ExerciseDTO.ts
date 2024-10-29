import All_Exercise_DTO from "./All_Exercise_DTO";

export default interface ExerciseDTO {
    id: number,
    weight: number,
    time_seconds: number,
    reps: number,
    imageURL: String,
    exercise: All_Exercise_DTO
}