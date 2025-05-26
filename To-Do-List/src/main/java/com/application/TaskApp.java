package com.application;

import controller.TaskController;
import dao.TaskDAO;
import dao.TaskDAOImpl;
import model.Task;

import java.util.List;
import java.util.Scanner;

public class TaskApp {
    public static void main(String[] args) {
        TaskDAO taskDAO = new TaskDAOImpl();
        TaskController controller = new TaskController(taskDAO);
        Scanner scanner = new Scanner(System.in);
        String command;

        do {
            System.out.println("Digite um comando (add/list/done/exit): ");
            command = scanner.nextLine();

            switch (command) {
                case "add":
                    System.out.println("Título: ");
                    String title = scanner.nextLine();
                    System.out.println("Descrição: ");
                    String description = scanner.nextLine();
                    controller.addTask(title, description);
                    break;
                case "list":
                    List<Task> tasks = controller.listTasks();
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println(i + ": " + tasks.get(i));
                    }
                    break;
                case "done":
                    System.out.println("Índice da tarefa a marcar como concluída: ");
                    int index = Integer.parseInt(scanner.nextLine());
                    controller.markTaskAsDone(index);
                    break;
                case "exit":
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Comando inválido.");
            }
        } while (!command.equals("exit"));

        scanner.close();
    }
}
