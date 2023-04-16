package ie.nci.distributedsystems.client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutomatedSchedulingApplicationGUI extends JFrame {
    private JPanel ASAMain;
    private JTabbedPane tabbedPane1;
    private JLabel addTaskLabel;
    private JTextField taskDescTextField;
    private JTextField taskWorkerTextField;
    private JTextField taskNameTextField;
    private JButton addTaskButton;
    private JLabel taskNameLabel;
    private JLabel TaskDescLabel;
    private JTextField taskIdField;
    private JButton getTaskButton;
    private JComboBox dayComboBox;
    private JComboBox monthComboBox;
    private JComboBox yearComboBox;
    private JButton getTaskDateButton;
    private JLabel taskIdLabel;
    private JLabel getTaskByIDLabel;
    private JLabel getTaskByDateLabel;
    private JLabel dayLabel;
    private JLabel monthLabel;
    private JLabel yearLabel;
    private JLabel deleteTaskLabel;
    private JLabel taskIDLabel;
    private JTextField deleteTaskIdTextField;
    private JButton deleteTaskButton;
    private JTextField deleteMultTaskIdTextField;
    private JLabel deleteMultipleTasksLabel;
    private JLabel seperateTaskIDSLabel;
    private JLabel taskIDSLabel;
    private JButton deleteTasksButton;
    private JComboBox addTaskDayComboBox;
    private JComboBox addTaskMonthComboBox;
    private JComboBox addTaskYearComboBox;
    private JTextField updateTaskIdField;
    private JTextField updateTaskNameField;
    private JTextField updateTaskDescTextField;
    private JTextField updateTaskWorkerTextField;
    private JButton updateTaskButton;
    private JComboBox updateTaskDayComboBox;
    private JComboBox updateTaskYearComboBox;
    private JComboBox updateTaskMonthComboBox;
    private JLabel getTaskUpdateLabel;
    private JTextField getTaskUpdateTextField;
    private JButton getTaskUpdateButton;
    private JLabel updateTaskIDLabel;

    public AutomatedSchedulingApplicationGUI (String title)
    {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(ASAMain);
        this.pack();
        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        getTaskDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        getTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        deleteTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        deleteTasksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        getTaskUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        updateTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
