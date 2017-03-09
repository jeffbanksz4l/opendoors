package opendoors.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.JdbcTemplate;

import opendoors.objects.Users;
import java.util.logging.Logger;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author jeffb
 */
public class UsersDAO {

    JdbcTemplate template;

    private static final Logger logger = Logger.getLogger(UsersDAO.class.getName());

    /**
     * Setting the JDBC Template
     *
     * @param template
     */
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    /**
     * SQL Query for Saving Users
     *
     * @param users
     * @return
     */
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

    /**
     * SQL Query for Updating Users
     *
     * @param users
     * @return
     */
    public int update(Users users) {
        String sql = "UPDATE Users SET Password = md5(?), Enabled = ? WHERE Username = ?";

        Object[] values = {users.getPassword(), users.getEnabled(), users.getUsername()};

        logger.info("Users DAO save values: " + values);

        int r = template.update(sql, values);

        sql = "DELETE FROM User_Roles WHERE Username = ?";

        Object[] deleteValues = {users.getUsername()};

        logger.info("Users DAO delete values: " + deleteValues);

        int d = template.update(sql, deleteValues);

        sql = "INSERT INTO User_Roles (Username, Role) VALUES (?, ?)";

        logger.info("What is being passed in: " + values);

        for (String role : users.getRoles()) {
            Object[] role_values = {users.getUsername(), role};

            logger.info("Users DAO add role: " + values);

            template.update(sql, role_values);
        }

        return r;
    }

    /**
     * SQL Query for Mapping the List of Users
     *
     * @return
     */
    public List<Users> getUsersList() {
        return template.query("SELECT * FROM Users", new RowMapper<Users>() {
            public Users mapRow(ResultSet rs, int row) throws SQLException {
                Users u = new Users();
                u.setUsername(rs.getString("Username"));
                u.setPassword(rs.getString("Password"));
                u.setEnabled(rs.getBoolean("Enabled"));
                return u;
            }
        });
    }

    /**
     * SQL Query for Mapping the Users by Name
     *
     * @param name
     * @return
     */
    public Users getUsersByName(String name) {
        logger.info("Get Users by Name: " + name);
        String sql = "SELECT Username, Password, Enabled FROM Users WHERE Username = ?";
        return template.queryForObject(sql, new Object[]{name}, new BeanPropertyRowMapper<Users>(Users.class));
    }

    /**
     * SQL Query for Mapping the List of Users for pagination
     *
     * @param start
     * @param total
     * @return
     */
    public List<Users> getUsersByPage(int start, int total) {
        String sql = "SELECT * FROM Users LIMIT " + (start - 1) + "," + total;
        return template.query(sql, new RowMapper<Users>() {
            public Users mapRow(ResultSet rs, int row) throws SQLException {
                Users u = new Users();
                u.setUsername(rs.getString(1));
//                u.setPassword(rs.getString(2));
                u.setEnabled(rs.getBoolean(3));
                return u;
            }
        });
    }

    /**
     * SQL query for Getting the User Count
     *
     * @return
     */
    public int getUsersCount() {
        String sql = "SELECT COUNT(Username) AS urowcount FROM Users";
        SqlRowSet rs = template.queryForRowSet(sql);

        if (rs.next()) {
            return rs.getInt("urowcount");
        }

        return 1;
    }
}
