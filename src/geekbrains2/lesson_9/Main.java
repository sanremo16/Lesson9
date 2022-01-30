package geekbrains2.lesson_9;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

    }

    private Set<Course> getDistinctCourses(List<Student> students) {
        Set<Course> courses = new HashSet();
        students.stream()
                .forEach(student -> courses.addAll(student.getAllCourses()));
        return courses;
    }

    private List<Student> getNerdStudents(List<Student> students) {
        return students.stream()
                .sorted((s1, s2) -> s1.getAllCourses().size() > s2.getAllCourses().size() ? -1 : 1)
                .limit(3)
                .collect(Collectors.toList());
    }

    private List<Student> getStudentsForCourse(List<Student> students, Course course) {
        return students.stream()
                .filter(student -> student.getAllCourses().contains(course))
                .collect(Collectors.toList());
    }
}
