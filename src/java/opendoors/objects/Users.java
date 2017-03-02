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
    private Boolean Enabled;
    private List<String> Roles;
    private Map<String, String> RolesMap;
//    private Map<String, String> EnabledMap;

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

    public Boolean getEnabled() {
        if (Enabled == null) {
            return false;
        }
//        if (!Enabled == true) {
//            return Enabled = false;
//        } else {
//            return Enabled;
//        }
        return Enabled;
    }

    public void setEnabled(boolean Enabled) {
//        if (!Enabled == true) {
//            this.Enabled = Enabled;
//        }
//        this.Enabled = Enabled;
        this.Enabled = Enabled;
    }

    public List<String> getRoles() {
        return Roles;
    }

    public void setRoles(List<String> Roles) {
        this.Roles = Roles;
    }

    public Map<String, String> getRolesMap() {

        RolesMap = new LinkedHashMap<String, String>();
        RolesMap.put("ROLE_ADMIN", "Admin");
        RolesMap.put("ROLE_USER", "User");

        return RolesMap;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
//        buffer.append("Username: " + this.Username + ";");
        buffer.append(this.Username.substring(0, 1).toUpperCase() + this.Username.substring(1).toLowerCase());
        buffer.append("Enabled: " + this.Enabled);
        return buffer.toString();
    }
}
