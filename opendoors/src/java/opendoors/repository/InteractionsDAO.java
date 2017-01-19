package opendoors.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.JdbcTemplate;

import opendoors.objects.Interactions;

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
        String sql = "UPDATE Interactions SET (Clients_ID=?, Date_Of_Contact=?, Contact_Name=?, Contact_Type=?, Conversations=?) WHERE InteractionsID = ?";

        Object[] values = {interactions};

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
                Interactions c = new Interactions();
                c.setClient_ID(rs.getInt("Clients_ID"));
                c.setDate_Of_Contact(rs.getString("Date_Of_Contact"));
                c.setContact_Name(rs.getString("Contact_Name"));
                c.setContact_Type(rs.getString("Contact_Type"));
                c.setConversations(rs.getString("Conversations"));
                return c;
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
}
