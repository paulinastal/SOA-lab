package pl.edu.agh.soa.lab2.service;

import pl.edu.agh.soa.lab2.exception.DataNotFound;
import pl.edu.agh.soa.lab2.database.DatabaseClass;
import pl.edu.agh.soa.model.Course;
import pl.edu.agh.soa.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CourseService {

    private Map<Integer, Student> students = DatabaseClass.getStudents();

    public List<Course> getAllCourses(int studentId) {
        Map<Integer, Course> courses = students.get(studentId).getCourses();
        if(courses.isEmpty()) {
            throw new DataNotFound("Courses not found");
        }
        return new ArrayList<Course>(courses.values());
    }

    public Course getCourse(int studentId, int courseId) {
        Map<Integer, Course> courses = students.get(studentId).getCourses();
        if(courses.get(courseId) == null) {
            throw new DataNotFound("Course with id " + courseId + " not found");
        }
        return courses.get(courseId);
    }

    public Course addCourse(int studentId, Course course) {
        Map<Integer, Course> courses = students.get(studentId).getCourses();
        course.setId(courses.size() + 1);
        courses.put(course.getId(), course);
        return course;
    }

    public Course updateCourse(int studentId, Course course) {
        Map<Integer, Course> courses = students.get(studentId).getCourses();
        if(course.getId() <= 0) {
            return null;
        }
        courses.put(course.getId(), course);
        return course;
    }

    public Course removeCourse(int studentId, int courseId) {
        Map<Integer, Course> courses = students.get(studentId).getCourses();
        if(courses.get(courseId) == null) {
            throw new DataNotFound("Course with id " + courseId + " not found");
        }
        return courses.remove(courseId);
    }
}
