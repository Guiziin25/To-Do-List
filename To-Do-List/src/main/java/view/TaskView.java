package view;

import model.Task;
import java.util.List;
import java.util.Scanner;

public class TaskView {
    private Scanner scanner;

    public TaskView() {
        this.scanner = new Scanner(System.in);
    }

    public String getCommand() {
        System.out.println("Digite um comando (add/list/done/exit): ");
        return scanner.nextLine();
    }

    public String getTaskTitle() {
        System.out.println("Título: ");
        return scanner.nextLine();
    }

    public String getTaskDescription() {
        System.out.println("Descrição: ");
        return scanner.nextLine();
    }

    public int getTaskIndex() {
        System.out.println("Índice da tarefa a marcar como concluída: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void displayTasks(List<Task> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ": " + tasks.get(i));
        }
    }

    public void close() {
        scanner.close();
    }
}
