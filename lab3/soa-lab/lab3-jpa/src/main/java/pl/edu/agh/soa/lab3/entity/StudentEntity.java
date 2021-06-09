package pl.edu.agh.soa.lab3.entity;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "students")
public class StudentEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "studentID")
    private int id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String avatar = "C:\\Users\\Paulina\\Desktop\\cat.jpg";

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "students_enrollments",
            joinColumns = {@JoinColumn(name = "studentID")},
            inverseJoinColumns = {@JoinColumn(name = "subjectID")})
    private Map<Integer, CourseEntity> courses;

    public Map<Integer, CourseEntity> getCourses() {
        return courses;
    }

    public void setCourses(Map<Integer, CourseEntity> courses) {
        this.courses = courses;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private FacultyEntity faculty;

    public FacultyEntity getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyEntity faculty) {
        this.faculty = faculty;
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
}


