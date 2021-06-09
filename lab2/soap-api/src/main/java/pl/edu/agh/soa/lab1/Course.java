package pl.edu.agh.soa.lab1;

public class Course {
    private String name;
    private Integer ects;


    public Course(String name, Integer ects){
        this.name = name;
        this.ects = ects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEcts() {
        return ects;
    }

    public void setEcts(Integer ects) {
        this.ects = ects;
    }
}

