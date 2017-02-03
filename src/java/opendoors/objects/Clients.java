package opendoors.objects;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author jeffb
 */
public class Clients implements Serializable {

    private int ClientsID;
    private String First_Name;
    private String Last_Name;
    private String Address_Line_1;
    private String Address_Line_2;
    private String Address_Line_3;
    private String City;
    private String State;
    private String Postal_Code;
    private String Email;
    private String Phone_1;
    private String Phone_2;
    private String Status;

    private Interactions interactions;
    private Map<Integer, String> interaction;

    public int getClientsID() {
        return ClientsID;
    }

    public void setClientsID(int ClientsID) {
        this.ClientsID = ClientsID;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String First_Name) {
        this.First_Name = First_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String Last_Name) {
        this.Last_Name = Last_Name;
    }

    public String getAddress_Line_1() {
        return Address_Line_1;
    }

    public void setAddress_Line_1(String Address_Line_1) {
        this.Address_Line_1 = Address_Line_1;
    }

    public String getAddress_Line_2() {
        return Address_Line_2;
    }

    public void setAddress_Line_2(String Address_Line_2) {
        this.Address_Line_2 = Address_Line_2;
    }

    public String getAddress_Line_3() {
        return Address_Line_3;
    }

    public void setAddress_Line_3(String Address_Line_3) {
        this.Address_Line_3 = Address_Line_3;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getPostal_Code() {
        return Postal_Code;
    }

    public void setPostal_Code(String Postal_Code) {
        this.Postal_Code = Postal_Code;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone_1() {
        return Phone_1;
    }

    public void setPhone_1(String Phone_1) {
        this.Phone_1 = Phone_1;
    }

    public String getPhone_2() {
        return Phone_2;
    }

    public void setPhone_2(String Phone_2) {
        this.Phone_2 = Phone_2;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Interactions getInteractions() {
        return interactions;
    }

    public void setInteractions(Interactions interactions) {
        this.interactions = interactions;
    }

    public Map<Integer, String> getInteraction() {
        return interaction;
    }

    public void setInteraction(Map<Integer, String> interaction) {
        this.interaction = interaction;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Clients ID: " + this.ClientsID + ";");
        buffer.append("First Name: " + this.First_Name + ";");
        buffer.append("Last Name: " + this.Last_Name + ";");
        buffer.append("Address Line 1: " + this.Address_Line_1 + ";");
        buffer.append("Address Line 2: " + this.Address_Line_2 + ";");
        buffer.append("Address Line 3: " + this.Address_Line_3 + ";");
        buffer.append("City: " + this.City + ";");
        buffer.append("State: " + this.State + ";");
        buffer.append("Postal Code: " + this.Postal_Code + ";");
        buffer.append("Email: " + this.Email + ";");
        buffer.append("Phone 1: " + this.Phone_1 + ";");
        buffer.append("Phone 2: " + this.Phone_2 + ";");
        buffer.append("Status: " + this.Status);
        return buffer.toString();
    }
}
