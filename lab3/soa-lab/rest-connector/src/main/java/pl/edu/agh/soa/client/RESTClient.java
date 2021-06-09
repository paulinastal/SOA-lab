package pl.edu.agh.soa.client;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import pl.edu.agh.soa.client.model.Student;
import pl.edu.agh.soa.client.model.StudentMessageWriter;
import pl.edu.agh.soa.lab2.model.StudentProto;

import javax.swing.*;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.*;
import java.awt.*;
import java.util.List;

public class RESTClient {

    private ResteasyClient resteasyClient;
    private String username = "";
    private String password = "";
    private static String token = null;

    public RESTClient() {
        this.resteasyClient = new ResteasyClientBuilder().build();
    }

    public RESTClient(String username, String password) {
        this.resteasyClient = new ResteasyClientBuilder().build();
        this.username = username;
        this.password = password;
        authorize();
    }

    public void endSession() {
        if(!resteasyClient.isClosed())
            resteasyClient.close();
    }

    public void authorize() {
        ResteasyWebTarget target = resteasyClient.target("http://localhost:8080/rest-api/api/auth/login");
        Form form = new Form();
        form.param("login", this.username);
        form.param("password", this.password);
        Response response = target.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED));
        MultivaluedMap<String, String> headers = response.getStringHeaders();
        token = headers.getFirst("authorization");
        //System.out.println(token);
    }

    ///------- get all students -------///
    private List<Student> getAllStudents(MultivaluedMap<String, Object> parameters) {
        List<Student> result = null;
        ResteasyWebTarget target = resteasyClient.target("http://localhost:8080/rest-api/api/students");

        Response response = target.request().get();
        int responseStatus = response.getStatus();

        if(responseStatus == 200) {
            result = response.readEntity(new GenericType<List<Student>>() { });
        }
        response.close();
        //System.out.println(responseStatus);
        return result;
    }

    ///------- get student by id -------///
    private Student getStudentById(int id){
        Student result = null;
        ResteasyWebTarget target = resteasyClient.target("http://localhost:8080/rest-api/api/students/" + id);

        Response response = target.request().get();
        int responseStatus = response.getStatus();
        if(responseStatus == 200) {
            result = response.readEntity(Student.class);
        }
        response.close();
        //System.out.println(responseStatus);
        return result;
    }

    ///------- add new student -------///
    private void addStudent(Student student){
        ResteasyWebTarget target = resteasyClient.target("http://localhost:8080/rest-api/api/students/");

        if(token == null) {
            authorize();
        }
        Response response = target.request().header("Authorization", token).post(Entity.entity(student, MediaType.APPLICATION_JSON_TYPE));
        //System.out.println(response.getStatus());
        response.close();
    }

    ///------- delete student -------///
    private void removeStudent(int id){
        ResteasyWebTarget target = resteasyClient.target("http://localhost:8080/rest-api/api/students/" + id);


        Response response = target.request().delete();
        //System.out.println(response.getStatus());
        response.close();
    }

    ///------- get student (protobuf) -------///
    private StudentProto.Student getStudentByIdProto(int id){
        StudentProto.Student result = null;
        ResteasyWebTarget target = resteasyClient.target("http://localhost:8080/rest-api/api/students/" + id + "/protobuf").register(StudentMessageWriter.class);

        Response response = target.request().get();
        int responseStatus = response.getStatus();
        if(responseStatus == 200) {
            result = response.readEntity(StudentProto.Student.class);
        }
        response.close();
        //System.out.println(responseStatus);
        return result;
    }

    ///------- display student's avatar -------///
    private void displayAvatar(int id){
        byte[] result = null;
        ResteasyWebTarget target = resteasyClient.target("http://localhost:8080/rest-api/api/students/" + id + "/avatar");

        Response response = target.request().get();
        int responseStatus = response.getStatus();
        if(responseStatus == 200) {
            result = response.readEntity(byte[].class);
        }
        response.close();
        //System.out.println(responseStatus);
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(500, 640);
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(result));
        panel.add(label);
        jFrame.getContentPane()
                .add(panel);
        jFrame.pack();
        jFrame.setVisible(true);
    }


    public static void main(String[] args) {
        RESTClient consumer = new RESTClient("user","user");

        //get all students
        System.out.println("-------------------------------------------------");
        System.out.println(">> Get all students");
        System.out.println("-------------------------------------------------");
        for(Student student : consumer.getAllStudents(null)){
            System.out.println(student.toString());
        }

        //get student with id 2
        System.out.println("-------------------------------------------------");
        System.out.println(">> Student with id 2");
        System.out.println("-------------------------------------------------");
        System.out.println(consumer.getStudentById(2).toString());

        //add new student
        System.out.println("-------------------------------------------------");
        System.out.println(">> Add new student with id 3");
        System.out.println("-------------------------------------------------");
        Student newStudent = new Student(3,"Agnieszka", "Nowak");
        consumer.addStudent(newStudent);

        for(Student student : consumer.getAllStudents(null)){
            System.out.println(student.toString());
        }

        //delete student
        System.out.println("-------------------------------------------------");
        System.out.println(">> Delete student with id 3");
        System.out.println("-------------------------------------------------");
        consumer.removeStudent(3);

        for(Student student : consumer.getAllStudents(null)){
            System.out.println(student.toString());
        }

        //get student with id 2 (protobuf)
        System.out.println("-------------------------------------------------");
        System.out.println(">> Student with id 2 (protobuf)");
        System.out.println("-------------------------------------------------");
        System.out.println(consumer.getStudentByIdProto(2).toString());

        //display student's avatar with id 2
        System.out.println("-------------------------------------------------");
        System.out.println(">> Student's avatar with id 2");
        System.out.println("-------------------------------------------------");
        consumer.displayAvatar(2);

        consumer.endSession();
    }

}
