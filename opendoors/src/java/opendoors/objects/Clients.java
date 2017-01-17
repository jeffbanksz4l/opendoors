package opendoors.objects;

import java.io.Serializable;

/**
 *
 * @author jeffb
 */
public class Clients implements Serializable {

    private int ClientsID;
    private String Last_Name;
    private String First_Name;
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

    /**
     *
     * @return
     */
    public int getID() {
        return ClientsID;
    }

    /**
     *
     * @param ID
     */
    public void setID(int ID) {
        this.ClientsID = ID;
    }

    /**
     *
     * @return
     */
    public String getLast_Name() {
        return Last_Name;
    }

    /**
     *
     * @param Last_Name
     */
    public void setLast_Name(String Last_Name) {
        this.Last_Name = Last_Name;
    }

    /**
     *
     * @return
     */
    public String getFirst_Name() {
        return First_Name;
    }

    /**
     *
     * @param First_Name
     */
    public void setFirst_Name(String First_Name) {
        this.First_Name = First_Name;
    }

    /**
     *
     * @return
     */
    public String getAddress_Line_1() {
        return Address_Line_1;
    }

    /**
     *
     * @param Address_Line_1
     */
    public void setAddress_Line_1(String Address_Line_1) {
        this.Address_Line_1 = Address_Line_1;
    }

    /**
     *
     * @return
     */
    public String getAddress_Line_2() {
        return Address_Line_2;
    }

    /**
     *
     * @param Address_Line_2
     */
    public void setAddress_Line_2(String Address_Line_2) {
        this.Address_Line_2 = Address_Line_2;
    }

    /**
     *
     * @return
     */
    public String getAddress_Line_3() {
        return Address_Line_3;
    }

    /**
     *
     * @param Address_Line_3
     */
    public void setAddress_Line_3(String Address_Line_3) {
        this.Address_Line_3 = Address_Line_3;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return City;
    }

    /**
     *
     * @param City
     */
    public void setCity(String City) {
        this.City = City;
    }

    /**
     *
     * @return
     */
    public String getState() {
        return State;
    }

    /**
     *
     * @param State
     */
    public void setState(String State) {
        this.State = State;
    }

    /**
     *
     * @return
     */
    public String getPostal_Code() {
        return Postal_Code;
    }

    /**
     *
     * @param Postal_Code
     */
    public void setPostal_Code(String Postal_Code) {
        this.Postal_Code = Postal_Code;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return Email;
    }

    /**
     *
     * @param Email
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     *
     * @return
     */
    public String getPhone_1() {
        return Phone_1;
    }

    /**
     *
     * @param Phone_1
     */
    public void setPhone_1(String Phone_1) {
        this.Phone_1 = Phone_1;
    }

    /**
     *
     * @return
     */
    public String getPhone_2() {
        return Phone_2;
    }

    /**
     *
     * @param Phone_2
     */
    public void setPhone_2(String Phone_2) {
        this.Phone_2 = Phone_2;
    }

    /**
     *
     * @return
     */
    public String getStatus() {
        return Status;
    }

    /**
     *
     * @param Status
     */
    public void setStatus(String Status) {
        this.Status = Status;
    }

    /**
     *
     * @return
     */
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Clients ID: " + this.ClientsID + ";");
        buffer.append("Last Name: " + this.Last_Name + ";");
        buffer.append("First Name: " + this.First_Name + ";");
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
