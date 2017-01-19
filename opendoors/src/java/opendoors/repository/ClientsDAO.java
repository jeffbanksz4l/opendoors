package opendoors.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.JdbcTemplate;

import opendoors.objects.Clients;

/**
 *
 * @author jeffb
 */
public class ClientsDAO {

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
     * @param clients
     * @return
     */
    public int save(Clients clients) {
        String sql = "INSERT INTO Clients (First_Name, Last_Name, Address_Line_1, Address_Line_2, Address_Line_3, City, State, Postal_Code, Email, Phone_1, Phone_2, Status) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Object[] values = {clients.getFirst_Name(), clients.getLast_Name(), clients.getAddress_Line_1(), clients.getAddress_Line_2(), clients.getAddress_Line_3(), clients.getCity(), clients.getState(), clients.getPostal_Code(), clients.getEmail(), clients.getPhone_1(), clients.getPhone_2(), clients.getStatus()};

        return template.update(sql, values);
    }

    /**
     *
     * @param clients
     * @return
     */
    public int update(Clients clients) {
        String sql = "UPDATE Clients SET (First_Name=?, Last_Name=?, Address_Line_1=?, Address_Line_2=?, Address_Line_3=?, City=?, State=?, Postal_Code=?, Email=?, Phone_1=?, Phone_2=?, Status=?) WHERE ClientsID = ?";

        Object[] values = {clients.getFirst_Name(), clients.getLast_Name(), clients.getAddress_Line_1(), clients.getAddress_Line_2(), clients.getAddress_Line_3(), clients.getCity(), clients.getState(), clients.getPostal_Code(), clients.getEmail(), clients.getPhone_1(), clients.getPhone_2(), clients.getStatus(), clients.getID()};

        return template.update(sql, values);
    }

    /**
     *
     * @param id
     * @return
     */
    public int delete(int id) {
        String sql = "DELETE FROM Clients WHERE ClientsID = ?";

        Object[] values = {id};

        return template.update(sql, values);
    }

    /**
     *
     * @return
     */
    public List<Clients> getClientsList() {
        return template.query("SELECT * FROM Clients", new RowMapper<Clients>() {
            public Clients mapRow(ResultSet rs, int row) throws SQLException {
                Clients c = new Clients();
                c.setID(rs.getInt("ClientsID"));
                c.setFirst_Name(rs.getString("First_Name"));
                c.setLast_Name(rs.getString("Last_Name"));
                c.setAddress_Line_1(rs.getString("Address_Line_1"));
                c.setAddress_Line_2(rs.getString("Address_Line_2"));
                c.setAddress_Line_3(rs.getString("Address_Line_3"));
                c.setCity(rs.getString("City"));
                c.setState(rs.getString("State"));
                c.setPostal_Code(rs.getString("Postal_Code"));
                c.setEmail(rs.getString("Email"));
                c.setPhone_1(rs.getString("Phone_1"));
                c.setPhone_2(rs.getString("Phone_2"));
                c.setStatus(rs.getString("Status"));
                return c;
            }
        });
    }

    /**
     *
     * @param id
     * @return
     */
    public Clients getClientsById(int id) {
        String sql = "SELECT ClientsID AS id, (First_Name, Last_Name, Address_Line_1, Address_Line_2, Address_Line_3, City, State, Postal_Code, Email, Phone_1, Phone_2, Status) FROM Clients WHERE ClientsID = ?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Clients>(Clients.class));
    }
}
