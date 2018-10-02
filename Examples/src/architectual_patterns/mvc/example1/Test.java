package architectual_patterns.mvc.example1;

/**
 * MvcTester
 */
public class Test {
    public static void main(String[] args) {
        StudentModel student = new StudentModel("Gal", new int[]{80, 70, 90});
        StudentView view = new StudentView();
        StudentController controller = new StudentController(view, student);

        controller.updateView();

        //button was clicked
        view.updateNameClick("Nevoa");

        controller.updateView();
    }
}
