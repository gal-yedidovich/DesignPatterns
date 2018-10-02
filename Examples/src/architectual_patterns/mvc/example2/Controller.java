package architectual_patterns.mvc.example2;

public class Controller {
    private MyModel model;
    private Button btn1, btn2, btn3;

    public Controller() {
        model = new MyModel();
        btn1 = new Button();
        btn1.setText("count button");
        btn2 = new Button();
        btn2.setText("toggle is alive button");
        btn3 = new Button();
        btn1.setText("print button");

        //two event handler
        btn1.setClickListener((View v) -> model.setCount(model.getCount() + 1));
        btn2.setClickListener((View v) -> model.setAlive(!model.isAlive()));
        btn3.setClickListener((View v) -> System.out.println("count: " + model.getCount() + ", is alive:" + model.isAlive()));

        btn1.presentView();
        btn2.presentView();
        btn3.presentView();
    }

    public void clickBtn1() {
        btn1.click();
    }

    public void clickBtn2() {
        btn2.click();
    }

    public void clickBtn3() {
        btn3.click();
    }
}
