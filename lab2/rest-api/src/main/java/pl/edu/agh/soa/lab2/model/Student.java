package pl.edu.agh.soa.lab2.model;

import pl.edu.agh.soa.lab2.model.Course;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement
public class Student {

    private int id;
    @NotNull @Size(min = 2, max = 50) private String name;
    @NotNull @Size(min = 2, max = 50) private String surname;

    private String avatar = "C:\\Users\\Paulina\\Desktop\\cat.jpg";
    private Map<Integer, Course> courses = new HashMap<>();

    public Student() {
    }

    public Student(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Student(int id, String name, String surname, String avatar) {
        this(id, name, surname);
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @XmlTransient
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @XmlTransient
    public Map<Integer, Course> getCourses() {
        return courses;
    }

    public void setCourses(Map<Integer, Course> courses) {
        this.courses = courses;
    }
}