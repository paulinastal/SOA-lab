package pl.edu.agh.soa.lab2.service;

import pl.edu.agh.soa.lab2.database.DatabaseClass;
import pl.edu.agh.soa.lab2.exception.DataNotFound;
import pl.edu.agh.soa.lab3.dao.StudentDAO;
import pl.edu.agh.soa.model.Student;

import javax.ejb.EJB;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentService {

    @EJB
    StudentDAO myDAO;
    private Map<Integer, Student> students = DatabaseClass.getStudents();

    public StudentService() {}

    public List<Student> getAllStudents() {
        return new ArrayList<Student>(students.values());
    }

    public List<Student> getAllStudentsByName(String name) {
        List<Student> studentsByName = new ArrayList<>();
        for(Student student: students.values()) {
            if(student.getName().equals(name)) {
                studentsByName.add(student);
            }
        }
        if(studentsByName.isEmpty()) {
            throw new DataNotFound("No students found");
        }
        return studentsByName;
    }

    public List<Student> getAllStudentsPaginated(int start, int size) {
        ArrayList<Student> list = new ArrayList<Student>(students.values());
        if(start + size > list.size()) return new ArrayList<Student>();
        return list.subList(start, start + size);
    }

    public Student getStudent(int id) {
        Student student = students.get(id);
        if(student == null) {
            throw new DataNotFound("Student with id " + id + " not found");
        }
        return student;
    }

    public Student addStudent(Student student) {
        student.setId(students.size() + 1);
        students.put(student.getId(), student);
        return student;
    }

    public Student updateStudent(Student student) {
        if(student.getId() <= 0) {
            return null;
        }
        students.put(student.getId(), student);
        return student;
    }

    public Student removeStudent(int id) {
        return students.remove(id);
    }
}
