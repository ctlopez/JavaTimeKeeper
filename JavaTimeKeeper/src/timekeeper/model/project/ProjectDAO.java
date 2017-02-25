package timekeeper.model.project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is a data accessor for the Project class
 *
 * @author Christian Lopez
 */
public class ProjectDAO {

    /**
     * The separator for the file
     */
    private final char separator = '|';

    /**
     * The file name for the file
     */
    private final String fileName = "timeKeeper_project_sample_data\\project_data.txt";

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
     * This searches through the project file for the given project ID. If
     * found, it creates a Project with the information given in the project.
     *
     * @param projectID The ID to look for
     * @return The project found, or null if not found.
     * @throws FileNotFoundException
     */
    public Project getProject(int projectID) throws FileNotFoundException,
            IOException {

//        BufferedReader in = new BufferedReader(new FileReader(this.fileName));
//        String line;
//        while ((line = in.readLine()) != null) {
//            String[] parts = line.split("[" +
//                    Character.toString(this.separator) + "]");
//            String ID = parts[0];
//            String active = parts[1];
//            String name = parts[2];
//            String desc = parts[3];
//            if (ID.equals(projectID)) {
//                Project newProject = new Project();
//                newProject.setProjectID(Integer.parseInt(ID));
//                if (active.equals("A")) {
//                    newProject.setActiveFlag(true);
//                } else {
//                    newProject.setActiveFlag(false);
//                }
//                newProject.setName(name);
//                newProject.setDescription(desc);
//                in.close();
//                return newProject;
//            }
//
//        }
//        in.close();
//        
//        return null;
        return this.getProject("" + projectID);
    }

    /**
     * This searches through the project file for the given project ID. If
     * found, it creates a Project with the information given in the project.
     *
     * @param projectID The ID to look for
     * @return The project found, or null if not found.
     * @throws FileNotFoundException
     */
    public Project getProject(String projectID)
           {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(this.fileName));
            String line;
            while ((line = in.readLine()) != null) {
                String[] parts = line.split("["
                        + Character.toString(this.separator) + "]");
                String ID = parts[0];
                String active = parts[1];
                String name = parts[2];
                String desc = parts[3];
                if (ID.equals(projectID)) {
                    Project newProject = new Project();
                    newProject.setProjectID(Integer.parseInt(ID));
                    if (active.equals("A")) {
                        newProject.setActiveFlag(true);
                    } else {
                        newProject.setActiveFlag(false);
                    }
                    newProject.setName(name);
                    newProject.setDescription(desc);
                    in.close();
                    return newProject;
                }

            }
        } catch (FileNotFoundException fnf) {
            try {
                throw new FileNotFoundException("Unable to find file: " + fileName);
            } catch (FileNotFoundException ex) {
                 System.out.println("THIS IS SO STUPID 1");
            }
        } catch (IOException ex) {
            try {
                throw new IOException("Unable to read file: " + fileName);
            } catch (IOException ex1) {
                 System.out.println("THIS IS SO STUPID 2");
            }
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                 System.out.println("THIS IS SO STUPID 3");
            }
        }

        return null;
    }
    
    public List<Project> getAllProject() throws IOException
    {
        List <Project> pro = new ArrayList<Project>();
        
         BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(this.fileName));
            String line;
            while ((line = in.readLine()) != null) {
                String[] parts = line.split("["
                        + Character.toString(this.separator) + "]");
                String ID = parts[0];
                String active = parts[1];
                String name = parts[2];
                String desc = parts[3];
                
                if(active.equalsIgnoreCase("A"))
                {
                    Project newProject = new Project();
                    newProject.setProjectID(Integer.parseInt(ID));
                     newProject.setActiveFlag(true);
                    newProject.setName(name);
                    newProject.setDescription(desc);
                   
                    pro.add(newProject);
                   // return pro;
                   
                }
              
                // sort the list alphabetically
                Collections.sort(pro);
                
              } 
             
        }
        catch(FileNotFoundException ex)
        {
            System.out.print("File not dasodkasodk;ask;dfound");
        }
        finally
        {
            in.close();
        }
        return pro;
    }
    
}
