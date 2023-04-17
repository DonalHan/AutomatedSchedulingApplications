package ie.nci.distributedsystems.client;

import ie.nci.distributedsystems.task_deletion_service.DeleteTaskResponse;
import ie.nci.distributedsystems.task_management_service.AddTaskResponse;
import ie.nci.distributedsystems.task_management_service.Date;
import ie.nci.distributedsystems.task_management_service.GetTaskResponse;
import ie.nci.distributedsystems.task_management_service.Task;
import ie.nci.distributedsystems.task_update_service.GetTaskUpdatesRequest;
import io.grpc.stub.StreamObserver;

import javax.swing.*;
import java.awt.*;
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
    private JButton updateTaskButton;
    private JLabel getTaskUpdateLabel;
    private JTextField getTaskUpdateTextField;
    private JButton getTaskUpdateButton;
    private JLabel updateTaskIDLabel;
    private JButton cancelAllUpdatesButton;

    private ControllerGUI controller;
    private StreamObserver<GetTaskUpdatesRequest> taskUpdateObserver;

    public AutomatedSchedulingApplicationGUI (ControllerGUI controller)
    {
        this.controller = controller;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(ASAMain);
        this.pack();
        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

                if (getTaskResponse != null)
                {
                    Task taskResponse = getTaskResponse.getTask();
                    String response = taskInfo(taskResponse);
                    JOptionPane.showMessageDialog(ASAMain, response, "Task Information", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(ASAMain, "Task with ID " + taskId + " not found", "Task Not Found", JOptionPane.ERROR_MESSAGE);
                }

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
                String idInputs = getTaskUpdateTextField.getText();
                String[] splitInput = idInputs.split(",");
                ArrayList<Integer> idsToTrack = new ArrayList<>();
                for (String stringId : splitInput)
                {
                    int taskId = Integer.parseInt(stringId.trim());
                    idsToTrack.add(taskId);
                }

                taskUpdateObserver = controller.getTaskUpdates(idsToTrack, ASAMain);


                getTaskUpdateTextField.setText("");
            }
        });
        updateTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idInputs = updateTaskIdField.getText(); // Storing the input task
                String[] splitInput = idInputs.split(",");

                ArrayList<Integer> idsToUpdate = new ArrayList<>();
                List<Task> tasksToUpdate = new ArrayList<>();

                for (String stringId : splitInput) {
                    int taskId = Integer.parseInt(stringId.trim());
                    idsToUpdate.add(taskId);
                }

                for (int taskId : idsToUpdate) {
                    // Retrieve the task details
                    GetTaskResponse response = controller.getTask(taskId);
                    Task task = response.getTask();

                    // Call the showUpdateTaskDialog method
                    Task updatedTask = showUpdateTaskDialog(task);

                    if (updatedTask != null) {
                        tasksToUpdate.add(updatedTask);
                    }
                }

                // Pass the updated tasks to the controller to update the task repository
                try
                {
                   String status = controller.updateTasks(tasksToUpdate);
                   JOptionPane.showMessageDialog(ASAMain, status, "Delete Task", JOptionPane.INFORMATION_MESSAGE);
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        });

        cancelAllUpdatesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                controller.cancelTaskUpdates(taskUpdateObserver);
            }
        });
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

    private Task showUpdateTaskDialog(Task task) {
        // Create custom panel for JOptionPane
        JPanel updatePanel = new JPanel();
        updatePanel.setLayout(new GridLayout(0, 2));

        // Add components to the custom panel and initialize with task data
        updatePanel.add(new JLabel("Task ID: "));
        JTextField updateTaskIdField = new JTextField(String.valueOf(task.getId()));
        updatePanel.add(updateTaskIdField);

        updatePanel.add(new JLabel("Task Name:"));
        JTextField updateTaskNameField = new JTextField(task.getName());
        updatePanel.add(updateTaskNameField);

        updatePanel.add(new JLabel("Task Description:"));
        JTextField updateTaskDescTextField = new JTextField(task.getDescription());
        updatePanel.add(updateTaskDescTextField);

        updatePanel.add(new JLabel("Assigned Worker:"));
        JTextField updateTaskWorkerTextField = new JTextField(task.getAssignedUser());
        updatePanel.add(updateTaskWorkerTextField);

        updatePanel.add(new JLabel("Due Date (Day):"));
        JComboBox<Integer> updateTaskDayComboBox = new JComboBox<>();
        for (int i = 1; i <= 31; i++)
        {
            updateTaskDayComboBox.addItem(i);
        }
        updateTaskDayComboBox.setSelectedItem(task.getDueDate().getDay());
        updatePanel.add(updateTaskDayComboBox);

        updatePanel.add(new JLabel("Due Date (Month):"));
        JComboBox<Integer> updateTaskMonthComboBox = new JComboBox<>();
        for (int i = 1; i <= 12; i++)
        {
            updateTaskMonthComboBox.addItem(i);
        }
        updateTaskMonthComboBox.setSelectedItem(task.getDueDate().getMonth());
        updatePanel.add(updateTaskMonthComboBox);

        updatePanel.add(new JLabel("Due Date (Year):"));
        JComboBox<Integer> updateTaskYearComboBox = new JComboBox<>();
        for (int i = 2023; i <= 2030; i++)
        {
            updateTaskYearComboBox.addItem(i);
        }
        updateTaskYearComboBox.setSelectedItem(task.getDueDate().getYear());
        updatePanel.add(updateTaskYearComboBox);

        // Display JOptionPane with the custom panel
        int result = JOptionPane.showConfirmDialog(ASAMain, updatePanel, "Update Task", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION)
        {
            // Retrieve input values and create a new task with the updated info
            int taskId = Integer.parseInt(updateTaskIdField.getText());
            String taskName = updateTaskNameField.getText();
            String taskDesc = updateTaskDescTextField.getText();
            String taskWorker = updateTaskWorkerTextField.getText();
            int day = (int) updateTaskDayComboBox.getSelectedItem();
            int month = (int) updateTaskMonthComboBox.getSelectedItem();
            int year = (int) updateTaskYearComboBox.getSelectedItem();

            Task.Builder updatedTaskBuilder = task.toBuilder();
            updatedTaskBuilder
                    .setId(taskId)
                    .setName(taskName)
                    .setDescription(taskDesc)
                    .setAssignedUser(taskWorker)
                    .setDueDate(Date.newBuilder().setYear(year).setMonth(month).setDay(day).build());

            Task updatedTask = updatedTaskBuilder.build();

            return updatedTask;
        }

        return null;
    }




    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
