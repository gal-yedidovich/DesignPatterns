package other_patterns.dao;

import other_patterns.dao.dao.JsonStudentDao;
import other_patterns.dao.dao.Student;
import other_patterns.dao.dao.StudentDao;

public class DaoTester {
    public static void main(String[] args) {
        StudentDao dao = new JsonStudentDao();
        dao.clearAll();

        dao.addStudent(new Student(0, "Bubu", new int[]{90, 80, 90}));
        dao.addStudent(new Student(1, "Groot", new int[]{80, 90, 50}));
        dao.addStudent(new Student(2, "Deadpool", new int[]{10, 20, 30}));

        System.out.println(dao.getStudent(0));

        System.out.println("all students:");
        for (Student s : dao.getAllStudents()) {
            System.out.println(s);
        }
    }
}
