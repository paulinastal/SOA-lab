package pl.edu.agh.soa.lab2.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Course {

    private int id;
    private String name;
    private int ects;

    public Course() {}

    public Course(int id, String name, int ects) {
        this.id = id;
        this.name = name;
        this.ects = ects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }
}
