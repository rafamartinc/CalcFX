import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControllerJavaFX {


    private long number1 = 0;
    private String operator = "";
    private boolean start = true;

    private Model model;
    private ViewJavaFX view;
    
    public ControllerJavaFX(Stage primaryStage) {
        model = new Model();
        view = new ViewJavaFX(primaryStage, this);
        view.show();
    }

    public void processNumpad(ActionEvent event) {
        if (start) {
            view.setText("");
            start = false;
        }

        String value = ((Button)event.getSource()).getText();
        view.setText(view.getText() + value);
    }

    public void processOperator(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();

        if (!"=".equals(value)) {
            if (!operator.isEmpty())
                return;

            operator = value;
            number1 = Long.parseLong(view.getText());
            view.setText("");
        }
        else {
            if (operator.isEmpty())
                return;

            view.setText(String.valueOf(model.calculate(number1, Long.parseLong(view.getText()), operator)));
            operator = "";
            start = true;
        }
    }
}
