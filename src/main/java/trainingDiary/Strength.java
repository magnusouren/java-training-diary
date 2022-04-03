package trainingDiary;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Strength implements Workout {

    private LocalDateTime date;
    private int duration;
    private char rating;
    private String content;
    private List<Exercise> exercises = new ArrayList<>();

    private WorkoutValidate validator = new WorkoutValidate();

    public Strength() {
    }

    /**
     * Konstrukøtr som innitialiserer en ny økt, med data tilknyttet økten.
     * 
     * @param date     Date til øktens dato
     * @param duration Int varighet på økten i minutter
     * @param rating   char terningkastverdi på økten
     * @param content  String kommentarer til økten
     */
    public Strength(LocalDateTime date, int duration, char rating, String content) {
        WorkoutValidate validator = new WorkoutValidate();

        validator.ValidateDate(date);
        validator.validateDuration(duration);
        validator.validateRating(rating);

        this.date = date;
        this.duration = duration;
        this.rating = rating;
        this.content = content;
    }

    /**
     * Legger til en øvelse i listen over øvelser til økten. Tar inn navn og antall
     * repetisjoner
     * 
     * @param name String navn på øvelse
     * @param rep  Int[] med de ulike tallverdiene over reppetisjoner
     */
    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    @Override
    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public char getRating() {
        return rating;
    }

    @Override
    public String getContent() {
        return content;
    }

    public void setDate(LocalDateTime date) {
        validator.ValidateDate(date);
        this.date = date;
    }

    public void setDuration(int duration) {
        validator.validateDuration(duration);
        this.duration = duration;
    }

    public void setRating(char rating) {
        validator.validateRating(rating);
        this.rating = rating;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Exercise> getExercises() {
        return new ArrayList<>(exercises);
    }

    @Override
    public String toString() {
        String res = "Strength: Date: " + date + ", " + duration + " min, | Rating: " + rating + " | Content: "
                + content + "\n";
        res += exercises.stream()
                .map(exercise -> exercise.toString())
                .collect(Collectors.joining("\n"));
        return res;
    }

}
