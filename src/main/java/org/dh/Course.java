package org.dh;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private List<Assignment> assignments;
    private List<Student> registeredStudents;
    private static int nextId = 1;

    public Course(
            String courseName,
            double credits,
            Department department,
            List<Assignment> assignments,
            List<Student> registeredStudents) {

        this.courseId = String.format("C-%s-%02d", department.getDepartmentId(), nextId++);
        this.courseName = courseName;
        this.credits = credits;
        this.department = department;
        this.assignments = assignments;
        this.registeredStudents = registeredStudents;
    }

    /**
     * Checks if all the assignments' weight add up to 100%.
     * @return True if they add up to 100%. False if they do not add up to 100%
     */
    public boolean isAssignmentWeightValid() {
        double totalWeight = 0;

        for (Assignment assignment : assignments) {
            totalWeight += assignment.getWeight();
        }

        return totalWeight == 100;
    }

    /**
     * Adds a student to the registered students list of
     * the course. Adds a null element to the scores of each
     * assignment and adds a null element to the final scores
     * of the course.
     * @param student The student to register
     * @return True if the student was successfully registered. False if the student is already registered
     */
    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) {
            return false;
        }

        registeredStudents.add(student);

        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }

        return true;
    }

    public int[] calcStudentsAverage() {
        int[] studentsAvg = new int[registeredStudents.size()];

        return studentsAvg;
    }

    /**
     * Adds an assignment to the course
     * @param assignmentName The name of the assignment
     * @param weight The weight of the assignment
     * @return Always returns true
     */
    public boolean addAssignment(String assignmentName, double weight) {
        assignments.add(new Assignment(assignmentName, weight));
        return true;
    }

    /**
     * Generates random scores for all the assignments and for
     * all the students and calculates the final score for each
     * student.
     */
    public void generateScores() {

    }

    /**
     * Displays the scores of a course in a table.
     * The assignment averages and the student average
     * is shown.
     */
    public void displayScores() {

    }
}
