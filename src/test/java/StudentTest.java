import org.dh.Course;
import org.dh.Department;
import org.dh.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class StudentTest {
    @Test
    @DisplayName("registerCourse: Student{registeredCourses=[]}, " +
            "Course{courseName = 'Introduction to Programming'} -> true")
    void registerCourseTest1() {
        Department department = new Department("Computer Science");
        Student student = new Student(null, null, null, department);
        Course course = new Course("Introduction to Programming", 2, department, new ArrayList<>(), new ArrayList<>());

        boolean expected = true;
        boolean result = student.registerCourse(course);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("registerCourse: Student{registeredCourses=[Course{courseName='Introduction to Programming'}]}, " +
            "Course{courseName = 'Introduction to Programming'} -> false")
    void registerCourseTest2() {
        Department department = new Department("Computer Science");
        Student student = new Student(null, null, null, department);
        Course course = new Course("Introduction to Programming", 2, department, new ArrayList<>(), new ArrayList<>());

        student.registerCourse(course);

        boolean expected = false;
        boolean result = student.registerCourse(course);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("dropCourse: Student{registeredCourses=[Course{courseName='Introduction to Programming'}]}, " +
            "Course{courseName = 'Introduction to Programming'} -> true")
    void dropCourseTest1() {
        Department department = new Department("Computer Science");
        Student student = new Student(null, null, null, department);
        Course course = new Course("Introduction to Programming", 2, department, new ArrayList<>(), new ArrayList<>());

        student.registerCourse(course);

        boolean expected = true;
        boolean result = student.dropCourse(course);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("dropCourse: Student{registeredCourses=[]}, " +
            "Course{courseName = 'Introduction to Programming'} -> false")
    void dropCourseTest2() {
        Department department = new Department("Computer Science");
        Student student = new Student(null, null, null, department);
        Course course = new Course("Introduction to Programming", 2, department, new ArrayList<>(), new ArrayList<>());

        boolean expected = false;
        boolean result = student.dropCourse(course);

        Assertions.assertEquals(expected, result);
    }
}
