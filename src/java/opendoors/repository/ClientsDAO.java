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

    /**
     *
     */
    public static final Logger logger = Logger.getLogger(ClientsDAO.class.getName());

    /**
     * Setting the JDBC Template
     *
     * @param template
     */
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    /**
     * SQL Query for Saving Clients
     *
     * @param clients
     * @return
     */
    public int save(Clients clients) {
        String sql = "INSERT INTO Clients (Customer,  Address_Line_1, Address_Line_2, "
                + "City, State, Postal_Code, Email, Phone_1, Phone_2, Status) "
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Object[] values = {clients.getCustomer(), clients.getAddress_Line_1(), clients.getAddress_Line_2(), clients.getCity(), clients.getState(), clients.getPostal_Code(), clients.getEmail(), clients.getPhone_1(), clients.getPhone_2(), clients.getStatus()};

        return template.update(sql, values);
    }

    /**
     * SQL Query for Updating Clients
     *
     * @param clients
     * @return
     */
    public int update(Clients clients) {
        String sql = "UPDATE Clients SET Customer = ?, Address_Line_1 = ?, Address_Line_2 = ?, "
                + "City = ?, State = ?, Postal_Code = ?, Email = ?, Phone_1 = ?, Phone_2 = ?, Status = ? "
                + "WHERE ClientsID = ?";

        Object[] values = {clients.getCustomer(), clients.getAddress_Line_1(), clients.getAddress_Line_2(), clients.getCity(), clients.getState(), clients.getPostal_Code(), clients.getEmail(), clients.getPhone_1(), clients.getPhone_2(), clients.getStatus(), clients.getClientsID()};

        return template.update(sql, values);
    }

    /**
     * SQL Query for Converting the Status of Clients
     *
     * @param id
     * @return
     */
    public int convert(int id) {
        String sql = "UPDATE Clients SET Status = 'Inactive' WHERE ClientsID = ?";

        Object[] values = {id};

        return template.update(sql, values);
    }

    /**
     * SQL Query for Mapping the List of Clients
     *
     * @return
     */
    public List<Clients> getClientsList() {
        return template.query("SELECT * FROM Clients WHERE Status = 'Client' ORDER BY Customer", new RowMapper<Clients>() {
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

    /**
     * SQL Query for Mapping the List of Prospects
     *
     * @return
     */
    public List<Clients> getProspectsList() {
        return template.query("SELECT * FROM Clients WHERE Status = 'Prospect' ORDER BY Customer", new RowMapper<Clients>() {
            public Clients mapRow(ResultSet rs, int row) throws SQLException {
                Clients p = new Clients();
                p.setClientsID(rs.getInt("Clients ID"));
                p.setCustomer(rs.getString("Customer"));
                p.setAddress_Line_1(rs.getString("Address Line 1"));
                p.setAddress_Line_2(rs.getString("Address Line 2"));
                p.setCity(rs.getString("City"));
                p.setState(rs.getString("State"));
                p.setPostal_Code(rs.getString("Postal Code"));
                p.setEmail(rs.getString("Email"));
                p.setPhone_1(rs.getString("Phone 1"));
                p.setPhone_2(rs.getString("Phone 2"));
                p.setStatus(rs.getString("Status"));
                return p;
            }
        });
    }

    /**
     * SQL Query for Mapping the List of Inactives
     *
     * @return
     */
    public List<Clients> getInactivesList() {
        return template.query("SELECT * FROM Clients WHERE Status = 'Inactive' ORDER BY Customer", new RowMapper<Clients>() {
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

    /**
     * SQL Query for Mapping the Clients by ID
     *
     * @param id
     * @return
     */
    public Clients getClientsById(int id) {
        logger.info("Get Clients by ID: " + id);
        String sql = "SELECT ClientsID, Customer, Address_Line_1, Address_Line_2, "
                + "City, State, Postal_Code, Email, Phone_1, Phone_2, Status "
                + "FROM Clients "
                + "WHERE ClientsID = ?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Clients>(Clients.class));
    }

    /**
     * SQL Query for Mapping the List of Clients for pagination
     *
     * @param start
     * @param total
     * @return
     */
    public List<Clients> getClientsByPage(int start, int total) {
        String sql = "SELECT * FROM Clients WHERE Status = 'Client' ORDER BY Customer LIMIT " + (start - 1) + "," + total;
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

    /**
     * SQL Query for Mapping the List of Prospects for pagination
     *
     * @param start
     * @param total
     * @return
     */
    public List<Clients> getProspectsByPage(int start, int total) {
        String sql = "SELECT * FROM Clients WHERE Status = 'Prospect' ORDER BY Customer LIMIT " + (start - 1) + "," + total;
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

    /**
     * SQL Query for Mapping the List of Inactives for pagination
     *
     * @param start
     * @param total
     * @return
     */
    public List<Clients> getInactivesByPage(int start, int total) {
        String sql = "SELECT * FROM Clients WHERE Status = 'Inactive' ORDER BY Customer LIMIT " + (start - 1) + "," + total;
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

    /**
     * SQL query for Getting the Clients Count
     *
     * @return
     */
    public int getClientsCount() {
        String sql = "SELECT COUNT(ClientsID) AS crowcount FROM Clients WHERE Status = 'Client'";
        SqlRowSet rs = template.queryForRowSet(sql);

        if (rs.next()) {
            return rs.getInt("crowcount");
        }

        return 1;
    }

    /**
     * SQL query for Getting the Prospects Count
     *
     * @return
     */
    public int getProspectsCount() {
        String sql = "SELECT COUNT(ClientsID) AS prowcount FROM Clients WHERE Status = 'Prospect'";
        SqlRowSet rs = template.queryForRowSet(sql);

        if (rs.next()) {
            return rs.getInt("prowcount");
        }

        return 1;
    }

    /**
     * SQL query for Getting the Inactives Count
     *
     * @return
     */
    public int getInactivesCount() {
        String sql = "SELECT COUNT(ClientsID) AS xrowcount FROM Clients WHERE Status = 'Inactive'";
        SqlRowSet rs = template.queryForRowSet(sql);

        if (rs.next()) {
            return rs.getInt("xrowcount");
        }

        return 1;
    }
    /**
     * SQL query for Listing the Clients for Dashboard
     *
     * @return
     */
    public List<Clients> getClientsLimit() {
        String sql = "SELECT * FROM Clients WHERE Status = 'Client' ORDER BY ClientsID DESC LIMIT 5";
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

    /**
     * SQL query for Listing the Prospects for Dashboard
     *
     * @return
     */
    public List<Clients> getProspectsLimit() {
        String sql = "SELECT * FROM Clients WHERE Status = 'Prospect' ORDER BY ClientsID DESC LIMIT 5";
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
}
