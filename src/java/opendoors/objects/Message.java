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
         * Level ERROR
         */
        ERROR,
        /**
         * Level INFO
         */
        INFO;

        /**
         * Getting String
         *
         * @return
         */
        public String getString() {
            return this.name();
        }
    }

    /**
     * String Message
     */
    public Message() {

    }

    /**
     * Message
     *
     * @param type
     * @param message
     */
    public Message(Level type, String message) {
        this.type = type;
        this.message = message;
    }

    /**
     * Getting Message Type
     *
     * @return
     */
    public Level getType() {
        return type;
    }

    /**
     * Setting Message Type
     *
     * @param type
     */
    public void setType(Level type) {
        this.type = type;
    }

    /**
     * Getting Message
     *
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setting Message
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Sending data to a String
     *
     * @return
     */
    @Override
    public String toString() {
        return "Message{" + "type=" + type + ", message=" + message + '}';
    }
}
