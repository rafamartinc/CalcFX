package views;

import controllers.ControllerJavaFX;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ViewJavaFX {
	
        ControllerJavaFX controller;
	Stage primaryStage;
        Text text;
	
	public ViewJavaFX(Stage primaryStage, ControllerJavaFX controller){
                this.controller = controller;
		this.primaryStage = primaryStage;
	}
	
	public void show(){
		VBox vBox = new VBox();
		vBox.setSpacing(10);
		vBox.setAlignment(Pos.CENTER);
		vBox.setPrefWidth(300);
		vBox.setPrefHeight(300);
		
		Font font = new Font(18);
		
		StackPane pane = new StackPane();
		pane.setAlignment(Pos.CENTER);
		vBox.getChildren().add(pane);
		
		Rectangle rectangle = new Rectangle();
		rectangle.setFill(Color.TRANSPARENT);
                rectangle.setStroke(Color.GRAY);
                rectangle.setWidth(230);
                rectangle.setHeight(50);
                pane.getChildren().add(rectangle);
                
                text = new Text();
                text.setFont(font);
                pane.getChildren().add(text);
                
                String[] buttonContents = new String[]{"7", "8", "9",
                            "/", "4", "5", "6", "*", "1", "2", "3",
                            "-", "0", "=", "+"};
		
                HBox[] hBox = new HBox[4];
                Button button;
                for(int i = 0; i < 4; i++) {
                    hBox[i] = new HBox();
                    hBox[i].setSpacing(10);
                    hBox[i].setAlignment(Pos.CENTER);
                    vBox.getChildren().add(hBox[i]);
                    
                    for(int j = 0; j < 4 && 4*i + j != 15; j++) {
                        button = new Button(buttonContents[4*i + j]);
                        button.setFont(font);

                        if(button.getText() == "0") button.setPrefWidth(110);
                        else button.setPrefWidth(50);
                        
                        button.setOnAction(new EventHandler<ActionEvent>(){
                           @Override public void handle(ActionEvent e){
                               controller.process(e);
                           } 
                        });

                        hBox[i].getChildren().add(button);   
                    }
                }
                
		primaryStage.setScene(new Scene(vBox, 300, 300));
		primaryStage.show();
	}
        
        public void setText(String s){ text.setText(s); }
        public String getText(){ return text.getText(); }
}
