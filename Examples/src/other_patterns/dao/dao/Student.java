package other_patterns.dao.dao;

import java.util.Arrays;

public class Student {
    private int id;
    private String name;
    private int[] grades;

    public Student(int id, String name, int[] grades) {
        this.id = id;
        this.name = name;
        this.grades = grades;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int[] getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return name + ", " + Arrays.toString(grades);
    }
}
