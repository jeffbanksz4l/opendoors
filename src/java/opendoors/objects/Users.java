package opendoors.objects;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jeffb
 */
public class Users implements Serializable {

    private String Username;
    private String Password;
    private String Enabled;
    private List<String> roles;
    private Map<String, String> rolemap;

    public Users() {
        this.rolemap = new LinkedHashMap<String, String>();
        this.rolemap.put("ROLE_ADMIN", "Admin");
        this.rolemap.put("ROLE_USER", "User");
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEnabled() {
        return Enabled;
    }

    public void setEnabled(String Enabled) {
        this.Enabled = Enabled;
    }
    
    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Map<String, String> getRolemap() {
        return this.rolemap;
    }

    public void setRolemap(Map<String, String> rolemap) {
        this.rolemap = rolemap;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Username: " + this.Username + ";");
        buffer.append("Password: " + this.Password + ";");
        buffer.append("Enabled: " + this.Enabled);
        return buffer.toString();
    }
}
