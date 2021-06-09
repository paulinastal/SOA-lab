package pl.edu.agh.soa.lab1;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ManageStudents {

    @WebMethod
    String hello();

    @WebMethod(operationName = "getStudents")
    @WebResult(name = "student")
    List<Student> getStudents();

    @WebMethod(operationName = "addStudent")
    @WebResult(name = "newStudent")
    String addStudent(
            @WebParam(name = "id") String id,
            @WebParam(name = "name") String name);

    @WebMethod(operationName = "addStudentClasses")
    @WebResult(name = "newClass")
    String addStudentClasses(
            @WebParam(name = "id") String id,
            @WebParam(name = "name") String courseName,
            @WebParam(name = "ects") Integer ects);

    @WebMethod(operationName = "addStudentAvatar")
    @WebResult(name = "newAvatar")
    String addStudentAvatar(
            @WebParam(name = "id") String id,
            @WebParam(name = "file") byte[] file);

    @WebMethod(operationName = "getStudentAvatar")
    @WebResult(name = "avatar")
    byte[] getStudentAvatar(@WebParam(name = "id") String id);

    @WebMethod(operationName = "deleteStudent")
    @WebResult(name = "deleteStudent")
    String deleteStudent(@WebParam(name = "id") String id);

    @WebMethod(operationName = "filterStudents")
    @WebResult(name = "students")
    List<Student> filterStudents(@WebParam(name = "letter") String letter);

    @WebMethod(operationName = "changeStudentName")
    @WebResult(name = "newName")
    String changeStudentName(@WebParam(name = "id") String id, @WebParam(name = "newName") String newName);

}
