import controllers.Controller;
import controllers.ControllerJavaFX;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.text.View;

public class CalcFX extends Application {
    
    public static final boolean useFXML = true;

    public static void main(String[] args) {
        launch();
    }
    @Override public void start(Stage primaryStage) throws Exception {
        
        if(useFXML) {
            Parent root = FXMLLoader.load(View.class.getResource("/views/ViewFXML.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } else {
            Controller c = new ControllerJavaFX(primaryStage);
        }
    }
}