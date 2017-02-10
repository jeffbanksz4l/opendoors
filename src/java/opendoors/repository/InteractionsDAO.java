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
        String sql = "INSERT INTO Interactions (Clients_ID, Date_Of_Contact, Contact_Name, Contact_Type, Conversations) values (?, ?, ?, ?, ?)";

        Object[] values = {interactions.getClients_ID(), interactions.getDate_Of_Contact(), interactions.getContact_Name(), interactions.getContact_Type(), interactions.getConversations()};

        logger.info("Interactions DAO save values: " + values);

        return template.update(sql, values);
    }

    public int update(Interactions interactions) {
        String sql = "UPDATE Interactions SET Clients_ID = ?, Date_Of_Contact = ?, Contact_Name = ?, Contact_Type = ?, Conversations = ? WHERE InteractionsID = ?";

        Object[] values = {interactions.getClients_ID(), interactions.getDate_Of_Contact(), interactions.getContact_Name(), interactions.getContact_Type(), interactions.getConversations()};

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
                i.setDate_Of_Contact(rs.getString("Date Of Contact"));
                i.setContact_Name(rs.getString("Contact Name"));
                i.setContact_Type(rs.getString("Contact Type"));
                i.setConversations(rs.getString("Conversations"));
                return i;
            }
        });
    }

    public Interactions getInteractionsById(int id) {
        String sql = "SELECT InteractionsID AS id, Clients_ID, Date_Of_Contact, Contact_Name, Contact_Type, Conversations FROM Interactions WHERE InteractionsID = ?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Interactions>(Interactions.class));
    }

    public List<Interactions> getInteractionsByPage(int start, int total) {
        String sql = "SELECT interactions.Clients_ID, interactions.Date_Of_Contact, clients.ClientsID, clients.First_Name "
                + "FROM Interactions AS interactions "
                + "INNER JOIN Clients AS clients ON clients.ClientsID = interactions.Clients_ID "
                + "ORDER BY clients.First_Name, interactions.Date_Of_Contact "
                + "LIMIT " + (start - 1) + "," + total;
        return template.query(sql, new RowMapper<Interactions>() {
            public Interactions mapRow(ResultSet rs, int row) throws SQLException {
                Interactions i = new Interactions();
                i.setInteractionsID(rs.getInt(1));
                i.setDate_Of_Contact(rs.getString(2));

                Clients clients = new Clients();
                clients.setClientsID(rs.getInt(3));
                clients.setFirst_Name(rs.getString(4));

                i.setClients(clients);
                return i;
            }
        });
    }

    public int getInteractionsCount() {
        String sql = "SELECT COUNT(InteractionsID) AS rowcount FROM Interactions";
        SqlRowSet rs = template.queryForRowSet(sql);

        if (rs.next()) {
            return rs.getInt("rowcount");
        }

        return 1;
    }

    public Map<Integer, String> getClientsMap() {
        Map<Integer, String> clients = new LinkedHashMap<Integer, String>();
        String sql = "SELECT ClientsID, First_Name FROM Clients ORDER BY First_Name";

        SqlRowSet rs = template.queryForRowSet(sql);

        while (rs.next()) {
            clients.put(rs.getInt(1), rs.getString(2));
        }

        return clients;
    }
}
