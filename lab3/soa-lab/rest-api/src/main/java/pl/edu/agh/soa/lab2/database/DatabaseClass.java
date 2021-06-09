package pl.edu.agh.soa.lab2.database;

import pl.edu.agh.soa.model.Student;
import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {

    private static Map<Integer, Student> students = new HashMap<>();

    public static Map<Integer, Student> getStudents() {
        return students;
    }

    static {
        students.put(1, new Student(1, "Anna", "Kowalska"));
        students.put(2, new Student(2, "Kasia", "Kowalska"));
    }
}
