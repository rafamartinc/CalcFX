package controllers;

import java.util.Arrays;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class ControllerFXML extends Controller {

    // --- ATRIBUTES ---
        @FXML
        private Text output;

    // --- CONSTRUCTOR ---
        public ControllerFXML() { super(); }

    // --- CONTROLLER METHODS ---
        private void processNumpad(ActionEvent event) {
            if (start) {
                output.setText("");
                start = false;
            }

            String value = ((Button)event.getSource()).getText();
            output.setText(output.getText() + value);
        }
        private void processOperator(ActionEvent event) {
            String value = ((Button)event.getSource()).getText();

            if (!"=".equals(value)) {
                if (!operator.isEmpty())
                    return;

                operator = value;
                number1 = Long.parseLong(output.getText());
                output.setText("");
            }
            else {
                if (operator.isEmpty())
                    return;

                output.setText(String.valueOf(model.calculate(number1, Long.parseLong(output.getText()), operator)));
                operator = "";
                start = true;
            }
        }
        @FXML
        public void process(ActionEvent event) {
            String value = ((Button)event.getSource()).getText();
            List<String> digits = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");

            if(digits.contains(value))
                processNumpad(event);
            else
                processOperator(event);
        }
}
