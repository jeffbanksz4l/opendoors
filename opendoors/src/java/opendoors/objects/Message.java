package opendoors.objects;

import java.io.Serializable;

/**
 *
 * @author jeffb
 */
public class Message implements Serializable {

    private Level type;
    private String message;

    /**
     *
     */
    public enum Level {

        /**
         *
         */
        ERROR,

        /**
         *
         */
        INFO;

        /**
         *
         * @return
         */
        public String getString() {
            return this.name();
        }
    }

    /**
     *
     */
    public Message() {

    }

    /**
     *
     * @param type
     * @param message
     */
    public Message(Level type, String message) {
        this.type = type;
        this.message = message;
    }

    /**
     *
     * @return
     */
    public Level getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(Level type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Message{" + "type=" + type + ", message=" + message + '}';
    }
}
