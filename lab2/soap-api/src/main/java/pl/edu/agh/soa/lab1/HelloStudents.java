package pl.edu.agh.soa.lab1;

import org.jboss.annotation.security.SecurityDomain;
import org.jboss.ws.api.annotation.WebContext;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@Stateless
@WebService(endpointInterface = "pl.edu.agh.soa.lab1.ManageStudents",
            targetNamespace = "https://www.soa.lab.agh.edu.pl/lab1",
            serviceName = "ManageStudents")
@SecurityDomain("other")
@WebContext(contextRoot="/lab1-soap",urlPattern="/*", authMethod="BASIC", transportGuarantee="NONE")

public class HelloStudents implements ManageStudents{
    private List<Student> students;

    public HelloStudents() {};


    @Override
    public String hello() {
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add(new Student("1111", "Anna"));
        students.add(new Student("3333", "Jessie"));
        students.add(new Student("2222", "Elsa"));
        return "Test";
    }

    @Override
    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String addStudent(String id, String name){

        if (students == null) {
            students = new ArrayList<>();
        }

        if (id.trim().isEmpty() || name.trim().isEmpty()){
            return "Please enter both id and name";

        } else if (students.stream().map(Student::getId).anyMatch(id::equals)){
            return "This student already exists!";

        } else {
            students.add(new Student(id, name));
            return "Student "+ name + " was added!";
        }
    }

    @Override
    public String addStudentClasses(String id, String courseName, Integer ects){
        for (Student student : students) {
            if(student.getId().equals(id)){
                student.setCourses(new Course(courseName, ects));
                return "Course " + courseName + " was added";
                }
            }
        return id + " doesn't exist";
    }

    @Override
    public String addStudentAvatar(String id, byte[] file){
        for (Student student : students) {
            if(student.getId().equals(id)){
                student.setAvatar(file);
                return "Avatar was added!";
            }
        }
        return id + " doesn't exist";
    }

    @Override
    public byte[] getStudentAvatar(String id){
        byte [] empty = {};
        for (Student student : students) {
            if(student.getId().equals(id)){
                return student.getAvatar();
            }
        }
        return empty;
    }

    @Override
    public String deleteStudent(String id){
        int i = 0;
        for (Student student : students) {
            if(student.getId().equals(id)){
                students.remove(i);
                return "Student was removed!";
            }
            i+=1;
        }
        return "Student doesn't exists!";
    }

    @Override
    public List<Student> filterStudents(String letter) {
        List<Student> filterListStudents = new ArrayList<>();
        for (Student student : students) {
            if(String.valueOf(student.getName().charAt(0)).equalsIgnoreCase(letter)){
                filterListStudents.add(student);
            }
        }
        return filterListStudents;
    }

    @Override
    public String changeStudentName(String id, String newName) {
        for (Student student : students) {
            if(student.getId().equals(id)){
                student.setName(newName);
                return "Success!";
            }
        }
        return id + " doesn't exist";
    }
}
