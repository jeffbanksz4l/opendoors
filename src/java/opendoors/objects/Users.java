package opendoors.objects;

import java.io.Serializable;

/**
 *
 * @author jeffb
 */
public class Users implements Serializable {

    private String Username;
    private String Password;
    private String Enabled;

    /**
     *
     * @return
     */
    public String getUsername() {
        return Username;
    }

    /**
     *
     * @param Username
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return Password;
    }

    /**
     *
     * @param Password
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     *
     * @return
     */
    public String getEnabled() {
        return Enabled;
    }

    /**
     *
     * @param Enabled
     */
    public void setEnabled(String Enabled) {
        this.Enabled = Enabled;
    }

    /**
     *
     * @return
     */
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Username: " + this.Username + ";");
        buffer.append("Password: " + this.Password + ";");
        buffer.append("Enabled: " + this.Enabled + ";");
        return buffer.toString();
    }
}
