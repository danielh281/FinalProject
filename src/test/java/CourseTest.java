import org.dh.Assignment;
import org.dh.Course;
import org.dh.Department;
import org.dh.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;

public class CourseTest {
    @Test
    @DisplayName("isAssignmentWeightValid: Course{assignments=[Assignment={weight=50}, Assignment={weight=50}]} -> true")
    void isAssignmentWeightValidTest1() {
        Department department = new Department(null);
        Course course = new Course(
                null,
                -1,
                department,
                new ArrayList<>(),
                null
        );

        course.addAssignment(null, 50);
        course.addAssignment(null, 50);

        boolean expected = true;
        boolean result = course.isAssignmentWeightValid();

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("isAssignmentWeightValid: Course{assignments=[Assignment={weight=50}, Assignment={weight=25}]} -> false")
    void isAssignmentWeightValidTest2() {
        Department department = new Department(null);
        Course course = new Course(
                null,
                -1,
                department,
                new ArrayList<>(),
                null
        );

        course.addAssignment(null, 50);
        course.addAssignment(null, 25);

        boolean expected = false;
        boolean result = course.isAssignmentWeightValid();

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("registerStudent: Course{registeredStudents=[]}, Student{} -> true")
    void registerStudentTest1() {
        Department department = new Department(null);
        Student student = new Student(null, null, null, null);
        Course course = new Course(
                null,
                -1, department,
                new ArrayList<>(),
                new ArrayList<>()
        );

        boolean expected = true;
        boolean result = course.registerStudent(student);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("registerStudent: Course{registeredStudents=[Student{}]}, Student{} -> false")
    void registerStudentTest2() {
        Department department = new Department(null);
        Student student = new Student(null, null, null, null);
        Course course = new Course(
                null,
                -1, department,
                new ArrayList<>(),
                new ArrayList<>()
        );

        course.registerStudent(student);

        boolean expected = false;
        boolean result = course.registerStudent(student);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("addAssignment: Course{}, null, -1 -> true")
    void addAssignmentTest1() {
        Department department = new Department(null);
        Course course = new Course(
                null,
                -1, department,
                new ArrayList<>(),
                new ArrayList<>()
        );

        boolean expected = true;
        boolean result = course.addAssignment(null, -1);
    }
}
