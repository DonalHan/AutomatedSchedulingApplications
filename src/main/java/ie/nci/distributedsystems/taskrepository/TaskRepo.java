package ie.nci.distributedsystems.taskrepository;

import ie.nci.distributedsystems.task_management_service.Date;
import ie.nci.distributedsystems.task_management_service.Task;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskRepo
{
    private List<Task> taskList = new ArrayList<>(); //An Array list to hold all the stored tasks
    private List<TaskTracker> taskUpdateTracker = new ArrayList<>(); //An array List to store the trackers of tasks
    int currentTopId = 0; //A variable to keep track of the ID's of tasks within the list
    public interface TaskTracker //An interface to define the methods each subscription request must utilise
    {
        void onTaskUpdated(Task updatedTask); //Triggered if there is a tracked task that is updated
        int getTaskId(); //a getter for the tracked ID task
        void setTaskId(int taskId); //a setter for the tracked ID task
    }

    /*Adding some mock tasks to the list to demonstrate application functions using a constructor*/
    public TaskRepo()
    {
        // Add mock tasks
        for (int i = 1; i <= 8; i++)
        {
            Task mockTask = Task.newBuilder() //declaring a builder to populate the list
                    .setId(i)
                    .setName("Mock Task " + i)
                    .setDescription("This is a mock task with ID " + i)
                    .setAssignedUser("User " + i)
                    .setDueDate(Date.newBuilder()
                            .setDay(10 + i)
                            .setMonth(5)
                            .setYear(2023)
                            .build())
                    .build();
            taskList.add(mockTask);
            currentTopId = i; //increment the Top ID
        }
    }

    /*A method to add tasks to the Array list-------------------------------------------------------------------------*/
    public Task addTask(Task task)
    {
        currentTopId++; // incrementing the new task to the next ID name
        Task newTask = task.toBuilder() // populating the tasks ID with the new ID
                .setId(currentTopId)
                .build();
        taskList.add(newTask); // Adding this task to the Array List
        return newTask; //Returning the task
    }


    /*A method that takes in a date and return the tasks within the list with said date-------------------------------*/
    public List<Task> getTasksByDate(Date userTime)
    {
        List<Task> tasksByDate = new ArrayList<>(); //declaring a list to store the matched task dates
        for (Task task : taskList) //iterating over the list to find the matched dates
        {
            if (userTime.equals(task.getDueDate()))
            {
                tasksByDate.add(task); //if theres a match, add it to the list
            }
        }
        return tasksByDate; //return the list
    }



    /*A method that takes in an ID and removes any tasks in the list with said ID-------------------------------------*/
    public boolean deleteTask(int userID)
    {
        boolean isDeleted = false; //a validator to be returned
        Iterator<Task> iterator = taskList.iterator(); //declaring an iterator to pass over the list (for loops failed here)

        while (iterator.hasNext())
        {
            Task task = iterator.next();
            if (userID == task.getId()) //If there is a match, remove the task and stop the loop
            {
                iterator.remove();
                isDeleted = true; //validated
                break;
            }
        }

        return isDeleted; //return validator
    }

    /*Methods that add or remove trackers from the tracker list-------------------------------------------------------*/

    public void registerTaskTracker(TaskTracker tracker)
    {
        taskUpdateTracker.add(tracker);
    }

    public void unregisterTaskTracker(TaskTracker observer)
    {
        taskUpdateTracker.remove(observer);
    }


    /* A method that updates any given task within the task list. Any tasks being tacked are also returned to the client*/
    public boolean updateTask(Task updatedTask)
    {
        Boolean isEdited = false; //validator to be returned to the user
        int findId = updatedTask.getId(); //storing the updated task ID
        int taskIndex = -1; //Variable to store the index of the task to be edited
        int count = 0; //counter to populate the previous taskIndex

        for(Task task : taskList) //for loop to find the task in the list to be updated
        {
            if (findId == task.getId()) //if the updated task, and the task in the list IDs match, store the index
            {
                taskIndex = count;
                break; //if found break
            }
            count++; //increment if not found
        }

        if(taskIndex != -1) // if the task to be updated was found, proceed with editing
        {
            Task taskToEdit = taskList.get(taskIndex); //populate a new task with the task found in the list
            Task.Builder taskBuilder = taskToEdit.toBuilder(); //pass it into the generated builder class

            if (!updatedTask.getName().isEmpty())  // if the updated information passed in was 'name'
            {
                taskBuilder.setName(updatedTask.getName());
            }
            else //if not copy the information from the old task
            {
                taskBuilder.setName(taskToEdit.getName());
            }

            if (!updatedTask.getDescription().isEmpty())  // if the updated information passed in was 'name'
            {
                taskBuilder.setDescription(updatedTask.getDescription()); // if the updated information passed in was 'Description'
            }
            else //if not copy the information from the old task
            {
                taskBuilder.setDescription(taskToEdit.getDescription());
            }

            if (!updatedTask.getAssignedUser().isEmpty())
            {
                taskBuilder.setAssignedUser(updatedTask.getAssignedUser()); // if the updated information passed in was 'AssignedUser'
            }
            else //if not copy the information from the old task
            {
                taskBuilder.setAssignedUser(taskToEdit.getAssignedUser());
            }

            if (updatedTask.hasDueDate())
            {
                taskBuilder.setDueDate(updatedTask.getDueDate()); // if the updated information passed in was 'DueDate'
            }
            else //if not copy the information from the old task
            {
                taskBuilder.setDueDate(taskToEdit.getDueDate());
            }

            Task newTask = taskBuilder.build(); //building the task and storing it into a new task
            taskList.set(taskIndex, newTask); //adding the new updated task to the list at the stored index spot
            isEdited = true; //validated

            for (TaskTracker tracker : taskUpdateTracker) //iterating through the task trackers
            {
                if (tracker.getTaskId() == newTask.getId()) //if any of the tasks updated matches a task ID that's being tracked. . .
                {
                    //call its onTaskUpdated (which builds a response, passes it into the StreamObserver and return the task update to the client)
                    tracker.onTaskUpdated(newTask);
                }
            }
        }

        return isEdited; //return validator
    }


    public Task getTask(int taskId)
    {
        for (Task task : taskList)
        {
            if (taskId == task.getId())
            {
                return task;
            }
        }
        return null;
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("ID: ").append(getId()).append(", Name: ").append(getName()).append("\n");
//        sb.append("Description: ").append(getDescription()).append("\n");
//        sb.append("Assigned User: ").append(getAssignedUser()).append(", Due Date: ");
//
//        Date dueDate = getDueDate();
//        sb.append(dueDate.getMonth()).append("/")
//                .append(dueDate.getDay()).append("/")
//                .append(dueDate.getYear());
//
//        return sb.toString();
//    }
}






