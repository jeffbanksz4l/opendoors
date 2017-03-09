package opendoors.objects;

import java.io.Serializable;
//import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author jeffb
 */
public class Interactions implements Serializable {

    private int InteractionsID;
    private int Clients_ID;
    private Date Date_Of_Contact;
    private String Contact_First_Name;
    private String Contact_Last_Name;
    private String Contact_Type;
    private String Conversations;
    private Map<String, String> Contact_TypeMap;

    private Clients clients;
    private Map<Integer, String> ClientInteractMap;

    /**
     * Getting the Interactions ID
     *
     * @return
     */
    public int getInteractionsID() {
        return InteractionsID;
    }

    /**
     * Setting the Interactions ID
     *
     * @param InteractionsID
     */
    public void setInteractionsID(int InteractionsID) {
        this.InteractionsID = InteractionsID;
    }

    /**
     * Getting the Clients ID
     *
     * @return
     */
    public int getClients_ID() {
        return Clients_ID;
    }

    /**
     * Setting the Clients ID
     *
     * @param Clients_ID
     */
    public void setClients_ID(int Clients_ID) {
        this.Clients_ID = Clients_ID;
    }

    /**
     * Getting the Date Of Contact
     *
     * @return
     */
    public Date getDate_Of_Contact() {
        return Date_Of_Contact;
    }

//    /**
//     * Setting the Date Of Contact Formatted
//     *
//     * @return
//     */
//    public String getDate_Of_ContactFormatted() {
//
//        SimpleDateFormat dateFormatted = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
//
//        return dateFormatted.format(Date_Of_Contact);
//    }
    /**
     * Setting the Date Of Contact
     *
     * @param Date_Of_Contact
     */
    public void setDate_Of_Contact(Date Date_Of_Contact) {
        this.Date_Of_Contact = Date_Of_Contact;
    }

    /**
     * Getting the Contact First Name
     *
     * @return
     */
    public String getContact_First_Name() {
        return Contact_First_Name;
    }

    /**
     * Setting the Contact First Name
     *
     * @param Contact_First_Name
     */
    public void setContact_First_Name(String Contact_First_Name) {
        this.Contact_First_Name = Contact_First_Name;
    }

    /**
     * Getting the Contact Last Name
     *
     * @return
     */
    public String getContact_Last_Name() {
        return Contact_Last_Name;
    }

    /**
     * Setting the Contact Last Name
     *
     * @param Contact_Last_Name
     */
    public void setContact_Last_Name(String Contact_Last_Name) {
        this.Contact_Last_Name = Contact_Last_Name;
    }

    /**
     * Getting the Contact Type
     *
     * @return
     */
    public String getContact_Type() {
        return Contact_Type;
    }

    /**
     * Setting the Contact Type
     *
     * @param Contact_Type
     */
    public void setContact_Type(String Contact_Type) {
        this.Contact_Type = Contact_Type;
    }

    /**
     * Getting the Conversations
     *
     * @return
     */
    public String getConversations() {
        return Conversations;
    }

    /**
     * Setting the Conversations
     *
     * @param Conversations
     */
    public void setConversations(String Conversations) {
        this.Conversations = Conversations;
    }

    /**
     * Getting the Clients
     *
     * @return
     */
    public Clients getClients() {
        return clients;
    }

    /**
     * Setting the Clients
     *
     * @param clients
     */
    public void setClients(Clients clients) {
        this.clients = clients;
    }

    /**
     * Getting a Map of the Contact Types
     *
     * @return
     */
    public Map<String, String> getContact_TypeMap() {

        this.Contact_TypeMap = new LinkedHashMap<String, String>();
        this.Contact_TypeMap.put("Email", "Email");
        this.Contact_TypeMap.put("Phone", "Phone");
        this.Contact_TypeMap.put("In Person", "In Person");
        this.Contact_TypeMap.put("Other", "Other");

        return Contact_TypeMap;
    }

    /**
     * Getting the Clients Interactions Map
     *
     * @return
     */
    public Map<Integer, String> getClientInteractMap() {
        return ClientInteractMap;
    }

    /**
     * Setting the Clients Interactions Map
     *
     * @param ClientInteractMap
     */
    public void setClient(Map<Integer, String> ClientInteractMap) {
        this.ClientInteractMap = ClientInteractMap;
    }

    /**
     * Sending data to a String
     *
     * @return
     */
    public String toString() {
        StringBuffer buffer = new StringBuffer();
//        buffer.append("Interactions ID: " + this.InteractionsID + ";");
//        buffer.append("Clients ID: " + this.Clients_ID + ";");
//        buffer.append("Date Of Contact: " + this.Date_Of_Contact + ";");
//        buffer.append("Contact Name: " + this.Contact_First_Name + ";");
//        buffer.append("Contact Name: " + this.Contact_Last_Name + ";");
//        buffer.append("Contact Type: " + this.Contact_Type + ";");
//        buffer.append("Conversations: " + this.Conversations);
        return buffer.toString();
    }
}
