package opendoors.objects;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author jeffb
 */
public class Interactions implements Serializable {

    private int InteractionsID;
    private int Clients_ID;
    private String Date_Of_Contact;
    private String Contact_Name;
    private String Contact_Type;
    private String Conversations;

    private Clients clients;
    private Map<Integer, String> client;

    public int getInteractionsID() {
        return InteractionsID;
    }

    public void setInteractionsID(int InteractionsID) {
        this.InteractionsID = InteractionsID;
    }

    public int getClients_ID() {
        return Clients_ID;
    }

    public void setClients_ID(int Clients_ID) {
        this.Clients_ID = Clients_ID;
    }

    public String getDate_Of_Contact() {
        return Date_Of_Contact;
    }

    public void setDate_Of_Contact(String Date_Of_Contact) {
        this.Date_Of_Contact = Date_Of_Contact;
    }

    public String getContact_Name() {
        return Contact_Name;
    }

    public void setContact_Name(String Contact_Name) {
        this.Contact_Name = Contact_Name;
    }

    public String getContact_Type() {
        return Contact_Type;
    }

    public void setContact_Type(String Contact_Type) {
        this.Contact_Type = Contact_Type;
    }

    public String getConversations() {
        return Conversations;
    }

    public void setConversations(String Conversations) {
        this.Conversations = Conversations;
    }

    public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }

    public Map<Integer, String> getClient() {
        return client;
    }

    public void setClient(Map<Integer, String> client) {
        this.client = client;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Interactions ID: " + this.InteractionsID + ";");
        buffer.append("Clients ID: " + this.Clients_ID + ";");
        buffer.append("Date Of Contact: " + this.Date_Of_Contact + ";");
        buffer.append("Contact Name: " + this.Contact_Name + ";");
        buffer.append("Contact Type: " + this.Contact_Type + ";");
        buffer.append("Conversations: " + this.Conversations);
        return buffer.toString();
    }
}
