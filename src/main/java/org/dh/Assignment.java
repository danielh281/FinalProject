package org.dh;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Getter
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private List<Integer> scores;
    private static int nextId = 1;

    public Assignment(String assignmentName, double weight) {
        this.assignmentId = String.valueOf(nextId++);
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.scores = new ArrayList<>();
    }

    /**
     * Calculates the average score on the assignment.
     * @return The average score on the assignment
     */
    public double calcAssignmentAvg() {
        double total = 0;
        System.out.println(scores);
        for (Integer score : scores) {
            if (score == null) {
                continue;
            }

            total += score;
        }

        return total / scores.size();
    }

    /**
     * Generates random scores for all students in the assignment.
     */
    public void generateRandomScore() {
        Random rand = new Random();

        int randNum = rand.nextInt(0, 10);

        scores.add(switch(randNum) {
            case 0 -> rand.nextInt(0, 60);
            case 1, 2 -> rand.nextInt(60, 70);
            case 3, 4 -> rand.nextInt(70, 80);
            case 5, 6, 7, 8 -> rand.nextInt(80, 90);
            default -> rand.nextInt(90, 100);
        });
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight + "}";
    }
}
