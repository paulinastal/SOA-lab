package pl.edu.agh.soa.lab3.dao;

import pl.edu.agh.soa.lab3.entity.CourseEntity;
import pl.edu.agh.soa.lab3.entity.FacultyEntity;
import pl.edu.agh.soa.lab3.entity.StudentEntity;
import pl.edu.agh.soa.lab3.mapper.CourseMapper;
import pl.edu.agh.soa.lab3.mapper.FacultyMapper;
import pl.edu.agh.soa.lab3.mapper.StudentMapper;
import pl.edu.agh.soa.model.Course;
import pl.edu.agh.soa.model.Dean;
import pl.edu.agh.soa.model.Faculty;
import pl.edu.agh.soa.model.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.*;
import java.util.stream.Collectors;

@Stateless
public class StudentDAO {

    @PersistenceContext(unitName = "students")
    EntityManager em;

    public List<Student> getAllStudents() {
        return getAllStudents(Collections.emptyMap());
    }

    public List<Student> getAllStudents(Map<String, String> params) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<StudentEntity> criteriaQuery = builder.createQuery(StudentEntity.class);
        Root<StudentEntity> root = criteriaQuery.from(StudentEntity.class);
        if(params.isEmpty()) {
            criteriaQuery.select(root);
        }
        else {
            List<Predicate> predicates = new ArrayList<>();
            for(Map.Entry<String, String> param : params.entrySet()){
                if (param.getKey().equals("name")){
                    predicates.add(builder.equal(root.get(param.getKey()), param.getValue()));
                }
                else{
                    predicates.add(builder.equal(root.get(param.getKey()), param.getValue()));
                }
            }
            criteriaQuery.select(root).where(predicates.toArray(new Predicate[]{}));
        }
        TypedQuery<StudentEntity> query = em.createQuery(criteriaQuery);
        List<StudentEntity> resultList = query.getResultList();
        if(resultList == null)
            return null;
        return resultList.stream().map(StudentMapper::entityToModel).collect(Collectors.toList());
    }

    public void addStudent(Student student){
        StudentEntity studentEntity = StudentMapper.modelToEntity(student);

        if (student.getFaculty() != null){
            FacultyEntity facultyEntity = FacultyMapper.modelToEntity(student.getFaculty());
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<FacultyEntity> criteriaQuery = builder.createQuery(FacultyEntity.class);
            Root<FacultyEntity> root = criteriaQuery.from(FacultyEntity.class);
            criteriaQuery.select(root);
            TypedQuery<FacultyEntity> query = em.createQuery(criteriaQuery);
            List<FacultyEntity> resultList = query.getResultList();
            for (FacultyEntity result : resultList){
                if (result.getName().equals(student.getFaculty().getName())){
                    facultyEntity = result;
                }
            }
            studentEntity.setFaculty(facultyEntity);
        }
        em.merge(studentEntity);
    }

    public Student getStudentById(int id) {
        return StudentMapper.entityToModel(em.find(StudentEntity.class, id));
    }

    public void removeStudentById(int id) {
        StudentEntity s = em.find(StudentEntity.class, id);
        em.remove(s);
    }

    public Student updateStudent(int id, Student student) {
        StudentEntity studentEntity = StudentMapper.modelToEntity(student);
        studentEntity.setCourses(new HashMap<>());
        for(Course course : student.getCourses().values()){
            CourseEntity courseEntity = CourseMapper.modelToEntity(course);
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<CourseEntity> criteriaQuery = builder.createQuery(CourseEntity.class);
            Root<CourseEntity> root = criteriaQuery.from(CourseEntity.class);
            criteriaQuery.select(root);
            TypedQuery<CourseEntity> query = em.createQuery(criteriaQuery);
            List<CourseEntity> resultList = query.getResultList();
            for (CourseEntity result : resultList){
                if (result.getName().equals(course)){
                    courseEntity = result;
                }
            }
            studentEntity.getCourses().put(courseEntity.getId(), courseEntity);
        }
        studentEntity.setId(id);
        em.merge(studentEntity);
        return student;
    }

    public void generateData() {
        HashMap<Integer, Course> courses = new HashMap();
        Dean dean = new Dean("inż.", "Jan Kowalski");
        Faculty faculty = new Faculty("EAIiIB", dean);

        courses.put(1, new Course(1, "IO", 3));
        courses.put(2, new Course(2, "POC", 3));

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Anna", "Kowalska", courses, faculty));
        students.add(new Student(2, "Jan", "Nowak", courses, faculty));
        students.add(new Student(3, "Adam", "Kowalski", courses, faculty));

        for(Student student : students) {
            addStudent(student);
        }
    }

}
