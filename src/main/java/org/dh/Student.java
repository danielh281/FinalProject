package org.dh;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import util.Util;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
public class Student {
    @Setter private String studentId;
    private String studentName;
    @Setter private Gender gender;
    @Setter private Address address;
    @Setter private Department department;
    @Setter private List<Course> registeredCourses;
    private static int nextId = 1;

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = String.format("S%06d", nextId++);
        this.studentName = Util.toTitleCase(studentName);
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
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

    /**
     * Converts a student to a simple string containing;
     * their student id, their student name and their department name.
     * @return The student as a string with; studentId, studentName, departmentName
     */
    public String toSimplifiedString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", departmentName=" + department.getDepartmentName() +
                '}';
    }

    public void setStudentName(String studentName) {
        this.studentName = Util.toTitleCase(studentName);
    }

    @Override
    public String toString() {
        String str = "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender=" + gender +
                ", address=" + address +
                ", department=" + department +
                ", registeredCourses=";

        for (Course course : registeredCourses) {
            str += String.format(
                    "Course{courseId = %s, courseName = %s, departmentName = %s}",
                    course.getCourseId(),
                    course.getCourseName(),
                    course.getDepartment().getDepartmentName()
            );
        }

        return str;
    }

    public enum Gender {
        MALE, FEMALE
    }
}
