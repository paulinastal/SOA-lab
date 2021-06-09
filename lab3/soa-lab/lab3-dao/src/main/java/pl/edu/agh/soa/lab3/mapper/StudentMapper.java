package pl.edu.agh.soa.lab3.mapper;

import pl.edu.agh.soa.lab3.entity.CourseEntity;
import pl.edu.agh.soa.lab3.entity.StudentEntity;
import pl.edu.agh.soa.model.Course;
import pl.edu.agh.soa.model.Student;

import java.util.*;

public class StudentMapper {

    public static StudentEntity modelToEntity(Student student){
        StudentEntity entity = new StudentEntity();
        Map<Integer, CourseEntity> courses = new HashMap<>();
        entity.setName(student.getName());
        entity.setSurname(student.getSurname());
        entity.setAvatar(student.getAvatar());
        entity.setId(student.getId());
        entity.setFaculty(FacultyMapper.modelToEntity(student.getFaculty()));
        for (Course course : student.getCourses().values()) {
            courses.put(course.getId(), CourseMapper.modelToEntity(course));
        }
        entity.setCourses(courses);
        return entity;
    }

    public static Student entityToModel(StudentEntity entity){
        Student student = new Student();
        Map<Integer, Course> courses = new HashMap<>();
        student.setName(entity.getName());
        student.setSurname(entity.getSurname());
        student.setId(entity.getId());
        student.setAvatar(entity.getAvatar());
        student.setFaculty(FacultyMapper.entityToModel(entity.getFaculty()));
        for (CourseEntity course: entity.getCourses().values()){
            courses.put(course.getId(), new Course(course.getId(), course.getName(), course.getEcts()));
        }
        student.setCourses(courses);
        return student;
    }
}
