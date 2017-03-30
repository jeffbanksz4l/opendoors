package opendoors.objects;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

    /**
     * Getting Username
     *
     * @return
     */
    public String getUsername() {
        return Username;
    }

    /**
     * Setting Username
     *
     * @param Username
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }

    /**
     * Getting Password
     *
     * @return
     */
    public String getPassword() {
        return Password;
    }

    /**
     * Setting Password
     *
     * @param Password
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * Getting Enabled
     *
     * @return
     */
    public Boolean getEnabled() {
        if (Enabled == null) {
            return false;
        }
        return Enabled;
    }

    /**
     * Setting Enabled
     *
     * @param Enabled
     */
    public void setEnabled(boolean Enabled) {
        this.Enabled = Enabled;
    }

    /**
     * Getting User Roles
     *
     * @return
     */
    public List<String> getRoles() {
        return Roles;
    }

    /**
     * Setting User Roles
     *
     * @param Roles
     */
    public void setRoles(List<String> Roles) {
        this.Roles = Roles;
    }

    /**
     * Getting a Map of the User Roles
     *
     * @return
     */
    public Map<String, String> getRolesMap() {

        RolesMap = new LinkedHashMap<String, String>();
        RolesMap.put("ROLE_ADMIN", "Admin");
        RolesMap.put("ROLE_USER", "User");

        return RolesMap;
    }

    /**
     * Sending data to a String
     *
     * @return
     */
    public String toString() {
        StringBuffer buffer = new StringBuffer();
//        buffer.append("Username: " + this.Username + ";");
        buffer.append(this.Username.substring(0, 1).toUpperCase() + this.Username.substring(1).toLowerCase());
        buffer.append("Enabled: " + this.Enabled);
        return buffer.toString();
    }
}
