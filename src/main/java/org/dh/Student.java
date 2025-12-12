package org.dh;

import java.util.List;

public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private List<Course> registeredCourses;
    private static int nextId = 1;

    public Student(String studentName, Gender gender, Address address, Department department, List<Course> registeredCourses) {
        this.studentId = String.format("S%06d", nextId++);
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = registeredCourses;
    }

    /**
     * Registers a course for a student, adds the course to the
     * student's registered courses list and adds the student to
     * the registered students list for the course.
     * @param course The course to register the student to.
     * @return True if the course was successfully registered. False if it is already registered on the student.
     */
    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            return false;
        }

        /*
        add assignment appending in Student Class 1.
         */
        registeredCourses.add(course);
        course.registerStudent(this);

        return true;
    }

    /**
     * Drops a course from the student's registered courses.
     * Removes that student from the registered students list
     * for the course.
     * @param course The course to drop.
     * @return True if the course was successfully dropped. False if the student is not registered to the course.
     */
    public boolean dropCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            return false;
        }

        registeredCourses.remove(course);
        course.getRegisteredStudents().remove(this);

        return true;
    }

    public enum Gender {
        MALE, FEMALE
    }
}
