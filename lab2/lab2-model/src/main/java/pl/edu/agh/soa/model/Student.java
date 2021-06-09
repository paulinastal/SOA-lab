package pl.edu.agh.soa.model;

import java.util.HashMap;
import java.util.Map;

public class Student {

    private int id;
    private String name;
    private String surname;

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Map<Integer, Course> getCourses() {
        return courses;
    }

    public void setCourses(Map<Integer, Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        String result = "id: " + this.getId() + " name: " + this.getName() + " surname: " + this.getSurname();
        return result;
    }
}
