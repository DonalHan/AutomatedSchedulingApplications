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

/*A class bound to the form that is responsible for all the GUI components and their button events*/
public class AutomatedSchedulingApplicationGUI extends JFrame {
    public JPanel ASAMain; //declaring the main panel
    private JTabbedPane tabbedPane1; //first tab for a service
    private JLabel addTaskLabel;
    private JTextField taskDescTextField; //takes in the task description for add task function
    private JTextField taskWorkerTextField; //takes in the task worker for add task function
    private JTextField taskNameTextField; //takes in the task name for add task function
    private JButton addTaskButton; //Button responsible for calling the add task functionality from the controller
    private JLabel taskNameLabel;
    private JLabel TaskDescLabel;
    private JTextField taskIdField; //takes in the task ID for get task function
    private JButton getTaskButton; //Button responsible for calling the get task functionality from the controller
    private JComboBox dayComboBox; //takes in the task day for get task function
    private JComboBox monthComboBox; //takes in the task month for get task function
    private JComboBox yearComboBox; //takes in the task year for get task function
    private JButton getTaskDateButton; //Button responsible for calling the get task by date functionality from the controller
    private JLabel taskIdLabel;
    private JLabel getTaskByIDLabel;
    private JLabel getTaskByDateLabel;
    private JLabel dayLabel;
    private JLabel monthLabel;
    private JLabel yearLabel;
    private JLabel deleteTaskLabel;
    private JLabel taskIDLabel;
    private JTextField deleteTaskIdTextField; //takes in the task ID for delete task function
    private JButton deleteTaskButton; //Button responsible for calling delete task functionality from the controller
    private JTextField deleteMultTaskIdTextField; //takes in the task ID for delete multiple task function
    private JLabel deleteMultipleTasksLabel;
    private JLabel seperateTaskIDSLabel;
    private JLabel taskIDSLabel;
    private JButton deleteTasksButton; //Button responsible for calling delete multiple task functionality from the controller
    private JComboBox addTaskDayComboBox; //takes in the task day for add task function
    private JComboBox addTaskMonthComboBox; //takes in the task month for add task function
    private JComboBox addTaskYearComboBox; //takes in the task year for add task function
    private JTextField updateTaskIdField; //takes in the ID for tasks to be updated
    private JButton updateTaskButton; //Button responsible for calling the update task functionality fromt he controller
    private JLabel getTaskUpdateLabel;
    private JTextField getTaskUpdateTextField; //takes in task ID's to track
    private JButton getTaskUpdateButton; //button responsible for calling the get task updates functionality in the controller
    private JLabel updateTaskIDLabel;
    private JButton cancelAllUpdatesButton; //Cancels all the trackers currently being tracked

    private ControllerGUI controller; //declaring a controller to call the functionality
    private StreamObserver<GetTaskUpdatesRequest> taskUpdateObserver; //declaring a global stream observer so tracking can occur

