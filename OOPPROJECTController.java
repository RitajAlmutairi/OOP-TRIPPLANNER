package oopproject;

//Imports
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RITAJ M. ALMUTAIRI  - DEEMAH A. ALMUSBEH
 * IDs:       2006532          -    2009024
 */
public class OOPPROJECTController implements Initializable {
    
    //Window Components
    @FXML
    private Button ALULA1;
    @FXML
    private Button BAYADA1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //DID NOT NEED TO INITIALIZE ANY COMPONENT
    }    

    @FXML
    /**
     * ALULA ACTION event will take the user to ALULA PACKAGES WINDOW
     */
    private void ALULAACTION(ActionEvent event) {
        //TO CONNECT ANOTHER WINDOW
        //Try-Catch to handle IO-Exception
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ALULA PACKAGESWINDOW.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        
        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }
    }

    @FXML
    /**
     * BAYADA ACTION event will take the user to BAYADA PACKAGES WINDOW
     */
    private void BAYADAACTION(ActionEvent event)
    {
        //TO CONNECT ANOTHER WINDOW
        //Try-Catch to handle IO-Exception
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BAYADAPACKGESWINDOW.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        
        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }

    }
    
}
