package opendoors.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.JdbcTemplate;

import opendoors.objects.Clients;
import org.springframework.jdbc.support.rowset.SqlRowSet;

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
        String sql = "UPDATE Clients SET (First_Name = ?, Last_Name = ?, Address_Line_1 = ?, Address_Line_2 = ?, Address_Line_3 = ?, City = ?, State = ?, Postal_Code = ?, Email = ?, Phone_1 = ?, Phone_2 = ?, Status = ?) WHERE ClientsID = ?";

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
                c.setID(rs.getInt("Clients ID"));
                c.setFirst_Name(rs.getString("First Name"));
                c.setLast_Name(rs.getString("Last Name"));
                c.setAddress_Line_1(rs.getString("Address Line 1"));
                c.setAddress_Line_2(rs.getString("Address Line 2"));
                c.setAddress_Line_3(rs.getString("Address Line 3"));
                c.setCity(rs.getString("City"));
                c.setState(rs.getString("State"));
                c.setPostal_Code(rs.getString("Postal Code"));
                c.setEmail(rs.getString("Email"));
                c.setPhone_1(rs.getString("Phone 1"));
                c.setPhone_2(rs.getString("Phone 2"));
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

    /**
     *
     * @param start
     * @param total
     * @return
     */
    public List<Clients> getClientsByPage(int start, int total) {
        String sql = "SELECT * FROM Clients LIMIT " + (start - 1) + "," + total;
        return template.query(sql, new RowMapper<Clients>() {
            public Clients mapRow(ResultSet rs, int row) throws SQLException {
                Clients c = new Clients();
                c.setID(rs.getInt(1));
                c.setFirst_Name(rs.getString(2));
                c.setLast_Name(rs.getString(3));
                c.setAddress_Line_1(rs.getString(4));
                c.setAddress_Line_2(rs.getString(5));
                c.setAddress_Line_3(rs.getString(6));
                c.setCity(rs.getString(7));
                c.setState(rs.getString(8));
                c.setPostal_Code(rs.getString(9));
                c.setEmail(rs.getString(10));
                c.setPhone_1(rs.getString(11));
                c.setPhone_2(rs.getString(12));
                c.setStatus(rs.getString(13));
                return c;
            }
        });
    }

    /**
     *
     * @return
     */
    public int getClientsCount() {
        String sql = "SELECT COUNT(ClientsID) AS rowcount FROM Clients";
        SqlRowSet rs = template.queryForRowSet(sql);

        if (rs.next()) {
            return rs.getInt("rowcount");
        }

        return 1;
    }
}
