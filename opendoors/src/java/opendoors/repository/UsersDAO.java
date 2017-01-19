package opendoors.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.JdbcTemplate;

import opendoors.objects.Users;

/**
 *
 * @author jeffb
 */
public class UsersDAO {

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
     * @param users
     * @return
     */
    public int save(Users users) {
        String sql = "INSERT INTO Clients (Username, Password, Enabled) values (?, md5(?), ?)";

        Object[] values = {users.getUsername(), users.getPassword(), users.getEnabled()};

        return template.update(sql, values);
    }

    /**
     *
     * @param users
     * @return
     */
    public int update(Users users) {
        String sql = "UPDATE Clients SET (Username=?, Password=?, Enabled=?) WHERE Username = ?";

        Object[] values = {users.getUsername(), users.getPassword(), users.getEnabled()};

        return template.update(sql, values);
    }

    /**
     *
     * @param id
     * @return
     */
    public int delete(int id) {
        String sql = "DELETE FROM Users WHERE Username = ?";

        Object[] values = {id};

        return template.update(sql, values);
    }

    /**
     *
     * @return
     */
    public List<Users> getUsersList() {
        return template.query("SELECT * FROM Users", new RowMapper<Users>() {
            public Users mapRow(ResultSet rs, int row) throws SQLException {
                Users c = new Users();
                c.setUsername(rs.getString("Username"));
                c.setPassword(rs.getString("Password"));
                c.setEnabled(rs.getString("Enabled"));
                return c;
            }
        });
    }

    /**
     *
     * @param id
     * @return
     */
    public Users getUsersById(int id) {
        String sql = "SELECT Username AS id, (Username, Password, Enabled) FROM Users WHERE Username = ?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Users>(Users.class));
    }
}
