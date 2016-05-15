package calcj;

import java.awt.Button;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Controller implements ActionListener {
    
    // --- ATRIBUTES ---
    protected Model model;
    private View view;
    
    protected long number1;
    protected String operator;
    protected boolean start;

    // --- CONSTRUCTOR ---
        public Controller() {
            model = new Model();
            number1 = 0;
            operator = "";
            start = true;
            
            view = new View(this);
            view.show();
        }
    
    // --- CONTROLLER METHODS ---
        public void processNumpad(ActionEvent event) {
            if (start) {
                view.setText("");
                start = false;
            }

            String value = ((JButton)event.getSource()).getText();
            view.setText(view.getText() + value);
        }
        public void processOperator(ActionEvent event) {
            String value = ((JButton)event.getSource()).getText();

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

        @Override
        public void actionPerformed(ActionEvent event) {
                String value = ((JButton)event.getSource()).getText();
                List<String> digits = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");

                if(digits.contains(value))
                    processNumpad(event);
                else
                    processOperator(event);
        }
}