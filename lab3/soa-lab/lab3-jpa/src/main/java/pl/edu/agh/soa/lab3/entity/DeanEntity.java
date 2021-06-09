package pl.edu.agh.soa.lab3.entity;

import javax.persistence.*;

@Entity
@Table(name = "deans")
public class DeanEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String degree;

    private String name;

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
