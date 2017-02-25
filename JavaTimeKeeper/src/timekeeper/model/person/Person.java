package timekeeper.model.person;

/**
 * This class represents a person to keep track of time worked on projects.
 * @author Christian Lopez
 */
public class Person {

    /**
     * The person's ID.
     */
    private int personID;
    
    /**
     * The person's first name.
     */
    private String firstName;
    
    /**
     * The person's last name.
     */
    private String lastName;
    
    /**
     * The person's password.
     */
    private String password;
    
    /**
     * The person's security role.
     */
    private String securityRole;

    /**
     * @return the personID
     */
    public int getPersonID() {
        return personID;
    }

    /**
     * @param personID the personID to set
     */
    public void setPersonID(int personID) {
        this.personID = personID;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        if (firstName.length() < 1) {
            throw new IllegalArgumentException("You must have at least" +
                    " one character for a first name.");
        } else if (firstName.length() > 126) {
            throw new IllegalArgumentException("You cannot have more than " +
                    "126 characters for a first name.");
        }
        for (int i = 0; i < firstName.length(); i++) {
            if ((firstName.charAt(i) < 'A' || firstName.charAt(i) > 'z') &&
                    firstName.charAt(i) != '\'' && firstName.charAt(i) != ' '
                    && firstName.charAt(i) != '-') {
                throw new IllegalArgumentException("The first name can " +
                        "only contain letters, spaces, apostrophes, and " +
                        "dashes.");
            }
        }
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        if (lastName.length() < 0) {//How is this even possible?
            throw new IllegalArgumentException("You must have at least" +
                    " zero characters for a last name.");
        } else if (lastName.length() > 125) {
            throw new IllegalArgumentException("You cannot have more than " +
                    "125 characters for a first name.");
        }
        for (int i = 0; i < lastName.length(); i++) {
            if ((lastName.charAt(i) < 'A' || lastName.charAt(i) > 'z') &&
                    lastName.charAt(i) != '\'' && lastName.charAt(i) != ' '
                    && lastName.charAt(i) != '-') {
                throw new IllegalArgumentException("The first name can " +
                        "only contain letters, spaces, apostrophes, and " +
                        "dashes.");
            }
        }
        this.lastName = lastName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        if (password.length() < 8) {
            throw new IllegalArgumentException("You must have at least" +
                    " eight characters for a last name.");
        } else if (password.length() > 125) {
            throw new IllegalArgumentException("You cannot have more than " +
                    "125 characters for a first name.");
        }
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == ' ') {
                throw new IllegalArgumentException("You cannot have a space " +
                "in your password.");
            }
        }
        this.password = password;
    }

    /**
     * @return the securityRole
     */
    public String getSecurityRole() {
        return securityRole;
    }

    /**
     * @param securityRole the securityRole to set
     * @throws lopez.person.CurrentSecurityRoleException
     */
    public void setSecurityRole(String securityRole) throws 
            CurrentSecurityRoleException {
        if (this.securityRole != null) {
            throw new CurrentSecurityRoleException ("This person already " +
                    "has a security role.");
        } else {
            this.securityRole = securityRole;
        }
    }
}
