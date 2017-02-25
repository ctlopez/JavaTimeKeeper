package timekeeper.model.person;

/**
 * This is an exception for the Person class if the security role is not null.
 * @author Christian Lopez
 */
public class CurrentSecurityRoleException extends Exception {

    /**
     * The empty constructor
     */
    public CurrentSecurityRoleException() {
        
    }
    
    /**
     * The constructor with an error message
     * @param message The message to be passed through to the user
     */
    public CurrentSecurityRoleException(String message) {
        super(message);
    }
}
