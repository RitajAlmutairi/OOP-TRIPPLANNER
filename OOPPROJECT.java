package oopproject;

//Imports
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author RITAJ M. ALMUTAIRI  - DEEMAH A. ALMUSBEH
 * IDs:       2006532          -    2009024
 */
public class OOPPROJECT extends Application {
    
    @Override
    public void start(Stage stage) {
       //START CODE
     //Try-Catch to handle Exception 
     try {
            // Load the FXML file.
            Parent parent = FXMLLoader.load(getClass().getResource("OOPPROJECT.fxml"));

            // Build the scene graph.
            Scene scene = new Scene(parent);

            // Display our window, using the scene graph.
            stage.setTitle("Trip Planner");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println("FXML Loading Error");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }   
}