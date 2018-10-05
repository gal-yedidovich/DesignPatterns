package other_patterns.dao.dao;

public interface StudentDao {
    void addStudent(Student s);

    void removeStudent(Student s);

    Student getStudent(int id);

    Student[] getAllStudents();

    void updateStudent(Student s);

    void clearAll();
}
