package pl.edu.agh.soa.lab3.mapper;

import pl.edu.agh.soa.lab3.entity.CourseEntity;
import pl.edu.agh.soa.model.Course;

public class CourseMapper {

    public static CourseEntity modelToEntity(Course course) {
        CourseEntity entity = new CourseEntity();
        entity.setName(course.getName());
        entity.setEcts(course.getEcts());
        entity.setId(course.getId());
        return entity;
    }

    public static Course modelToEntity(CourseEntity entity) {
        Course course = new Course();
        course.setId(entity.getId());
        course.setName(entity.getName());
        course.setEcts(entity.getEcts());
        return course;
    }
}
