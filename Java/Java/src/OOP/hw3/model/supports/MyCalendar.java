package OOP.hw3.model.supports;

import OOP.hw3.model.task.Task;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static OOP.hw3.model.App.scanner;

public class MyCalendar<T extends Task> {

    private List<T> taskQueue;

    public MyCalendar() {
        this.taskQueue = new ArrayList<>();
    }

    //return all tasks in the list
    public List<T> getAllTasks() {
        return taskQueue;
    }

    //return all tasks for certain day and sort it according priority
    public List<T> getTasksForTheDay(LocalDate localDate) {

        return taskQueue.stream()
                .filter(t -> t.getDeadline().toLocalDate().isEqual(localDate))
                .sorted(Comparator.comparing(Task::getPriority))
                .collect(Collectors.toList());
    }

    //add task to the list and sort it according to the nearest deadline
    public void addTask(T task, String description) {
        task.setDescription(description);
        turnOnOffNotification(task);
        taskQueue.add(task);
        taskQueue.sort((Comparator.comparing(Task::getDeadline)));
    }

    //switch notification from true to false and from false to true
    private void turnOnOffNotification(T task) {
        System.out.println("Изменить оповещение для " + task.getDescription() + "?\nСейчас: " + task.isNotification() + "\nда/нет");

        String response = scanner.nextLine();

        if (response.equals("да")) {
            task.switchNotification();
        }
    }

    //execute first task in the list
    public void toDoFirstTask() {
        System.out.println("Выполнено: " + taskQueue.get(0));
        taskQueue.remove(0);
    }

    //writes tasks to the file if notification is true
    private void putIntoFile(List<T> tasks, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName + ".txt", false)) {

            for (T task : tasks) {

                if (task.isNotification()) {
                    fileWriter.append(task.toString()).append("\n");
                    fileWriter.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //writes tasks for today to the file if notification is true
    public void notificationDailyTasks(LocalDate localDate) {
        putIntoFile(getTasksForTheDay(localDate), "hw3/model/notification/dailyTasks");
    }

    //writes all tasks to the file if notification is true
    public void notificationAllTasks() {
        putIntoFile(getAllTasks(), "hw3/model/notification/allTasks");
    }

    //return tasks for today
    public List<T> getDailyTasks() {
        return getTasksForTheDay(LocalDate.now());
    }
}
