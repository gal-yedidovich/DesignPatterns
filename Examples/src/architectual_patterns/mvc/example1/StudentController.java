package architectual_patterns.mvc.example1;

/**
 * Controller class
 */
public class StudentController {
    private StudentView view;
    private StudentModel model;

    public StudentController(StudentView view, StudentModel model) {
        this.view = view;
        view.attach(this);
        this.model = model;
    }

    public void setStudentName(String studentName) {
        this.model.setName(studentName);
    }

    public void updateView(){
        view.presentStudent(model);
    }
}
