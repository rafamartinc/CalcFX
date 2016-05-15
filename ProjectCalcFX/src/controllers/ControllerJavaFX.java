package controllers;

import java.util.Arrays;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import views.ViewJavaFX;

public class ControllerJavaFX extends Controller {

    // --- ATRIBUTES ---
        private ViewJavaFX view;

    // --- CONSTRUCTOR ---
        public ControllerJavaFX(Stage primaryStage) throws Exception {
            super();
            view = new ViewJavaFX(primaryStage, this);
            view.show();
        }
    
    // --- CONTROLLER METHODS ---
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
        public void process(ActionEvent event) {
            String value = ((Button)event.getSource()).getText();
            List<String> digits = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");

            if(digits.contains(value))
                processNumpad(event);
            else
                processOperator(event);
        }
}
