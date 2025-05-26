package dao;

import model.Task;
import java.util.List;

public interface TaskDAO {
    void addTask(Task task);
    List<Task> listTasks();
    void markAsDone(int index);
}
