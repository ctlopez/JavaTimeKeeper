package timekeeper.model.timerecord;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * This represents a data accessor for the TimeRecord class
 *
 * @author Christian Lopez
 */
public class TimeRecordDAO {

    /**
     * The separator for the file
     */
    private final char separator = '|';

    /**
     * The filename for the file
     */
    private final String fileName = "timeKeeper_project_sample_data\\time_record_data.txt";

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
    public TimeRecord appendTimeRecord(int projectID, int personID,
            char startOrStop) throws IOException {
        LocalDateTime dateAndTime = LocalDateTime.now();
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(this.fileName, true));
            writer.write(projectID + "|" + personID + "|"
                    + Character.toString(startOrStop) + "|" + dateAndTime);
            writer.newLine();
            writer.flush();

            TimeRecord newRecord = new TimeRecord();
            newRecord.setProjectID(projectID);
            newRecord.setDateAndTime(dateAndTime);
            newRecord.setPersonID(personID);
            newRecord.setStartOrStop(startOrStop);

            writer.close();

            return newRecord;
        } catch (IOException ex) {
            throw new IOException("Unable to write to file: " + fileName);
        }
    }

    public TimeRecord appendTimeRecord(String projectID, String personID,
            char startOrStop) throws IOException {

        LocalDateTime dateAndTime = LocalDateTime.now();
        BufferedWriter writer
                = new BufferedWriter(new FileWriter(this.fileName, true));
        writer.write(projectID + "|" + personID + "|"
                + Character.toString(startOrStop) + "|" + dateAndTime);
        writer.newLine();
        writer.flush();

        TimeRecord newRecord = new TimeRecord();
        newRecord.setProjectID(Integer.parseInt(projectID));
        newRecord.setDateAndTime(dateAndTime);
        newRecord.setPersonID(Integer.parseInt(personID));
        newRecord.setStartOrStop(startOrStop);

        writer.close();
        return newRecord;

    }
}
