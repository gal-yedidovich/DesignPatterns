package other_patterns.dao.dao;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonStudentDao implements StudentDao {
    private String path = "Examples/src/other_patterns/dao/dao/students.json";

    public JsonStudentDao() {
        try {
            File file = new File(path);
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addStudent(Student s) {
        JSONObject json = readData();
        if (json.has(s.getId() + "")) {
            throw new IllegalArgumentException("Id already exists");
        } else {
            try {
                json.put(s.getId() + "", new JSONObject()
                        .put("name", s.getName())
                        .put("grades", new JSONArray(s.getGrades())));
                writeDate(json);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void removeStudent(Student s) {
        JSONObject json = readData();
        json.remove(s.getId() + "");
        writeDate(json);
    }

    @Override
    public Student getStudent(int id) {
        try {
            JSONObject jsonStudent = readData().getJSONObject(id + "");
            JSONArray arr = jsonStudent.getJSONArray("grades");
            int[] grades = new int[arr.length()];
            for (int i = 0; i < grades.length; i++) grades[i] = arr.getInt(i);
            return new Student(id, jsonStudent.getString("name"), grades);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Student[] getAllStudents() {
        JSONObject json = readData();
        Student[] students = new Student[json.length()];
        var it = json.keys();
        int i = 0;
        while (it.hasNext()) {
            Student s = getStudent(Integer.parseInt(it.next().toString()));
            students[i++] = s;
        }

        return students;
    }

    @Override
    public void updateStudent(Student s) {
        JSONObject json = readData();
        try {
            json.getJSONObject(s.getId() + "")
                    .put("name", s.getName())
                    .put("grades", new JSONArray(s.getGrades()));
            writeDate(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void clearAll() {
        writeDate(new JSONObject());
    }

    private JSONObject readData() {
        try {
            String data = new String(Files.readAllBytes(Paths.get(path)));
            return new JSONObject(data);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    private void writeDate(JSONObject json) {
        try (OutputStream fos = new FileOutputStream(path)) {
            fos.write(json.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
