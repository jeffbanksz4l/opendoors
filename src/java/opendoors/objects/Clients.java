package opendoors.objects;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
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
    private Map<String, String> StatusMap;
    private Map<String, String> StatesMap;

    private Interactions interactions;
    private Map<Integer, String> interactionMap;

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

    public Map<String, String> getStatusMap() {

        StatusMap = new LinkedHashMap<String, String>();
        this.StatusMap.put("Prospect", "Prospect");
        this.StatusMap.put("Client", "Client");
        this.StatusMap.put("Inactive", "Inactive");

        return StatusMap;
    }

    public Map<String, String> getStatesMap() {

        this.StatesMap = new LinkedHashMap<String, String>();
        this.StatesMap.put("AL - Alabama", "AL - Alabama");
        this.StatesMap.put("AK - Alaska", "AK - Alaska");
        this.StatesMap.put("AZ - Arizona", "AZ - Arizona");
        this.StatesMap.put("AR - Arkansas", "AR - Arkansas");
        this.StatesMap.put("CA - California", "CA - California");
        this.StatesMap.put("CO - Colorado", "CO - Colorado");
        this.StatesMap.put("CT - Connecticut", "CT - Connecticut");
        this.StatesMap.put("DE - Delaware", "DE - Delaware");
        this.StatesMap.put("FL - Florida", "FL - Florida");
        this.StatesMap.put("GA - Georgia", "GA - Georgia");
        this.StatesMap.put("HI - Hawaii", "HI - Hawaii");
        this.StatesMap.put("ID - Idaho", "ID - Idaho");
        this.StatesMap.put("IL - Illinois", "IL - Illinois");
        this.StatesMap.put("IN - Indiana", "IN - Indiana");
        this.StatesMap.put("IA - Iowa", "IA - Iowa");
        this.StatesMap.put("KS - Kansas", "KS - Kansas");
        this.StatesMap.put("KY - Kentucky", "KY - Kentucky");
        this.StatesMap.put("LA - Louisiana", "LA - Louisiana");
        this.StatesMap.put("ME - Maine", "ME - Maine");
        this.StatesMap.put("MD - Maryland", "MD - Maryland");
        this.StatesMap.put("MA - Massachusetts", "MA - Massachusetts");
        this.StatesMap.put("MI - Michigan", "MI - Michigan");
        this.StatesMap.put("MN - Minnesota", "MN - Minnesota");
        this.StatesMap.put("MS - Mississippi", "MS - Mississippi");
        this.StatesMap.put("MO - Missouri", "MO - Missouri");
        this.StatesMap.put("MT - Montana", "MT - Montana");
        this.StatesMap.put("NE - Nebraska", "NE - Nebraska");
        this.StatesMap.put("NV - Nevada", "NV - Nevada");
        this.StatesMap.put("NH - New Hampshire", "NH - New Hampshire");
        this.StatesMap.put("NJ - New Jersey", "NJ - New Jersey");
        this.StatesMap.put("NM - New Mexico", "NM - New Mexico");
        this.StatesMap.put("NY - New York", "NY - New York");
        this.StatesMap.put("NC - North Carolina", "NC - North Carolina");
        this.StatesMap.put("ND - North Dakota", "ND - North Dakota");
        this.StatesMap.put("OH - Ohio", "OH - Ohio");
        this.StatesMap.put("OK - Oklahoma", "OK - Oklahoma");
        this.StatesMap.put("OR - Oregon", "OR - Oregon");
        this.StatesMap.put("PA - Pennsylvania", "PA - Pennsylvania");
        this.StatesMap.put("RI - Rhode Island", "RI - Rhode Island");
        this.StatesMap.put("SC - South Carolina", "SC - South Carolina");
        this.StatesMap.put("SD - South Dakota", "SD - South Dakota");
        this.StatesMap.put("TN - Tennessee", "TN - Tennessee");
        this.StatesMap.put("TX - Texas", "TX - Texas");
        this.StatesMap.put("UT - Utah", "UT - Utah");
        this.StatesMap.put("VT - Vermont", "VT - Vermont");
        this.StatesMap.put("VA - Virginia", "VA - Virginia");
        this.StatesMap.put("WA - Washington", "WA - Washington");
        this.StatesMap.put("WV - West Virginia", "WV - West Virginia");
        this.StatesMap.put("WI - Wisconsin", "WI - Wisconsin");
        this.StatesMap.put("WY - Wyoming", "WY - Wyoming");
        this.StatesMap.put("AS - American Samoa", "AS - American Samoa");
        this.StatesMap.put("DC - District of Columbia", "DC - District of Columbia");
        this.StatesMap.put("FM - Federated States of Micronesia", "FM - Federated States of Micronesia");
        this.StatesMap.put("GU - Guam", "GU - Guam");
        this.StatesMap.put("MH - Marshall Islands", "MH - Marshall Islands");
        this.StatesMap.put("MP - Northern Mariana Islands", "MP - Northern Mariana Islands");
        this.StatesMap.put("PW - Palau", "PW - Palau");
        this.StatesMap.put("PR - Puerto Rico", "PR - Puerto Rico");
        this.StatesMap.put("VI - Virgin Islands", "VI - Virgin Islands");
        this.StatesMap.put("AE - Armed Forces Africa", "AE - Armed Forces Africa");
        this.StatesMap.put("AA - Armed Forces Americas", "AA - Armed Forces Americas");
        this.StatesMap.put("AE - Armed Forces Canada", "AE - Armed Forces Canada");
        this.StatesMap.put("AE - Armed Forces Europe", "AE - Armed Forces Europe");
        this.StatesMap.put("AE - Armed Forces Middle East", "AE - Armed Forces Middle East");
        this.StatesMap.put("AP - Armed Forces Pacific", "AP - Armed Forces Pacific");

        return StatesMap;
    }

    public Interactions getInteractions() {
        return interactions;
    }

    public void setInteractions(Interactions interactions) {
        this.interactions = interactions;
    }

    public Map<Integer, String> getInteractionMap() {
        return interactionMap;
    }

//    public void setInteraction(Map<Integer, String> interactionMap) {
//        this.interactionMap = interactionMap;
//    }
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(this.First_Name + " " + this.Last_Name);
//        buffer.append("Clients ID: " + this.ClientsID + ";");
//        buffer.append("First Name: " + this.First_Name + ";");
//        buffer.append("Last Name: " + this.Last_Name + ";");
//        buffer.append("Address Line 1: " + this.Address_Line_1 + ";");
//        buffer.append("Address Line 2: " + this.Address_Line_2 + ";");
//        buffer.append("Address Line 3: " + this.Address_Line_3 + ";");
//        buffer.append("City: " + this.City + ";");
//        buffer.append("State: " + this.State + ";");
//        buffer.append("Postal Code: " + this.Postal_Code + ";");
//        buffer.append("Email: " + this.Email + ";");
//        buffer.append("Phone 1: " + this.Phone_1 + ";");
//        buffer.append("Phone 2: " + this.Phone_2 + ";");
//        buffer.append("Status: " + this.Status);
        return buffer.toString();
    }
}
