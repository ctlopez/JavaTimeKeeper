/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timekeeper.controller;

import java.io.IOException;
import java.util.List;
import timekeeper.model.person.CurrentSecurityRoleException;
import timekeeper.model.person.Person;
import timekeeper.model.person.PersonDAO;
import timekeeper.model.project.Project;
import timekeeper.model.project.ProjectDAO;
import timekeeper.model.timerecord.TimeRecord;
import timekeeper.model.timerecord.TimeRecordDAO;
import timekeeper.view.LoginScreen;

/**
 *
 * @author Christian
 */
public class TimeKeeperv2 {

    private static ProjectDAO projectDAO = new ProjectDAO();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        new LoginScreen();

    }

    public static Person validateLogin(String username, String password) throws
            CurrentSecurityRoleException, IOException {
        try {
            Person p = null;

            // See if the username and password has values... might put this in GUI
            if (username.length() == 0 || password.length() == 0) {

            }

            PersonDAO personAccess = new PersonDAO();

            Person temp = personAccess.getPerson(username);

            if (temp != null && temp.getPassword().equals(password)) {
                p = temp;
            }

            return p;
        } catch (CurrentSecurityRoleException | IOException ex) {
            throw ex;
        }
    }

    public static TimeRecord appendRecord(String projectID, String personID, String startOrStop) {

        // Create a timerecord accessor and a time record
        TimeRecordDAO recordAccessor
                = new TimeRecordDAO();
        //recordAccessor.setSeparator(FILESEPARATOR);
        //recordAccessor.setFileName(TIMERECORDFILE);
        TimeRecord newRecord = null;

        // Try to access the file to write to it, and send back the record
        try {
            newRecord = recordAccessor.appendTimeRecord(projectID, personID,
                    startOrStop.charAt(0));
        } catch (IOException ex) {
            //System.err.println("Unable to write to file: " + recordAccessor.getFileName());
            System.err.println(ex.getMessage());
            System.exit(-1);
        }

        return newRecord;
    }

    public static List<Project> getActiveProjects() throws IOException {
        return projectDAO.getAllProject();
    }

    public static Project getProjectByID(int ID) throws IOException {
        return projectDAO.getProject(ID);
    }

}
