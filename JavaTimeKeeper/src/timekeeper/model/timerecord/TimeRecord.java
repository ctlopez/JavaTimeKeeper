package timekeeper.model.timerecord;

import java.time.LocalDateTime;

/**
 * This class represents a time record for keeping track of time worked on 
 * projects.
 * @author Christian Lopez
 */
public class TimeRecord {

    /**
     * The project ID
     */
    private int projectID;
    
    /**
     * The person ID
     */
    private int personID;
    
    /**
     * The character denoting start or stop
     */
    private char startOrStop;
    
    /**
     * The timestamp of the entry
     */
    private LocalDateTime dateAndTime;

    /**
     * @return the projectID
     */
    public int getProjectID() {
        return projectID;
    }

    /**
     * @param projectID the projectID to set
     */
    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

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
     * @return the startOrStop
     */
    public char getStartOrStop() {
        return startOrStop;
    }

    /**
     * @param startOrStop the startOrStop to set
     */
    public void setStartOrStop(char startOrStop) {
        this.startOrStop = startOrStop;
    }

    /**
     * @return the dateAndTime
     */
    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    /**
     * @param dateAndTime the dateAndTime to set
     */
    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
}
