package pl.edu.agh.soa.lab1;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private String id;
    private byte[] avatar;
    @XmlElementWrapper(name = "courses")
    @XmlElement(name = "course")
    private List<Course> courses = new ArrayList<>();

    public Student(String id, String name){
        this.id = id;
        this.name = name;
        this.avatar = new byte[]{};
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Course> getCourses() {
        return courses;
    }

    //public void setClasses(List<String> classes) {
     //   this.classes = classes;
    //}

    public void setCourses(Course c) {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(c);
    }

    public void setAvatar(byte[] newAvatar){
        this.avatar = newAvatar;
    }

    public byte[] getAvatar(){
        return this.avatar;
    }

}
