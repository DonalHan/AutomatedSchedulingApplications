package ie.nci.distributedsystems.client;

import ie.nci.distributedsystems.task_deletion_service.DeleteTaskResponse;
import ie.nci.distributedsystems.task_management_service.AddTaskResponse;
import ie.nci.distributedsystems.task_management_service.Date;
import ie.nci.distributedsystems.task_management_service.GetTaskResponse;
import ie.nci.distributedsystems.task_management_service.Task;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AutomatedSchedulingApplicationGUI extends JFrame {
    public JPanel ASAMain;
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

    private ControllerGUI controller;

    public AutomatedSchedulingApplicationGUI (ControllerGUI controller)
    {
        this.controller = controller;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(ASAMain);
        this.pack();
        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTaskButtonClicked();

            }
        });
        getTaskDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int day = Integer.parseInt(dayComboBox.getSelectedItem().toString());
                int month = Integer.parseInt(monthComboBox.getSelectedItem().toString());
                int year = Integer.parseInt(yearComboBox.getSelectedItem().toString());

                Date dateRequest = Date.newBuilder()
                        .setDay(day)
                        .setMonth(month)
                        .setYear(year)
                        .build();

                List<Task> tasksOnDate = new ArrayList<>();
                try
                {
                    tasksOnDate = controller.getTasksByDate(dateRequest);
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
                StringBuilder taskOutput = new StringBuilder();

                for(Task task: tasksOnDate)
                {
                    taskOutput.append(taskInfo(task));
                }
                JOptionPane.showMessageDialog(ASAMain, taskOutput, "Tasks On Date", JOptionPane.INFORMATION_MESSAGE);

            }
        });
        getTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int taskId = Integer.parseInt(taskIdField.getText());
                GetTaskResponse getTaskResponse = controller.getTask(taskId);

                Task taskResponse = getTaskResponse.getTask();
                String response = taskInfo(taskResponse);
                JOptionPane.showMessageDialog(ASAMain, response, "Task Information", JOptionPane.INFORMATION_MESSAGE);

            }
        });
        deleteTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int taskId = Integer.parseInt(deleteTaskIdTextField.getText());
                DeleteTaskResponse response = controller.deleteTask(taskId);

                String output = response.getStatus();
                JOptionPane.showMessageDialog(ASAMain, response, "Delete Task", JOptionPane.INFORMATION_MESSAGE);

            }
        });
        deleteTasksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idInputs = deleteMultTaskIdTextField.getText();
                String[] splitInput = idInputs.split(",");

                ArrayList<Integer> idsToDelete = new ArrayList<>();

                for (String stringId : splitInput)
                {
                    int taskId = Integer.parseInt(stringId.trim());
                    idsToDelete.add(taskId);
                }

                try
                {
                    String output = controller.deleteMultipleTasks(idsToDelete);
                    JOptionPane.showMessageDialog(ASAMain, output, "Delete Task", JOptionPane.INFORMATION_MESSAGE);
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }

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

    //On Button Click requests
    private void addTaskButtonClicked()
    {
        String taskName = taskNameTextField.getText();
        String taskDescription = taskDescTextField.getText();
        String assignedUser = taskWorkerTextField.getText();

        int day = Integer.parseInt(addTaskDayComboBox.getSelectedItem().toString());
        int month = Integer.parseInt(addTaskMonthComboBox.getSelectedItem().toString());
        int year = Integer.parseInt(addTaskYearComboBox.getSelectedItem().toString());

        Task task = Task.newBuilder()
                .setName(taskName)
                .setDescription(taskDescription)
                .setDueDate(Date.newBuilder().setYear(year).setMonth(month).setDay(day).build())
                .setAssignedUser(assignedUser)
                .build();

        AddTaskResponse addTaskResponse = controller.addTask(task);
        JOptionPane.showMessageDialog(ASAMain, "Task added successfully! Task ID: " + addTaskResponse.getTaskId(), "Task Added", JOptionPane.INFORMATION_MESSAGE);

    }

    public static String taskInfo(Task task)
    {
        return "Task ID: " + task.getId() + "\n"
                + "Name: " + task.getName() + "\n"
                + "Description: " + task.getDescription() + "\n"
                + "Assigned User: " + task.getAssignedUser() + "\n"
                + "Due Date: " + task.getDueDate().getDay() + "/"
                + task.getDueDate().getMonth() + "/"
                + task.getDueDate().getYear() + "\n";
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
