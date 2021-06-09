package pl.edu.agh.soa.lab1;

import javax.imageio.ImageIO;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

import java.util.Base64;
import java.util.List;

public class ClientExample {
    public static void main(String [] args) throws IOException {
        ManageStudents_Service service = new ManageStudents_Service();
        ManageStudents servicePort = service.getHelloStudentsPort();
        BindingProvider prov = (BindingProvider)servicePort;
        prov.getRequestContext().put(BindingProvider.USERNAME_PROPERTY,"ApplicationUser");
        prov.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "ApplicationUser");

        servicePort.hello();

        // add new students
        servicePort.addStudent("4444", "Emilia");
        servicePort.addStudent("5555", "Jan");
        servicePort.addStudent("7777", "Barbara");

        // show all students
        System.out.println("----------------------------------");
        System.out.println("Show all students");
        System.out.println("----------------------------------");
        List<Student> students = servicePort.getStudents();

        for(Student student : students) {
            System.out.println("Id: " + student.getId() + " Name: " + student.getName());
        }

        // add course to student
        System.out.println("----------------------------------");
        System.out.println("Add courses to students");
        System.out.println("----------------------------------");

        servicePort.addStudentClasses("4444", "SOA", 3);
        servicePort.addStudentClasses("4444", "IO", 3);
        servicePort.addStudentClasses("5555", "SOA", 3);

        for(Student student : students) {
            List<Course> courses = student.getCourses().getCourse();
            System.out.println("-> Id: " + student.getId() + " Name: " + student.getName() + "\n Courses: ");
            for(Course course : courses){
                System.out.println("* Name: " + course.name + " Ects: " + course.ects);
            }
        }

        // show all students with names beginning with "j"
        System.out.println("----------------------------------");
        System.out.println("Show all students with names \n beginning with letter 'j'");
        System.out.println("----------------------------------");
        List<Student> filterStudents =  servicePort.filterStudents("j");

        for(Student student : filterStudents) {
            System.out.println("Id: " + student.getId() + " Name: " + student.getName());
        }

        // Change student's name Emilia -> Zosia
        System.out.println("----------------------------------");
        System.out.println("Change student's name (Emilia -> Zosia)");
        System.out.println("----------------------------------");

        for(Student student : students) {
            if (student.getId().equals("4444")) {
                student.setName("Zosia");
            }
        }

        for(Student student : students) {
            System.out.println("Id: " + student.getId() + " Name: " + student.getName());
        }

        // Set new avatar
        System.out.println("----------------------------------");
        System.out.println("Set new avatar");
        System.out.println("----------------------------------");

        byte[] newAvatar = FileUtils.readFileToByteArray(new File("C:/Users/Paulina/Desktop/avatar.png"));
        byte[] image = {};
        for(Student student : students) {
            if (student.getId().equals("5555")) {
                student.setAvatar(Base64.getEncoder().encode(newAvatar));
                image = student.getAvatar();
            }
        }

        // Decode
        byte[] decodedImage = Base64.getDecoder().decode(image);

        // Save image
        ByteArrayInputStream inputStream = new ByteArrayInputStream(decodedImage);
        BufferedImage avatarImage = ImageIO.read(inputStream);
        ImageIO.write(avatarImage, "png", new File("C:/Users/Paulina/Desktop/newAvatar.png"));

    }

}
