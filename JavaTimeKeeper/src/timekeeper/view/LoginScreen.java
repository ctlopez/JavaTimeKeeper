package timekeeper.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import timekeeper.controller.TimeKeeperv2;
import timekeeper.model.person.CurrentSecurityRoleException;
import timekeeper.model.person.Person;
import timekeeper.model.project.Project;
import timekeeper.model.timerecord.TimeRecord;

/**
 *
 * @author Christian Lopez
 */
public class LoginScreen extends JFrame {

    private final int WINDOW_WIDTH = 485;
    private final int WINDOW_HEIGHT = 300;
    private final String NEWLINE = "\n";

    private ResourceBundle labels;

    private JLabel usernameLabel;
    private JPanel panel;
    private JPanel cards;
    private JPanel usernamePanel;
    private JPanel passPanel;
    private JPanel exitPanel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton submitButton;
    private JButton exitButton;
    private JLabel messageLabel;
    private JLabel saveDataLabel;
//    private JLabel welcomeLabel;
//    private JPanel welcomePanel;
//    private JLabel projectLabel;
//    private JLabel timeLabel;
    private JPanel header;
    private JTextArea headerInfo;

    JPanel mainPanel;
    JLabel name;
    JLabel project;
    JPanel infoPanel;
    //ProjectDAO proDAO = new ProjectDAO();
    Project pro = new Project();

    //String data[][] = {{"asdh","dsadas","asdasdasds","asdasdasd" },{"asdh","dsadas","asdasdasds","asdasdasd" }};
    ProjectTableModel table;

    JTable textArea = new JTable();

    JPanel textPanel;
    String proname;
    String des;
    String id;

    JLabel searchLabel;
    JTextField textField;
    JPanel searchPanel;

    JButton searchButton;

//    final JComponent[] inputs = new JComponent[] {
//        new JButton("Start"),
//        
//        new JButton("End"),
//        
//      new JButton("Cancel"),
//       
//};
    private final String MENU = "Menu";
    private final String LOGIN = "Login";
    private final String PROJECTS = "Projects";
    private final String BUNDLE_NAME = "timekeeper.view.OutputStrings";
    private final int EXIT_NUM = 0;
    private final int GOOD_EXIT = 0;
    private final int START_NUM = 0;
    private final int STOP_NUM = 1;
    private Person user;
    private TimeRecord timeRecord = null;
    private Project currentProject = null;
    private LocalDateTime startTime;
    private LocalDateTime stopTime;

    // Store the control object here
    // private ResourceBundleExample
    /**
     *
     * @throws HeadlessException
     */
    public LoginScreen() throws HeadlessException {
        super();
        this.labels = ResourceBundle.getBundle(BUNDLE_NAME, Locale.ENGLISH);
        initialize();
    }

    private void addComponentToPane(Container pane) {
        JPanel card1 = new JPanel();

        usernamePanel = new JPanel();
        passPanel = new JPanel();

        usernameLabel = new JLabel();
        usernameLabel.setText(labels.getString("username"));
        //panel.add(usernameLabel);
        usernamePanel.add(usernameLabel);

        usernameField = new JTextField(30);
        usernameField.setText("");

        //panel.add(usernameField);
        usernamePanel.add(usernameField);

        card1.add(usernamePanel);

        passwordLabel = new JLabel();
        passwordLabel.setText(labels.getString("password"));
        //panel.add(passwordLabel);
        passPanel.add(passwordLabel);

        passwordField = new JPasswordField(30);
        //panel.add(passwordField);
        passPanel.add(passwordField);

        card1.add(passPanel);

        messageLabel = new JLabel();
        messageLabel.setText("");

        saveDataLabel = new JLabel();
        saveDataLabel.setText("");

        submitButton = new JButton();
        submitButton.setText(labels.getString("submit_button"));
        submitButton.setMnemonic(KeyEvent.VK_S);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag;
                if (usernameField.getText().equals("")
                        || passwordField.getText().equals("")) {
                    messageLabel.setText(labels.getString("need_data"));
                } else {
                    try {
                        // Tell controller we're done
                        user = TimeKeeperv2.validateLogin(
                                usernameField.getText(),
                                passwordField.getText());
                    } catch (CurrentSecurityRoleException | IOException ex) {
                        messageLabel.setText(labels.getString("error"));
                    }
                    if (user == null) {
                        messageLabel.setText(labels.getString("user_not_found"));
                    } else {
                        messageLabel.setText(labels.getString("valid"));
                        CardLayout cl = (CardLayout) (cards.getLayout());
                        cl.show(cards, MENU);
                        updateHeader(pane, user, currentProject, timeRecord);
//                        for (Component c : pane.getComponents()) {
//                            if (c == header) {
//                                JPanel headerPanel = (JPanel) c;
//                                for (Component k : headerPanel.getComponents()) {
//                                    if (k == headerInfo) {
//                                        JTextArea info = (JTextArea) k;
//                                        info.setText(labels.getString("welcome"));
//                                        info.append(user.getFirstName());
//                                        if (null == project.getName()) {
//                                            info.append(NEWLINE +
//                                                    labels.getString("no_project"));
//                                        }
//                                        
//                                        
//                                    }
//                                }
//                            }
//                        }

                    }
                }

            }
        }
        );
        card1.add(submitButton);

        card1.add(messageLabel);

        card1.add(saveDataLabel);

        JPanel card2 = new JPanel();

        mainPanel = new JPanel(new BorderLayout());
        infoPanel = new JPanel();
        this.setLayout(new BorderLayout());

        infoPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

