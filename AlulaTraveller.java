package oopproject;

//Import
import java.io.Serializable;

/**
 *
 * @author RITAJ M. ALMUTAIRI  - DEEMAH A. ALMUSBEH
 * IDs:       2006532          -    2009024
 */
public class AlulaTraveller implements Serializable
{
   //Intializing Data
    private String name;
    private String ID;
    private String number;
    private String email;
    private String gender;
    private String Date;
    private String PackagePick;

    
    //Constructors
    public AlulaTraveller(String name, String ID, String number, String email, String gender, String Date, String PackagePick) {
        this.name = name;
        this.ID = ID;
        this.number = number;
        this.email = email;
        this.gender = gender;
        this.Date = Date;
        this.PackagePick = PackagePick;
    }
   
    public AlulaTraveller(String PackagePick){
        this.PackagePick=PackagePick;
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getDate() {
        return Date;
    }
    public String getPackagePick(){
        return PackagePick;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
    public void setPackaPick(String PackagePick){
        this.PackagePick=PackagePick;
    }
    /**
     * toString method converts Traveller information to a string
     * @return String
     */
    @Override
    public String toString() {
        return "============================Traveller inforamtion============================\n{" + "name=" + name + ", ID=" + ID + ", number=" + number + ", email=" + email + ", gender=" + gender + ", Date=" + Date + ", Selected Package=" + PackagePick + '}';
    }

    
    
    
    
}
