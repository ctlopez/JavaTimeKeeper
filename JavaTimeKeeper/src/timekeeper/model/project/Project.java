package timekeeper.model.project;

/**
 * This class represents a project to keep record of.
 * @author Christian Lopez
 */
public class Project implements Comparable{
    
    /**
     * The project ID
     */
    private int projectID;
    
    /**
     * The project active flag
     */
    private boolean activeFlag;
    
    
    /**
     * The project name
     */
    private String name;
    
    /**
     * The project description
     */
    private String description;
       
    public Project(int projectID, boolean activeFlag,String name, String desc )
    {
        this.projectID = projectID;
        this.activeFlag = activeFlag;
        this.name = name;
        this.description = desc;
    }
    public Project()
    {
        
    }
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
     * @return the activeFlag
     */
    public boolean isActive() {
        return activeFlag;
    }

    /**
     * @param activeFlag the activeFlag to set
     */
    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        if (name.length() > 100) {
            throw new IllegalArgumentException ("The name cannot be longer " +
                    "than 100 characters.");
        } else if (name.charAt(0) < 'A' || name.charAt(0) > 'z') {
            throw new IllegalArgumentException ("The name must start with " +
                    "a letter.");
        }
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    
    /**
     * 
     * @param o
     * @return 
     */
    @Override
    public int compareTo(Object o) {
        Project p = (Project) o;
        return this.getName().compareTo(p.getName());
    }

}
