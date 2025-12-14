package org.dh;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import util.Util;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
public class Course {
    private String courseId;
    private String courseName;
    @Setter private double credits;
    @Setter private Department department;
    @Setter private List<Assignment> assignments;
    @Setter private List<Student> registeredStudents;
    private List<Integer> finalScores;
    private static int nextId = 1;

    public Course(
            String courseName,
            double credits,
            Department department,
            List<Assignment> assignments,
            List<Student> registeredStudents) {

        this.courseId = String.format("C-%s-%02d", department.getDepartmentId(), nextId++);
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.assignments = assignments;
        this.registeredStudents = registeredStudents;
        this.finalScores = new ArrayList<>();
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

        finalScores.add(null);

        return true;
    }

    /**
     * Calculates the weighted average score of a student
     * @return
     */
    public int[] calcStudentsAverage() {
        int[] studentsAvg = new int[registeredStudents.size()];

        for (int i = 0; i < registeredStudents.size(); i++) {
            int total = 0;

            for (Assignment assignment : assignments) {
                int assignmentScore = assignment.getScores().get(i);
                total += (int) (assignmentScore * (assignment.getWeight() / 100));
            }

            studentsAvg[i] = total;
        }

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
        for (Student student : registeredStudents) {
            for (Assignment assignment : assignments) {
                assignment.generateRandomScore();
            }
        }

        for (int finalScore : calcStudentsAverage()) {
            this.finalScores.add(finalScore);
        }
    }

    /**
     * Displays the scores of each student of a course in a table.
     * The assignment averages and the student average
     * is shown.
     */
    public void displayScores() {
        System.out.printf("Course: %s(%s)\n", courseName, courseId);
        System.out.printf("%24s", "");

        for (int i = 0; i < assignments.size(); i++) {
            System.out.printf("%15s", assignments.get(i).getAssignmentName());
        }

        System.out.printf("%15s\n", "Final Score");

        for (int i = 0; i < registeredStudents.size(); i++) {
            System.out.printf("%22s", registeredStudents.get(i).getStudentName());

            for (int j = 0; j < assignments.size(); j++) {
                System.out.printf("%14d", assignments.get(j).getScores().get(i));
            }

            System.out.printf("%14d\n", finalScores.get(i));
        }
    }

    /**
     * Converts the course to a simplified string containing;
     * the course id, the course name, the course credits and
     * the department name.
     * @return The simplified string of the course
     */
    public String toSimplifiedString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", departmentName=" + department.getDepartmentName() +
                '}';
    }

    public void setCourseName(String courseName) {
        this.courseName = Util.toTitleCase(courseName);
    }

    @Override
    public String toString() {
        String str = "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", departmentName=" + department.getDepartmentName() +
                ", assignments=" + assignments +
                ", registeredStudents={";

        for (Student student : registeredStudents) {
            str += student.toSimplifiedString() + ",";
        }

        str += "}, isAssignmentWeightValid=" +
                isAssignmentWeightValid() + "}";

        return str;
    }
}
