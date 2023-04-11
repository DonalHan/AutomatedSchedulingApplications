package ie.nci.distributedsystems.taskrepository;

import ie.nci.distributedsystems.task_management_service.Date;
import ie.nci.distributedsystems.task_management_service.Task;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskRepo
{
    List<Task> taskList = new ArrayList<>();
    int currentTopId = 0; //A variable to keep track of the ID's of tasks within the list

    /*Adding some mock tasks to the list to demonstrate application functions*/

    public TaskRepo()
    {
        // Add mock tasks
        for (int i = 1; i <= 8; i++) {
            Task mockTask = Task.newBuilder()
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
            currentTopId = i;
        }
    }

    // A method to add tasks to the Array list
    public Task addTask(Task task)
    {
        currentTopId++; // incrementing the new task to the next ID name
        Task newTask = task.toBuilder() // populating the tasks ID with the new ID
                .setId(currentTopId)
                .build();
        taskList.add(newTask); // Adding this task to the Array List
        return newTask; //Returning the task
    }
    public List<Task> getTasksByDate(Date userTime)
    {
        List<Task> tasksByDate = new ArrayList<>();
        for (Task task : taskList)
        {
            if (userTime.equals(task.getDueDate()))
            {
                tasksByDate.add(task);
            }
        }
        return tasksByDate;
    }

    public boolean deleteTask(int userID)
    {
        boolean isDeleted = false;
        Iterator<Task> iterator = taskList.iterator();

        while (iterator.hasNext())
        {
            Task task = iterator.next();
            if (userID == task.getId())
            {
                iterator.remove();
                isDeleted = true;
                break;
            }
        }

        return isDeleted;
    }

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
            if (!updatedTask.getDescription().isEmpty())  // if the updated information passed in was 'name'
            {
                taskBuilder.setDescription(updatedTask.getDescription()); // if the updated information passed in was 'Description'
            }
            if (!updatedTask.getAssignedUser().isEmpty())
            {
                taskBuilder.setAssignedUser(updatedTask.getAssignedUser()); // if the updated information passed in was 'AssignedUser'
            }
            if (updatedTask.hasDueDate())
            {
                taskBuilder.setDueDate(updatedTask.getDueDate()); // if the updated information passed in was 'DueDate'
            }


            Task newTask = taskBuilder.build();
            taskList.set(taskIndex, newTask);
            isEdited = true;
        }

        return isEdited;
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






