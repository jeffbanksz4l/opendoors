package opendoors.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.JdbcTemplate;

import opendoors.objects.Interactions;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author jeffb
 */
public class InteractionsDAO {

    JdbcTemplate template;

    /**
     *
     * @param template
     */
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    /**
     *
     * @param interactions
     * @return
     */
    public int save(Interactions interactions) {
        String sql = "INSERT INTO Interactions (Clients_ID, Date_Of_Contact, Contact_Name, Contact_Type, Conversations) values (?, ?, ?, ?, ?)";

        Object[] values = {interactions.getClients_ID(), interactions.getDate_Of_Contact(), interactions.getContact_Name(), interactions.getContact_Type(), interactions.getConversations()};

        return template.update(sql, values);
    }

    /**
     *
     * @param interactions
     * @return
     */
    public int update(Interactions interactions) {
        String sql = "UPDATE Interactions SET (Clients_ID = ?, Date_Of_Contact = ?, Contact_Name = ?, Contact_Type = ?, Conversations = ?) WHERE InteractionsID = ?";

        Object[] values = {interactions.getClients_ID(), interactions.getDate_Of_Contact(), interactions.getContact_Name(), interactions.getContact_Type(), interactions.getConversations()};

        return template.update(sql, values);
    }

    /**
     *
     * @param id
     * @return
     */
    public int delete(int id) {
        String sql = "DELETE FROM Interactions WHERE InteractionsID = ?";

        Object[] values = {id};

        return template.update(sql, values);
    }

    /**
     *
     * @return
     */
    public List<Interactions> getInteractionsList() {
        return template.query("SELECT * FROM Interactions", new RowMapper<Interactions>() {
            public Interactions mapRow(ResultSet rs, int row) throws SQLException {
                Interactions i = new Interactions();
                i.setClient_ID(rs.getInt("Clients ID"));
                i.setDate_Of_Contact(rs.getString("Date Of Contact"));
                i.setContact_Name(rs.getString("Contact Name"));
                i.setContact_Type(rs.getString("Contact Type"));
                i.setConversations(rs.getString("Conversations"));
                return i;
            }
        });
    }

    /**
     *
     * @param id
     * @return
     */
    public Interactions getInteractionsById(int id) {
        String sql = "SELECT InteractionsID AS id, (Clients_ID, Date_Of_Contact, Contact_Name, Contact_Type, Conversations) FROM Interactions WHERE InteractionsID = ?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Interactions>(Interactions.class));
    }

    /**
     *
     * @param start
     * @param total
     * @return
     */
    public List<Interactions> getInteractionsByPage(int start, int total) {
        String sql = "SELECT * FROM Interactions LIMIT " + (start - 1) + "," + total;
        return template.query(sql, new RowMapper<Interactions>() {
            public Interactions mapRow(ResultSet rs, int row) throws SQLException {
                Interactions i = new Interactions();
                i.setInteractionsID(rs.getInt(1));
                i.setClient_ID(rs.getInt(2));
                i.setDate_Of_Contact(rs.getString(3));
                i.setContact_Name(rs.getString(4));
                i.setContact_Type(rs.getString(5));
                i.setConversations(rs.getString(6));
                return i;
            }
        });
    }

    /**
     *
     * @return
     */
    public int getInteractionsCount() {
        String sql = "SELECT COUNT(InteractionsID) AS rowcount FROM Interactions";
        SqlRowSet rs = template.queryForRowSet(sql);

        if (rs.next()) {
            return rs.getInt("rowcount");
        }

        return 1;
    }
}
