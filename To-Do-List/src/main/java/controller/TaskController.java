package controller;

import dao.TaskDAO;
import model.Task;
import java.util.List;

public class TaskController {
    private TaskDAO taskDAO;

    public TaskController(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    public void addTask(String title, String description) {
        Task task = new Task(title, description);
        taskDAO.addTask(task);
    }

    public List<Task> listTasks() {
        return taskDAO.listTasks();
    }

    public void markTaskAsDone(int index) {
        taskDAO.markAsDone(index);
    }
}
