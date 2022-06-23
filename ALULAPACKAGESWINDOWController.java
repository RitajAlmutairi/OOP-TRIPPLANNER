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
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author RITAJ M. ALMUTAIRI  - DEEMAH A. ALMUSBEH
 * IDs:       2006532          -    2009024
 */
public class ALULAPACKAGESWINDOWController implements Initializable {

    //Window Components
    @FXML
    private RadioButton firstPackage1;
    @FXML
    private ToggleGroup packgesGroup1;
    @FXML
    private RadioButton SecondPackage1;
    @FXML
    private RadioButton ThirdPackage1;
    @FXML
    private ImageView P1IMAGE;
    @FXML
    private Button exit1;
    @FXML
    private Button Submit;
    
    private String PackagePick;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //DID NOT NEED TO INITIALIZE ANY COMPONENT
    }    
    
    //AL-Ula Packages Radio Buttons:
    @FXML
    private void firstPackageAction1(ActionEvent event) {
       
    }

    @FXML
    private void SecondPackageAction1(ActionEvent event) {
 
    }

    @FXML
    private void ThirdPackageAction1(ActionEvent event) {
      
    }

    @FXML
    /**
     * exitAction1 Action event will take the user to the previous page
     */
    private void exitAction1(ActionEvent event) {
        //TO CONNECT ANOTHER WINDOW
        //Try-Catch to handle IO-Exception
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OOPPROJECT.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            
        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }

    }

    @FXML
    /**
     * SubmitAction1 Action event will take the user to the information page
     */
    private void SubmitAction1(ActionEvent event) throws Exception 
    {
        //Method calling
        packagesValidation();
        
       
        //TO CONNECT ANOTHER WINDOW + Try-Catch to handle IO-Exception
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ALULAINFOWINDOW.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            
            //Creating Controller Object
            ALULAINFOWINDOWController controller3 = loader.getController (); 
            
            //Determine which package the user selected
            if (firstPackage1.isSelected()){
                PackagePick = "First Package";    
            }
            else if(SecondPackage1.isSelected()){
                PackagePick = "Second Package";
            }
            else if(ThirdPackage1.isSelected()){
                PackagePick = "Third Package";
            }
            
            //Controller calls setUserData2 method to take the data into the next window (Sends the chosen package)
            controller3.setUserData2(PackagePick);
        
        } catch (IOException io) 
        {
            System.out.println("FXML Loading Error");
        }

    }
    /**
     * Packages Validation method forces the user to pick a package before moving on to the next page.
     * @throws Exception 
     */
     private void packagesValidation() throws Exception 
     {
         if (!firstPackage1.isSelected() && !SecondPackage1.isSelected() && !ThirdPackage1.isSelected()) 
        {
            JOptionPane.showMessageDialog(null, "Select The Desierd Package!", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
     }
    
}
