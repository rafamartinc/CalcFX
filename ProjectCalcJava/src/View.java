import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class View extends JFrame {

    Controller controller;
    JLabel text;
    
    public View(Controller controller) {
        this.controller = controller;
        
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(30, 10, 20, 10));
        this.setContentPane(panel);
        
        Font font = new Font("font", Font.PLAIN, 18);
        
        text = new JLabel();
        text.setPreferredSize(new Dimension (230, 50));
        text.setBorder(new LineBorder(Color.GRAY));
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setFont(font);
        panel.add(text);
        
        String[] buttonContents = new String[]{"7", "8", "9",
                            "/", "4", "5", "6", "*", "1", "2", "3",
                            "-", "0", "=", "+"};
	
        JButton button;
        for(int i = 0; i < 15; i++) {
            button = new JButton(buttonContents[i]);
            button.setFont(font);

            if(button.getText() == "0") button.setPreferredSize(new Dimension(105, 40));
            else button.setPreferredSize(new Dimension(50, 40));

            button.addActionListener(controller);

            panel.add(button);
        }
        
        this.setSize(300, 350);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void setText(String s){ text.setText(s); }
    public String getText(){ return text.getText(); }
}