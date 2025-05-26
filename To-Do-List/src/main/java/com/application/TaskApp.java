package com.application;

import controller.TaskController;
import dao.TaskDAO;
import dao.TaskDAOImpl;
import model.Task;
import view.TaskView;

import java.util.List;

public class TaskApp {
    public static void main(String[] args) {
        TaskDAO taskDAO = new TaskDAOImpl();
        TaskController controller = new TaskController(taskDAO);
        TaskView view = new TaskView();
        String command;

        do {
            command = view.getCommand();

            switch (command) {
                case "add":
                    String title = view.getTaskTitle();
                    String description = view.getTaskDescription();
                    controller.addTask(title, description);
                    break;
                case "list":
                    List<Task> tasks = controller.listTasks();
                    view.displayTasks(tasks);
                    break;
                case "done":
                    int index = view.getTaskIndex();
                    controller.markTaskAsDone(index);
                    break;
                case "exit":
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Comando inválido.");
            }
        } while (!command.equals("exit"));

        view.close();
    }
}