//        name = new JLabel("Employee Name: ");
//        gc.gridx = 0;
//        gc.gridy = 0;
//        gc.anchor = GridBagConstraints.NORTHWEST;
//        gc.insets = new Insets(2, 0, 0, 2);
//        infoPanel.add(name, gc);
//        project = new JLabel("Project Name: ");
//        gc.gridx = 0;
//        gc.gridy = 1;
//        gc.insets = new Insets(2, 0, 0, 2);
//        gc.anchor = GridBagConstraints.NORTHWEST;
//        gc.weightx = 1;
//        gc.weighty = 1;
//        infoPanel.add(project, gc);
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        mainPanel.add(infoPanel, BorderLayout.WEST);

        //  String[] columns = {"Project Id", "Status", "Project Name", "Description" };
        try {
            //List<Project>  listPro = proDAO.getAllProject();
            List<Project> listPro = TimeKeeperv2.getActiveProjects();
            table = new ProjectTableModel(listPro);

            textArea = new JTable(table) {
                @Override
                public boolean isCellEditable(int data, int columns) {
                    return false;
                }

                public Component prepareRenderer(TableCellRenderer r, int data, int columns) {
                    Component c = super.prepareRenderer(r, data, columns);

                    if (data % 2 == 0) {
                        c.setBackground(Color.LIGHT_GRAY);
                    } else {
                        c.setBackground(Color.GRAY);
                    }

                    return c;
                }

            };

            textArea.setPreferredScrollableViewportSize(new Dimension(450, 63));
            textArea.setFillsViewportHeight(true);

            JScrollPane jp = new JScrollPane(textArea);

            textPanel = new JPanel();
            textPanel.add(jp);
            mainPanel.add(textPanel, BorderLayout.CENTER);
        } catch (Exception ex) {
            System.out.println(labels.getString("cant_find_project"));
        }

        searchLabel = new JLabel(labels.getString("project_prompt"));
        textField = new JTextField(10);
        textField.setText("0");

        searchPanel = new JPanel();
        searchButton = new JButton(labels.getString("search_button"));
        searchPanel.add(searchLabel);
        searchPanel.add(textField);

        searchButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                if (textField.getText().equals("0")) {
                    JOptionPane.showMessageDialog(null, labels.getString("null_search"));
                } else {
                    int id = Integer.parseInt(textField.getText());

                    if (projectIDValidation(id) == true) {
                        int startStop = JOptionPane.showOptionDialog(null,
                                labels.getString("opt_message"),
                                labels.getString("opt_title"),
                                JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null,
                                new String[]{labels.getString("opt_one"),
                                    labels.getString("opt_two"),
                                    labels.getString("opt_three")}, "default");
                        if (startStop == START_NUM) {
                            // check if a project is already started
                            if (null != pro) {
                                timeRecord = TimeKeeperv2.appendRecord(""
                                        + pro.getProjectID(),
                                        "" + user.getPersonID(), "E");
                                stopTime = timeRecord.getDateAndTime();
                            }

                            //need to store the data
                            timeRecord = TimeKeeperv2.appendRecord("" + pro.getProjectID(),
                                    "" + user.getPersonID(), "S");
                            startTime = timeRecord.getDateAndTime();
                        } else if (startStop == STOP_NUM) {
                            timeRecord = TimeKeeperv2.appendRecord("" + pro.getProjectID(),
                                    "" + user.getPersonID(), "E");
                            stopTime = timeRecord.getDateAndTime();
                        }

                        if (null != timeRecord) {
                            JOptionPane.showMessageDialog(null,
                                    labels.getString("stored_success"));
                            CardLayout cl = (CardLayout) (cards.getLayout());
                            cl.show(cards, MENU);
                            updateHeader(pane, user, pro, timeRecord);

                        }

                        System.out.println(startStop);
                    } else {
                        //System.out.println("THIS IS SO STUPID");
                        JOptionPane.showMessageDialog(null,
                                labels.getString("invalid_id"));
                    }
                }

            }

            private boolean projectIDValidation(int id) {

                try {

                    //pro = proDAO.getProject(id);
                    pro = TimeKeeperv2.getProjectByID(id);

                    if (pro.isActive()) {
                        return true;
                    }

                } catch (Exception ex) {

                    //JOptionPane.showMessageDialog(null, "Project ID is not valid, please try again");
                }
                return false;
            }
        });
        searchPanel.add(searchButton);
        JButton backToMenu = new JButton();
        backToMenu.setText(labels.getString("back_button"));

        backToMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout c1 = (CardLayout) (cards.getLayout());
                c1.show(cards, MENU);
            }
        });

        searchPanel.add(backToMenu);
        mainPanel.add(searchPanel, BorderLayout.SOUTH);

        //add(mainPanel);
        card2.add(mainPanel);

        JPanel card3 = new JPanel();

        JPanel mainMenu = new JPanel();

        JButton btnProjects = new JButton();
        btnProjects.setText(labels.getString("project_button"));
        btnProjects.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout c2 = (CardLayout) (cards.getLayout());
                c2.show(cards, PROJECTS);
            }
        });

        mainMenu.add(btnProjects);

        card3.add(mainMenu);

        cards = new JPanel(new CardLayout());
        cards.add(card1, LOGIN);
        cards.add(card2, PROJECTS);
        cards.add(card3, MENU);

        pane.add(cards, BorderLayout.CENTER);
    }

    /**
     *
     */
    private void initialize() {
        setTitle(labels.getString("program_name"));
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel = new JPanel();
//        usernamePanel = new JPanel();
//        passPanel = new JPanel();
//
//        usernameLabel = new JLabel();
//        usernameLabel.setText(labels.getString("username"));
//        //panel.add(usernameLabel);
//        usernamePanel.add(usernameLabel);
//
//        usernameField = new JTextField(30);
//        usernameField.setText("");
//
//        //panel.add(usernameField);
//        usernamePanel.add(usernameField);
//
//        panel.add(usernamePanel);
//
//        passwordLabel = new JLabel();
//        passwordLabel.setText(labels.getString("password"));
//        //panel.add(passwordLabel);
//        passPanel.add(passwordLabel);
//
//        passwordField = new JPasswordField(30);
//        //panel.add(passwordField);
//        passPanel.add(passwordField);
//
//        panel.add(passPanel);
//
//        messageLabel = new JLabel();
//        messageLabel.setText("");
//
//        saveDataLabel = new JLabel();
//        saveDataLabel.setText("");
//
//        submitButton = new JButton();
//        submitButton.setText(labels.getString("submit_button"));
//        submitButton.setMnemonic(KeyEvent.VK_S);
//        submitButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                boolean flag;
//                if (usernameField.getText().equals("")
//                        || passwordField.getText().equals("")) {
//                    messageLabel.setText(labels.getString("need_data"));
//                } else {
//                    try {
//                        // Tell controller we're done
//                        user = TimeKeeperv2.validateLogin(
//                                usernameField.getText(),
//                                passwordField.getText());
//                    } catch (CurrentSecurityRoleException | IOException ex) {
//                        messageLabel.setText(labels.getString("error"));
//                    }
//                    if (user == null) {
//                        messageLabel.setText(labels.getString("user_not_found"));
//                    } else {
//                        messageLabel.setText(labels.getString("valid"));
//                    }
////                    if (ResourceBundleUserNamePass.checkCredentials(user,
////                            usernameField.getText(), passwordField.getText())) {
////                        messageLabel.setText(labels.getString("valid"));
////                        flag = true;
////                    } else {
////                        messageLabel.setText(labels.getString("not_valid"));
////                        usernameField.requestFocus();
////                        usernameField.selectAll();
////                        flag = false;
////                    }
////                    if (flag) {
////                        if (ResourceBundleUserNamePass.writeData(
////                                usernameField.getText(),
////                                passwordField.getText(),
////                                labels.getString("success_log"),
////                                labels)) {
////                            saveDataLabel.setText(labels.getString("saved_data"));
////                        } else {
////                            saveDataLabel.setText(labels.getString("unable_to_save"));
////                        }
////                    } else {
////                        if (ResourceBundleUserNamePass.writeData(
////                                usernameField.getText(),
////                                passwordField.getText(),
////                                labels.getString("error_log"),
////                                labels)) {
////                            saveDataLabel.setText(labels.getString("saved_data"));
////                        } else {
////                            saveDataLabel.setText(labels.getString("unable_to_save"));
////                        }
//
////                    if (ResourceBundleUserNamePass.checkCredentials(user,
////                            usernameField.getText(), passwordField.getText())) {
////                        messageLabel.setText(labels.getString("valid"));
////                        flag = true;
////                    } else {
////                        messageLabel.setText(labels.getString("not_valid"));
////                        usernameField.requestFocus();
////                        usernameField.selectAll();
////                        flag = false;
////                    }
////                    if (flag) {
////                        if (ResourceBundleUserNamePass.writeData(
////                                usernameField.getText(),
////                                passwordField.getText(),
////                                labels.getString("success_log"),
////                                labels)) {
////                            saveDataLabel.setText(labels.getString("saved_data"));
////                        } else {
////                            saveDataLabel.setText(labels.getString("unable_to_save"));
////                        }
////                    } else {
////                        if (ResourceBundleUserNamePass.writeData(
////                                usernameField.getText(),
////                                passwordField.getText(),
////                                labels.getString("error_log"),
////                                labels)) {
////                            saveDataLabel.setText(labels.getString("saved_data"));
////                        } else {
////                            saveDataLabel.setText(labels.getString("unable_to_save"));
////                        }
////                }
//                }
//
//            }
//        }
//        );
//        panel.add(submitButton);
//
//        panel.add(messageLabel);
//
//        panel.add(saveDataLabel);

//        enterButton = new JButton();
//        enterButton.setText(labels.getString("enter_button"));
//        enterButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                int result = JOptionPane.showOptionDialog(null, 
//                        "Are you starting or stopping?", "Project start/stop", 
//                        JOptionPane.YES_NO_CANCEL_OPTION, 
//                        JOptionPane.QUESTION_MESSAGE, null, 
//                        new String[]{"Starting", "Stopping", "Cancel"}, 
//                        "default");
//                messageLabel.setText(Integer.toString(result));//right now to see answer. will remove
//            }
//        
//        });
//        
//        panel.add(enterButton);
        header = new JPanel();
        headerInfo = new JTextArea(4, 25);
        headerInfo.setEditable(false);
        headerInfo.append(labels.getString("welcome_no_user"));
//        welcomePanel = new JPanel();
//        welcomeLabel = new JLabel();
//        welcomeLabel.setText(labels.getString("welcome_no_user"));
//        welcomePanel.add(welcomeLabel);
//        projectLabel = new JLabel();
//        welcomePanel.add(projectLabel);
//        header.add(welcomePanel);
        header.add(headerInfo);

        exitButton = new JButton();

        exitButton.setText(labels.getString("exit_button"));
        exitButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                int result = JOptionPane.showOptionDialog(null,
                        labels.getString("exit_message"),
                        labels.getString("exit_button"),//same text, so reuse
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.WARNING_MESSAGE, null,
                        new String[]{labels.getString("exit_button"),
                            labels.getString("opt_three")},
                        "default");
                if (result == EXIT_NUM) {
                    System.exit(GOOD_EXIT);
                }
            }

        }
        );

        exitPanel = new JPanel();

        exitPanel.add(exitButton);

        panel.add(exitPanel);

        addComponentToPane(this.getContentPane());

        add(header, BorderLayout.NORTH);

        add(panel, BorderLayout.SOUTH);

        setVisible(
                true);
    }

    private void updateHeader(Container pane, Person user,
            Project project, TimeRecord timeRecord) {
        for (Component c : pane.getComponents()) {
            if (c == header) {
                JPanel headerPanel = (JPanel) c;
                for (Component k : headerPanel.getComponents()) {
                    if (k == headerInfo) {
                        JTextArea info = (JTextArea) k;
                        info.setText(labels.getString("welcome"));
                        info.append(user.getFirstName());
                        if (null == project) {
                            info.append(NEWLINE
                                    + labels.getString("no_project"));
                        } else {
                            info.append(NEWLINE
                                    + labels.getString("have_project")
                                    + project.getName());
                        }
                        if (null == timeRecord) {
                            info.append(NEWLINE
                                    + labels.getString("no_timerecord"));
                        } else if (("" + timeRecord.getStartOrStop()).equals("S")) {
                            info.append(NEWLINE
                                    + labels.getString("start_timerecord") + timeRecord.getDateAndTime());
                        } else {
                            info.append(NEWLINE
                                    + labels.getString("stop_timerecord") + timeRecord.getDateAndTime());
                            info.append(NEWLINE
                                    + calculateTime(startTime, stopTime));
                        }

                    }
                }
            }
        }
    }

    private String calculateTime(LocalDateTime from, LocalDateTime to) {
        String timePassed = "";

        if (null != from && null != to) {
            LocalDateTime calculator = LocalDateTime.from(from);
            long hours = calculator.until(to, ChronoUnit.HOURS);
            calculator = calculator.plusHours(hours);

            long minutes = calculator.until(to, ChronoUnit.MINUTES);
            calculator = calculator.plusMinutes(minutes);

            long seconds = calculator.until(to, ChronoUnit.SECONDS);

            timePassed = hours + " " + labels.getString("hours") + " "
                    + +minutes + " " + labels.getString("minutes") + " "
                    + seconds + " " + labels.getString("seconds");
        }

        return timePassed;
    }

}
