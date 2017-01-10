/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opendoors;

import java.io.Serializable;

/**
 *
 * @author jeffb
 */
public class contacts implements Serializable {
    private int ID;
    private int Client_ID;
    private String Date_Of_Contact;
    private String Contact_Name;
    private String Contact_Type;
    private String Conversations;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getClient_ID() {
        return Client_ID;
    }

    public void setClient_ID(int Client_ID) {
        this.Client_ID = Client_ID;
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
    
    
}
