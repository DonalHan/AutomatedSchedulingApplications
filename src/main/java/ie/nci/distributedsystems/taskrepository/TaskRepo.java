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






