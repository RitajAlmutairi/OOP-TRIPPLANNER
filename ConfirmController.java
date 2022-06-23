package oopproject;

//Imports
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author RITAJ M. ALMUTAIRI - DEEMAH A. ALMUSBEH 
 *IDs:       2006532          -    2009024
 */
public class ConfirmController implements Initializable 
{
    
    //Window Components
    @FXML
    private TextField nameTextField2;
    @FXML
    private TextField idTextField2;
    @FXML
    private TextField phoneTextField2;
    @FXML
    private TextField emailTextField2;
    @FXML
    private TextField GenderTextField2;
    @FXML
    private TextField DateTextField2;
    @FXML
    private TextField PackageTextField2;
    @FXML
    private Button exit;
    @FXML
    private Button Submit;

     private Traveller traveller; //global object
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void exitAction(ActionEvent event) {
      {
        //TO CONNECT ANOTHER WINDOW
        //Try-Catch to handle IO-Exception
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("INFOWINDOW.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            
            //Stores the package choice of the user when clicking the "change information" button
            INFOWINDOWController Packagecontroller = loader.getController (); 
            Packagecontroller.setUserData2(PackageTextField2.getText());
            
        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }
    }
    }

    @FXML
    private void SubmitAction(ActionEvent event) 
    {
        //Step1: write student information to the file
        writeToFile(traveller);
         
        //Step2: then go back to the second window to add another student
        //Try-Catch to handle IO-Exception
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BAYADAPACKGESWINDOW.fxml"));
            Stage stage2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage2.setScene(scene);

        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }

    /**
     * Set the data taken from the third window
     * @param name
     * @param id
     * @param phone
     * @param email
     * @param gender
     * @param date 
     * @param PackagePick 
     */
    public void setUserData (String name, String id, String number, String email, String gender, String date, String PackagePick)  
    {
        traveller = new Traveller (name,  id,  number,  email,  gender,  date, PackagePick) ;
        
        nameTextField2.setText (name);
        idTextField2.setText (id);
        phoneTextField2.setText (number);
        emailTextField2.setText (email);
        GenderTextField2.setText (gender);
        DateTextField2.setText(""+ date);
        PackageTextField2.setText(PackagePick);
    }
    /**
     * WriteToFile method takes the data from Object o and writes it in a file 
     * @param o 
     */
    private void writeToFile(Object o) 
    {
         // Create the stream objects.
        ObjectOutputStream objectOutputFile = null;
        FileOutputStream outStream = null;
        
        //Try-Catch to handle File Not Found Error and IO-Exception
        try 
        {
            
            //Write in Bayada.txt file
            outStream = new FileOutputStream("Bayada.txt");
            objectOutputFile = new ObjectOutputStream(outStream);
            
            // Write the serialized objects to the file.
            objectOutputFile.writeObject(o.toString());
            
            //show confirmation message
            JOptionPane.showMessageDialog(null, "Your Registration is confirmed!\nWe're excited to see you soon!");
            objectOutputFile.close();
            
        } catch (FileNotFoundException ex) 
        {
            System.out.println("Error wrting to file");
        } 
        catch (IOException ex) 
        {
            System.out.println("Error wrting to file");
        }

    }
    
}
