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

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Username: " + this.Username + ";");
        buffer.append("Password: " + this.Password + ";");
        buffer.append("Enabled: " + this.Enabled + ";");
        return buffer.toString();
    }
}
