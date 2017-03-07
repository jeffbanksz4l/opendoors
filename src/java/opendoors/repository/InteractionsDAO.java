package opendoors.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.JdbcTemplate;

import opendoors.objects.Clients;
import opendoors.objects.Interactions;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author jeffb
 */
public class InteractionsDAO {

    JdbcTemplate template;

    private static final Logger logger = Logger.getLogger(InteractionsDAO.class.getName());

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Interactions interactions) {
        String sql = "INSERT INTO Interactions (Clients_ID, Date_Of_Contact, Contact_First_Name, Contact_Last_Name, Contact_Type, Conversations) values (?, ?, ?, ?, ?, ?)";

        Object[] values = {interactions.getClients_ID(), interactions.getDate_Of_Contact(), interactions.getContact_First_Name(), interactions.getContact_Last_Name(), interactions.getContact_Type(), interactions.getConversations()};

        logger.info("Interactions DAO save values: " + values);

        return template.update(sql, values);
    }

    public int update(Interactions interactions) {
        String sql = "UPDATE Interactions SET Clients_ID = ?, Date_Of_Contact = ?, Contact_First_Name = ?, Contact_Last_Name = ?, Contact_Type = ?, Conversations = ? WHERE InteractionsID = ?";

        Object[] values = {interactions.getClients_ID(), interactions.getDate_Of_Contact(), interactions.getContact_First_Name(), interactions.getContact_Last_Name(), interactions.getContact_Type(), interactions.getConversations()};

        logger.info("Interactions DAO save values: " + values);

        return template.update(sql, values);
    }

    public int delete(int id) {
        String sql = "DELETE FROM Interactions WHERE InteractionsID = ?";

        Object[] values = {id};

        return template.update(sql, values);
    }

    public List<Interactions> getInteractionsList() {
        return template.query("SELECT * FROM Interactions", new RowMapper<Interactions>() {
            public Interactions mapRow(ResultSet rs, int row) throws SQLException {
                Interactions i = new Interactions();
                i.setClients_ID(rs.getInt("Clients ID"));
                i.setDate_Of_Contact(rs.getDate("Date Of Contact"));
                i.setContact_First_Name(rs.getString("Contact First Name"));
                i.setContact_Last_Name(rs.getString("Contact Last Name"));
                i.setContact_Type(rs.getString("Contact Type"));
                i.setConversations(rs.getString("Conversations"));
                return i;
            }
        });
    }

    public Interactions getInteractionsById(int id) {
        String sql = "SELECT InteractionsID AS id, Clients_ID, Date_Of_Contact, Contact_First_Name, Contact_Last_Name, Contact_Type, Conversations FROM Interactions WHERE InteractionsID = ?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Interactions>(Interactions.class));
    }

    public List<Interactions> getInteractionsByPage(int start, int total) {
        String sql = "SELECT interactions.InteractionsID, interactions.Clients_ID, interactions.Date_Of_Contact, interactions.Contact_First_Name, interactions.Contact_Last_Name, interactions.Contact_Type, interactions.Conversations, clients.ClientsID, clients.Customer "
                + "FROM Interactions AS interactions "
                + "INNER JOIN Clients AS clients ON clients.ClientsID = interactions.Clients_ID "
                + "ORDER BY clients.Customer, interactions.Date_Of_Contact "
                + "LIMIT " + (start - 1) + "," + total;
        return template.query(sql, new RowMapper<Interactions>() {
            public Interactions mapRow(ResultSet rs, int row) throws SQLException {
                Interactions i = new Interactions();
                Clients clients = new Clients();
                i.setInteractionsID(rs.getInt(1));
                i.setClients_ID(rs.getInt(2));
                i.setDate_Of_Contact(rs.getDate(3));
                i.setContact_First_Name(rs.getString(4));
                i.setContact_Last_Name(rs.getString(5));
                i.setContact_Type(rs.getString(6));
                i.setConversations(rs.getString(7));
//                Clients clients = new Clients();
                clients.setClientsID(rs.getInt(8));
                clients.setCustomer(rs.getString(9));

                i.setClients(clients);
                return i;
            }
        });
    }

    public int getInteractionsCount() {
        String sql = "SELECT COUNT(InteractionsID) AS irowcount FROM Interactions";
        SqlRowSet rs = template.queryForRowSet(sql);

        if (rs.next()) {
            return rs.getInt("irowcount");
        }

        return 1;
    }

    public Map<Integer, String> getClientInteractMap() {
        Map<Integer, String> Clients = new LinkedHashMap<Integer, String>();
        String sql = "SELECT ClientsID, Customer FROM Clients ORDER BY Customer";

        SqlRowSet rs = template.queryForRowSet(sql);

        while (rs.next()) {
            Clients.put(rs.getInt(1), rs.getString(2));
        }

        return Clients;
    }
    
    public List<Interactions> getInteractionsLimit() {
        String sql = "SELECT * FROM Interactions ORDER BY InteractionsID DESC LIMIT 5";
        return template.query(sql, new RowMapper<Interactions>() {
            public Interactions mapRow(ResultSet rs, int row) throws SQLException {
                Interactions i = new Interactions();
                i.setInteractionsID(rs.getInt(1));
                i.setClients_ID(rs.getInt(2));
                i.setDate_Of_Contact(rs.getDate(3));
                i.setContact_First_Name(rs.getString(4));
                i.setContact_Last_Name(rs.getString(5));
                i.setContact_Type(rs.getString(6));
                i.setConversations(rs.getString(7));
                return i;
            }
        });
    }
    
    
//    public List<Interactions> getCustIntList() {
//        return template.query("SELECT interactions.Clients_ID, clients.ClientsID, clients.Customer "
//                + "FROM Interactions AS interactions "
//                + "INNER JOIN Clients AS clients ON clients.ClientsID = interactions.Clients_ID "
//                + "ORDER BY clients.Customer ", new RowMapper<Interactions>() {
//            public Interactions mapRow(ResultSet rs, int row) throws SQLException {
//                Interactions ci = new Interactions();
//                ci.setClients_ID(rs.getString("Customer"));
//                ci.setClients_ID(rs.getInt("Clients ID"));
////                i.setDate_Of_Contact(rs.getDate("Date Of Contact"));
////                i.setContact_First_Name(rs.getString("Contact First Name"));
////                i.setContact_Last_Name(rs.getString("Contact Last Name"));
////                i.setContact_Type(rs.getString("Contact Type"));
////                i.setConversations(rs.getString("Conversations"));
//                return ci;
//            }
//        });
//    }
    
    
}
