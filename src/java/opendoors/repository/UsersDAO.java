package opendoors.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.JdbcTemplate;

import opendoors.objects.Users;
import opendoors.objects.Clients;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author jeffb
 */
public class UsersDAO {

    JdbcTemplate template;

    private static final Logger logger = Logger.getLogger(UsersDAO.class.getName());

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Users users) {
        String sql = "INSERT INTO Users (Username, Password, Enabled) values (?, md5(?), ?)";

        Object[] values = {users.getUsername(), users.getPassword(), users.getEnabled()};

        logger.info("Users DAO save values: " + values);

        int r = template.update(sql, values);

        sql = "INSERT INTO User_Roles (Username, Role) VALUES (?, ?)";

        for (String role : users.getRoles()) {
            Object[] role_values = {users.getUsername(), role};

            logger.info("Users DAO add role: " + values);

            template.update(sql, role_values);
        }

        return r;
    }

    public int update(Users users) {
        String sql = "UPDATE Users SET (Username = ?, Password = md5(?), Enabled = ?) WHERE Username = ?";

        Object[] values = {users.getUsername(), users.getPassword(), users.getEnabled()};

        logger.info("Users DAO save values: " + values);

        int r = template.update(sql, values);

        sql = "UPDATE INTO User_Roles (Username, Role) VALUES (?, ?)";

        for (String role : users.getRoles()) {
            Object[] role_values = {users.getUsername(), role};

            logger.info("Users DAO update role: " + values);

            return template.update(sql, values);
        }

        return r;
    }

//    public int delete(int id) {
//        String sql = "DELETE FROM Users WHERE Username = ?";
//
//        Object[] values = {id};
//
//        return template.update(sql, values);
//    }
    public List<Users> getUsersList() {
        return template.query("SELECT * FROM Users", new RowMapper<Users>() {
            public Users mapRow(ResultSet rs, int row) throws SQLException {
                Users u = new Users();
                u.setUsername(rs.getString("Username"));
                u.setPassword(rs.getString("Password"));
                u.setEnabled(rs.getBoolean("Enabled"));
//                u.setEnabled(rs.getString("Enabled"));
                return u;
            }
        });
    }

    public Users getUsersByName(String name) {
        logger.info("Get Users by Name: " + name);
        String sql = "SELECT Username, Password, Enabled FROM Users WHERE Username = ?";
        return template.queryForObject(sql, new Object[]{name}, new BeanPropertyRowMapper<Users>(Users.class));
    }

    public List<Users> getUsersByPage(int start, int total) {
        String sql = "SELECT * FROM Users LIMIT " + (start - 1) + "," + total;
        return template.query(sql, new RowMapper<Users>() {
            public Users mapRow(ResultSet rs, int row) throws SQLException {
                Users u = new Users();
                u.setUsername(rs.getString(1));
//                u.setPassword(rs.getString(2));
                u.setEnabled(rs.getBoolean(3));
//                u.setEnabled(rs.getString(3));
                return u;
            }
        });
    }

    public int getUsersCount() {
        String sql = "SELECT COUNT(Username) AS rowcount FROM Users";
        SqlRowSet rs = template.queryForRowSet(sql);

        if (rs.next()) {
            return rs.getInt("rowcount");
        }

        return 1;
    }

//    public Map<Integer,String> getClientMap() {
//        Map<Integer,String> client = new LinkedHashMap<Integer,String>();
//        String sql = "SELECT ClientsID, First_Name FROM Clients ORDER BY First_Name";
//        
//        SqlRowSet rs = template.queryForRowSet(sql);
//        
//        while(rs.next()){
//            client.put(rs.getInt(1), rs.getString(2));
//        }
//        
//        return client;
//    }
}
