package oopproject;

//Imports
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author RITAJ M. ALMUTAIRI  - DEEMAH A. ALMUSBEH
 * IDs:       2006532          -    2009024
 */
public class ALULAINFOWINDOWController implements Initializable {
    
    //Window Components
    @FXML
    private Label dateLabel;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField idTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField PackageChoice;
    @FXML
    private RadioButton male;
    @FXML
    private ToggleGroup GenderGroup;
    @FXML
    private RadioButton female;
    @FXML
    private DatePicker DatePicker;
    @FXML
    private Button exit;
    @FXML
    private Button clear;
    @FXML
    private Button Submit;
    
    AlulaTraveller Traveller1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // DID NOT NEED TO INTILIZE ANY COMPONENT 
    }    

    @FXML
    private void DatePicker(ActionEvent event) {
    }

    @FXML
    /**
     * exitAction created for the exit button to exit the window
     */
    private void exitAction(ActionEvent event) 
    {
        //Try-Catch to handle IO-Exception
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ALULA PACKAGESWINDOW.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        
        } 
        catch (IOException io) 
        {
            System.out.println("FXML Loading Error");
        }
    }

    @FXML
    /**
     * ClearAction method to clear all the fields in the window
     */
    private void ClearAction(ActionEvent event) {
       
        //clear all fields
        nameTextField.setText("");
        idTextField.setText("");
        emailTextField.setText("");
        phoneTextField.setText("");
        male.setSelected(false);
        female.setSelected(false);
        DatePicker.setValue(null);
      
    }

   
    
    
    @FXML
    /**
     * SubmitAction created for the submit button 
     */
    private void SubmitAction(ActionEvent event) throws Exception
    {   
        String gen;
        String date=DatePicker.getValue().toString();
        DatePicker.getEditor().setEditable(false);
        
        
        //Step 1: input validation
        inputValidation();
        
     
        
        //TO CONNECT ANOTHER WINDOW
        
        //Try-Catch to handle IO-Exception
        try 
        {
            //hide current window
            ((Node) event.getSource ()).getScene ().getWindow ().hide (); 
            
            //load next window
            FXMLLoader loader = new FXMLLoader (getClass ().getResource ("ALULA CONFIRM.fxml")); 
            Parent root = loader.load ();
            
            
            //Create Controller Object
            ALULACONFIRMController controller3 = loader.getController (); 
            
            //Determine whether the user is a male or a female
            if (male.isSelected())
                gen = "Male";
            else
                gen = "Female";
            
            //Controller calls setUserData method to take the data into the next page
            controller3.setUserData (nameTextField.getText(), idTextField.getText(), phoneTextField.getText() ,
                    emailTextField.getText(), gen, date,PackageChoice.getText() ); 
            
            //show third window
            Stage stage = new Stage ();
            stage.setScene (new Scene (root));
            stage.show();
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    } //END OF SUBMIT ACTION
    
    private void inputValidation() throws Exception 
    {
        //To Validate the current time
        LocalDate today = LocalDate.now();

        //First: check that all fields are valid
        if (!validateName()) 
        {
            //only letters
            JOptionPane.showMessageDialog(null, "Invalid Name !", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
        if (!validateID()) 
        {
            //only numbers
            JOptionPane.showMessageDialog(null, "Invalid ID !", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
        if (!validateEmail()) 
        {
            //Valid E-Mail
            JOptionPane.showMessageDialog(null, "Invalid Email !", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
        if (!validateMobile()) 
        {
            //only numbers
            JOptionPane.showMessageDialog(null, "Invalid Mobile Number !", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
        if (!male.isSelected() && !female.isSelected()) 
        {
            //Gender must be chosen
            JOptionPane.showMessageDialog(null, "Select The Gender!", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
        
        if (DatePicker.getValue() == null ) 
        {
            //A Date must be chosen
            JOptionPane.showMessageDialog(null, "Select The Date", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
        
      
        if (DatePicker.getValue().isBefore(today))
        {
            //Date must be in the future
            JOptionPane.showMessageDialog(null,"Select A Valid Date.\nThis Date Has Passed!","Error",JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
        
        
    }
   
    /**
     * validateName is a name input validation method (name must only be in letters)
     * @return 
     */
    private boolean validateName() 
    {

        return nameTextField.getText().matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
    }
    /**
     * validateID is an ID input validation method (ID must be 10 digits)
     * @return 
     */
    private boolean validateID() 
    {

        return idTextField.getText().matches("\\d{10}");

    }
    /**
     * validateEmail is an Email input validation method (E-Mail must be typed in the correct form)
     * @return 
     */
    private boolean validateEmail() 
    {

        return emailTextField.getText().matches("^(.+)@(.+)$");
    }
    /**
     * validateMobile is a mobile number validation method (number must start with 05 then 8 numbers 0-9 only)
     * @return 
     */
    private boolean validateMobile() 
    {

        return phoneTextField.getText().matches("(05)[0-9]{8}");

    }
   /**
    * Set the data taken from the second window
    * @param PackagePick 
    */
   public void setUserData2(String PackagePick)
    {
        Traveller1 = new AlulaTraveller(PackagePick);
        PackageChoice.setText(PackagePick);
        
    }
    
}
