package opendoors.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.JdbcTemplate;

import opendoors.objects.Clients;
import java.util.logging.Logger;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author jeffb
 */
public class ClientsDAO {

    JdbcTemplate template;

    public static final Logger logger = Logger.getLogger(ClientsDAO.class.getName());

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Clients clients) {
        String sql = "INSERT INTO Clients (Customer,  Address_Line_1, Address_Line_2, City, State, Postal_Code, Email, Phone_1, Phone_2, Status) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Object[] values = {clients.getCustomer(), clients.getAddress_Line_1(), clients.getAddress_Line_2(), clients.getCity(), clients.getState(), clients.getPostal_Code(), clients.getEmail(), clients.getPhone_1(), clients.getPhone_2(), clients.getStatus()};

        return template.update(sql, values);
    }

    public int update(Clients clients) {
        String sql = "UPDATE Clients SET Customer = ?, Address_Line_1 = ?, Address_Line_2 = ?, City = ?, State = ?, Postal_Code = ?, Email = ?, Phone_1 = ?, Phone_2 = ?, Status = ? WHERE ClientsID = ?";

        Object[] values = {clients.getCustomer(), clients.getAddress_Line_1(), clients.getAddress_Line_2(), clients.getCity(), clients.getState(), clients.getPostal_Code(), clients.getEmail(), clients.getPhone_1(), clients.getPhone_2(), clients.getStatus(), clients.getClientsID()};

        return template.update(sql, values);
    }

    public int convert(Clients clients) {
        String sql = "UPDATE Clients SET Status = Inactive WHERE ClientsID = ?";

        Object[] values = {clients.getStatus(), clients.getClientsID()};

        return template.update(sql, values);
    }

    public int delete(int id) {
        String sql = "DELETE FROM Clients WHERE ClientsID = ?";

        Object[] values = {id};

        return template.update(sql, values);
    }

    public List<Clients> getClientsList() {
        return template.query("SELECT * FROM Clients", new RowMapper<Clients>() {
            public Clients mapRow(ResultSet rs, int row) throws SQLException {
                Clients c = new Clients();
                c.setClientsID(rs.getInt("Clients ID"));
                c.setCustomer(rs.getString("Customer"));
                c.setAddress_Line_1(rs.getString("Address Line 1"));
                c.setAddress_Line_2(rs.getString("Address Line 2"));
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

    public Clients getClientsById(int id) {
        logger.info("Get Clients by ID: " + id);
        String sql = "SELECT ClientsID, Customer, Address_Line_1, Address_Line_2, City, State, Postal_Code, Email, Phone_1, Phone_2, Status FROM Clients WHERE ClientsID = ?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Clients>(Clients.class));
    }

    public List<Clients> getClientsByPage(int start, int total) {
        String sql = "SELECT * FROM Clients LIMIT " + (start - 1) + "," + total;
        return template.query(sql, new RowMapper<Clients>() {
            public Clients mapRow(ResultSet rs, int row) throws SQLException {
                Clients c = new Clients();
                c.setClientsID(rs.getInt(1));
                c.setCustomer(rs.getString(2));
                c.setAddress_Line_1(rs.getString(3));
                c.setAddress_Line_2(rs.getString(4));
                c.setCity(rs.getString(5));
                c.setState(rs.getString(6));
                c.setPostal_Code(rs.getString(7));
                c.setEmail(rs.getString(8));
                c.setPhone_1(rs.getString(9));
                c.setPhone_2(rs.getString(10));
                c.setStatus(rs.getString(11));
                return c;
            }
        });
    }

    public int getClientsCount() {
        String sql = "SELECT COUNT(ClientsID) AS rowcount FROM Clients";
        SqlRowSet rs = template.queryForRowSet(sql);

        if (rs.next()) {
            return rs.getInt("rowcount");
        }

        return 1;
    }
}