     /*Constructor that takes in as a parameter the controller functionality for the buttons----------------------------*/
    public AutomatedSchedulingApplicationGUI (ControllerGUI controller)
    {
        this.controller = controller;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit the application on closing the interface
        this.setContentPane(ASAMain); //set the content pain as the ASAmain
        this.pack(); //back the content within the pain
        addTaskButton.addActionListener(new ActionListener() { //functionality responsible for adding a task to the task repo
            @Override
            public void actionPerformed(ActionEvent e) {
                String taskName = taskNameTextField.getText(); //getting the name inputted by the user
                String taskDescription = taskDescTextField.getText(); //getting the description passed in by the user
                String assignedUser = taskWorkerTextField.getText(); //getting the worker passed in by the user

                //Obtaining the date passed in by the user
                int day = Integer.parseInt(addTaskDayComboBox.getSelectedItem().toString());
                int month = Integer.parseInt(addTaskMonthComboBox.getSelectedItem().toString());
                int year = Integer.parseInt(addTaskYearComboBox.getSelectedItem().toString());

                Task task = Task.newBuilder() //building a task and populating it with the above fields
                        .setName(taskName)
                        .setDescription(taskDescription)
                        .setDueDate(Date.newBuilder().setYear(year).setMonth(month).setDay(day).build())
                        .setAssignedUser(assignedUser)
                        .build();

                AddTaskResponse addTaskResponse = controller.addTask(task); //passing the request to the controller which activates the service
                //Printing the response using a pop-up window
                JOptionPane.showMessageDialog(ASAMain, "Task added successfully! Task ID: " + addTaskResponse.getTaskId(), "Task Added", JOptionPane.INFORMATION_MESSAGE);

            }
        });
        getTaskDateButton.addActionListener(new ActionListener() { //functionality for getting tasks by Date
            @Override
            public void actionPerformed(ActionEvent e) {
                //Obtaining the date passed in by the user
                int day = Integer.parseInt(dayComboBox.getSelectedItem().toString());
                int month = Integer.parseInt(monthComboBox.getSelectedItem().toString());
                int year = Integer.parseInt(yearComboBox.getSelectedItem().toString());

                Date dateRequest = Date.newBuilder() //building a date request with the above info
                        .setDay(day)
                        .setMonth(month)
                        .setYear(year)
                        .build();

                List<Task> tasksOnDate = new ArrayList<>(); //declaring a list ot store the dates
                try
                {
                    tasksOnDate = controller.getTasksByDate(dateRequest); //populating the list by calling the service and passing in the previous date constructed
                }
                catch (InterruptedException ex) //error handling while the service is being conducted
                {
                    throw new RuntimeException(ex);
                }
                StringBuilder taskOutput = new StringBuilder(); //storing the result in a string builder to print

                for(Task task: tasksOnDate)
                {
                    taskOutput.append(taskInfo(task)); //calling the custom task info print below and appending to the string builder
                    taskOutput.append("\n");
                }
                //Printing the response using a pop-up window
                JOptionPane.showMessageDialog(ASAMain, taskOutput, "Tasks On Date", JOptionPane.INFORMATION_MESSAGE);

            }
        });
        getTaskButton.addActionListener(new ActionListener() { //functionality for getting tasks by ID
            @Override
            public void actionPerformed(ActionEvent e) {
                int taskId = Integer.parseInt(taskIdField.getText()); //obtaining the id passed in by the user
                GetTaskResponse getTaskResponse = controller.getTask(taskId); //  passing in the ID into the controller function to activate the service

                if (getTaskResponse != null) //if we get a response
                {
                    Task taskResponse = getTaskResponse.getTask(); //unpack the response and get the task
                    String response = taskInfo(taskResponse); //call the custom print method below
                    //Printing the response using a pop-up window
                    JOptionPane.showMessageDialog(ASAMain, response, "Task Information", JOptionPane.INFORMATION_MESSAGE); //print in a pop-up window
                }
                else
                {
                    //Printing the response using a pop-up window if the controller returns null
                    JOptionPane.showMessageDialog(ASAMain, "Task with ID " + taskId + " not found", "Task Not Found", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        deleteTaskButton.addActionListener(new ActionListener() { //functionality for deleting a task from the repo
            @Override
            public void actionPerformed(ActionEvent e) {
                int taskId = Integer.parseInt(deleteTaskIdTextField.getText()); //obtaining the id from the text field
                DeleteTaskResponse response = controller.deleteTask(taskId); //passing the id to controller which activates the service

                String output = response.getStatus();
                //Printing the response using a pop-up window
                JOptionPane.showMessageDialog(ASAMain, response, "Delete Task", JOptionPane.INFORMATION_MESSAGE);

            }
        });
        deleteTasksButton.addActionListener(new ActionListener() { //functionality responsible for deleting multiple tasks
            @Override
            public void actionPerformed(ActionEvent e) {
                String idInputs = deleteMultTaskIdTextField.getText(); //obtaining the ID's from the text field
                String[] splitInput = idInputs.split(","); //Splitting them into individual components in an array

                ArrayList<Integer> idsToDelete = new ArrayList<>(); //declaring a list to hold the parsed strings into intgers

                for (String stringId : splitInput) //populate the integer array
                {
                    int taskId = Integer.parseInt(stringId.trim()); //parse the strings into ints and trim any white spaces
                    idsToDelete.add(taskId); //add to the list
                }

                try
                {
                    String output = controller.deleteMultipleTasks(idsToDelete); //attempt to pass the list to the controller which activates the service and deletes the tasks
                    //Printing the response using a pop-up window
                    JOptionPane.showMessageDialog(ASAMain, output, "Delete Task", JOptionPane.INFORMATION_MESSAGE);
                }
                catch (InterruptedException ex) //catch any errors while the service is being conducted
                {
                    throw new RuntimeException(ex);// throw the errors
                }

            }
        });
        getTaskUpdateButton.addActionListener(new ActionListener() { //functionality responsible for subscribing users to task updates
            @Override
            public void actionPerformed(ActionEvent e) {
                String idInputs = getTaskUpdateTextField.getText(); //getting the ID's from the text field
                String[] splitInput = idInputs.split(","); //splitting the ids into an array
                ArrayList<Integer> idsToTrack = new ArrayList<>(); //declaring an int array to store the split ids

                for (String stringId : splitInput) //parsing the strings and adding them to the array
                {
                    int taskId = Integer.parseInt(stringId.trim()); //parse the strings and trim the white space
                    idsToTrack.add(taskId); //add the ints to the array
                }

                for (int i = 0; i < idsToTrack.size();) // A for loop that validates if the user input is in the list
                {
                    GetTaskResponse getTaskResponse = controller.getTask(idsToTrack.get(i)); //checking if the ID is in the list
                    if (getTaskResponse == null) //If it is not, notify the user and continue subscribing to the rest of the list
                    {
                        String response = "Task ID: " + idsToTrack.get(i) + " is not in the list"; //Building a response
                        JOptionPane.showMessageDialog(ASAMain, response, "Task Information", JOptionPane.INFORMATION_MESSAGE); //popup window
                        idsToTrack.remove(i); //remove the id that is not in the list before subscribing the user
                    }
                    else
                    {
                        i++; //move onto the next ID if the current ID is in the list
                    }
                }

                //passing to the controller the array list to track and the GUI components to handle update responses
                taskUpdateObserver = controller.getTaskUpdates(idsToTrack, ASAMain);

                StringBuilder confirmation = new StringBuilder(); //A string builder to notify the user of the current subscriptions
                if (!idsToTrack.isEmpty()) //If the list of ID's to track is not empty
                {
                    confirmation.append("Notifications on for tasks: " + "\n"); //Inform the use of what notifications are currently being tracked
                    for (int ids : idsToTrack)
                    {
                        confirmation.append(ids + "\n"); //append the id
                    }

                    String status = confirmation.toString(); //store the final output
                    JOptionPane.showMessageDialog(ASAMain, status, "Task Notifications", JOptionPane.INFORMATION_MESSAGE); //print in a pop-up window
                } // End of the condition
                getTaskUpdateTextField.setText(""); //reset the fields
            }
        });
        updateTaskButton.addActionListener(new ActionListener() { //Functionality for updating multiple tasks
            @Override
            public void actionPerformed(ActionEvent e) {
                String idInputs = updateTaskIdField.getText(); // Storing the input task from the text field
                String[] splitInput = idInputs.split(","); //splitting the inputs into an array

                ArrayList<Integer> idsToUpdate = new ArrayList<>(); //declaring a list to store the new ints
                List<Task> tasksToUpdate = new ArrayList<>(); //declaring a list ot obtain the tasks to update

                for (String stringId : splitInput)  //populating the int array with the strings by parsing
                {
                    int taskId = Integer.parseInt(stringId.trim()); //parsing the strings to ints and trimming the white space
                    idsToUpdate.add(taskId); //add to the list
                }

                for (int taskId : idsToUpdate) //Obtaining the tasks to update and populating the previous task list
                {
                    GetTaskResponse response = controller.getTask(taskId); //calling the controller to get the tasks
                    Task task = response.getTask(); //unpacking the response and grabbing the task

                    // Calling the custom-made panel for updating each task and passing the task into it
                    Task updatedTask = showUpdateTaskDialog(task);

                    if (updatedTask != null)  //if the task is not null add it to the list
                    {
                        tasksToUpdate.add(updatedTask);
                    }
                }

                // Pass the updated tasks to the controller to update the task repository
                try
                {
                   String status = controller.updateTasks(tasksToUpdate); //Finally pass the newly updated tasks to the controller to activate the update tasks service
                    //Printing the response using a pop-up window
                   JOptionPane.showMessageDialog(ASAMain, status, "Update Task", JOptionPane.INFORMATION_MESSAGE);
                }
                catch (InterruptedException ex) //catch any errors that might happen while the service is running
                {
                    throw new RuntimeException(ex); //throw the error
                }
            }
        });

        cancelAllUpdatesButton.addActionListener(new ActionListener() { //functionality responsible for cancelling all the subscriptions to tasks
            @Override
            public void actionPerformed(ActionEvent e)
            {
                controller.cancelTaskUpdates(taskUpdateObserver); //call the controllers methods to close the stream observer for all tasks
            }
        });
    }

    /*Custom method responsible for printing the task responses to a JOptionPane--------------------------------------*/
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

    /*A custom panel that is used to provide fields to display and update tasks for the user to manipulate------------*/
    private Task showUpdateTaskDialog(Task task)
    {

        JPanel updatePanel = new JPanel(); // Creating a custom panel for JOptionPane
        updatePanel.setLayout(new GridLayout(0, 2)); //setting the layout

        // Adding the components to the custom panel and populating the fields with task data
        updatePanel.add(new JLabel("Task ID: "));
        JTextField updateTaskIdField = new JTextField(String.valueOf(task.getId())); //Creating a text field and populating it with the task value
        updatePanel.add(updateTaskIdField); //Add to panel

        updatePanel.add(new JLabel("Task Name:"));
        JTextField updateTaskNameField = new JTextField(task.getName()); //Creating a text field and populating it with the task value
        updatePanel.add(updateTaskNameField); //Add to panel

        updatePanel.add(new JLabel("Task Description:"));
        JTextField updateTaskDescTextField = new JTextField(task.getDescription()); //Creating a text field and populating it with the task value
        updatePanel.add(updateTaskDescTextField); //Add to panel

        updatePanel.add(new JLabel("Assigned Worker:"));
        JTextField updateTaskWorkerTextField = new JTextField(task.getAssignedUser()); //Creating a text field and populating it with the task value
        updatePanel.add(updateTaskWorkerTextField); //Add to panel

        updatePanel.add(new JLabel("Due Date (Day):"));
        JComboBox<Integer> updateTaskDayComboBox = new JComboBox<>(); //Creating a text field and populating it with the task value
        for (int i = 1; i <= 31; i++) //adding the values to the day combo box
        {
            updateTaskDayComboBox.addItem(i);
        }
        updateTaskDayComboBox.setSelectedItem(task.getDueDate().getDay());
        updatePanel.add(updateTaskDayComboBox); //Add to panel

        updatePanel.add(new JLabel("Due Date (Month):"));
        JComboBox<Integer> updateTaskMonthComboBox = new JComboBox<>(); //Creating a text field and populating it with the task value
        for (int i = 1; i <= 12; i++) //adding the values to the month combo box
        {
            updateTaskMonthComboBox.addItem(i);
        }
        updateTaskMonthComboBox.setSelectedItem(task.getDueDate().getMonth());
        updatePanel.add(updateTaskMonthComboBox); //Add to panel

        updatePanel.add(new JLabel("Due Date (Year):"));
        JComboBox<Integer> updateTaskYearComboBox = new JComboBox<>(); //Creating a text field and populating it with the task value
        for (int i = 2023; i <= 2030; i++) //adding the values to the year combo box
        {
            updateTaskYearComboBox.addItem(i);
        }
        updateTaskYearComboBox.setSelectedItem(task.getDueDate().getYear());
        updatePanel.add(updateTaskYearComboBox); //Add to panel

        //Storing the choice of the user in a result variable
        int result = JOptionPane.showConfirmDialog(ASAMain, updatePanel, "Update Task", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) //If the user presses ok
        {
            // Retrieve all of the new info in the text fields
            int taskId = Integer.parseInt(updateTaskIdField.getText());
            String taskName = updateTaskNameField.getText();
            String taskDesc = updateTaskDescTextField.getText();
            String taskWorker = updateTaskWorkerTextField.getText();
            int day = (int) updateTaskDayComboBox.getSelectedItem();
            int month = (int) updateTaskMonthComboBox.getSelectedItem();
            int year = (int) updateTaskYearComboBox.getSelectedItem();

            //Create a new task with the text field information
            Task.Builder updatedTaskBuilder = task.toBuilder();
            updatedTaskBuilder
                    .setId(taskId)
                    .setName(taskName)
                    .setDescription(taskDesc)
                    .setAssignedUser(taskWorker)
                    .setDueDate(Date.newBuilder().setYear(year).setMonth(month).setDay(day).build());

            Task updatedTask = updatedTaskBuilder.build(); //build the new task

            return updatedTask; //return the task
        }

        return null; //if the user presses cancel, return null
    }




    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
