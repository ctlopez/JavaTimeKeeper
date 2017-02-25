package timekeeper.model.person;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class is a data accessor for the Person class.
 *
 * @author Christian Lopez
 */
public class PersonDAO {

    /**
     * The separator for the files
     */
    private final char separator = '|';

    /**
     * The filename for the file
     */
    private final String fileName = "timeKeeper_project_sample_data\\person_data.txt";

    /**
     * @return the separator
     */
    public char getSeparator() {
        return separator;
    }

    /**
     * @param separator the separator to set
     */
//    public void setSeparator(char separator) {
//        this.separator = separator;
//    }
    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
//    public void setFileName(String fileName) {
//        this.fileName = fileName;
//    }
    /**
     * This searches through the file to find the given id. If found, it returns
     * the person with the id. If not, returns null.
     *
     * @param personID The id to look for in the file
     * @return The person with the id, or null if not found.
     * @throws FileNotFoundException
     * @throws CurrentSecurityRoleException
     */
    public Person getPerson(int personID) throws FileNotFoundException,
            CurrentSecurityRoleException, IOException {
//        BufferedReader in = new BufferedReader(new FileReader(this.fileName));
//        String line;
//        while ((line = in.readLine()) != null) {
//            System.out.println(line);
//            String[] parts = line.split("[" +
//                    Character.toString(this.separator) + "]");
//            String ID = parts[0];
//            String fName = parts[1];
//            String lName = parts[2];
//            String pass = parts[3];
//            String role = parts[4];
//            if (ID.equals(personID)) {
//                Person newPerson = new Person();
//                newPerson.setPersonID(Integer.parseInt(ID));
//                newPerson.setFirstName(fName);
//                newPerson.setLastName(lName);
//                newPerson.setPassword(pass);
//                newPerson.setSecurityRole(role);
//                in.close();
//                return newPerson;
//            }
//
//        }
//        in.close();
//        
//        return null;
        return this.getPerson("" + personID);
    }

    /**
     * This searches through the file to find the given id. If found, it returns
     * the person with the id. If not, returns null.
     *
     * @param personID The id to look for in the file
     * @return The person with the id, or null if not found.
     * @throws FileNotFoundException
     * @throws CurrentSecurityRoleException
     */
    public Person getPerson(String personID) throws FileNotFoundException,
            CurrentSecurityRoleException,
            IOException {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(this.fileName));
            String line;
            while ((line = in.readLine()) != null) {

                String[] parts = line.split("["
                        + Character.toString(this.separator) + "]");
                String ID = parts[0];
                String fName = parts[1];
                String lName = parts[2];
                String pass = parts[3];
                String role = parts[4];
                if (ID.equals(personID)) {
                    Person newPerson = new Person();
                    newPerson.setPersonID(Integer.parseInt(ID));
                    newPerson.setFirstName(fName);
                    newPerson.setLastName(lName);
                    newPerson.setPassword(pass);
                    newPerson.setSecurityRole(role);
                    in.close();
                    return newPerson;
                }

            }
        } catch (FileNotFoundException fnf) {
            throw new FileNotFoundException("Unable to find file: " + fileName);
        } catch (CurrentSecurityRoleException csr) {
            throw new CurrentSecurityRoleException("Can not assign a new role to a person.");
        } catch (IOException ex) {
            throw new IOException("Unable to read file: " + fileName);
        } finally {
            in.close();
        }
        return null;
    }

}
