package OOP.hw3.model;

import OOP.hw3.model.supports.MyCalendar;
import OOP.hw3.model.supports.Priority;
import OOP.hw3.model.supports.Responsible;
import OOP.hw3.model.supports.Theme;
import OOP.hw3.model.task.MyTask;
import OOP.hw3.model.task.Task;
import OOP.hw3.model.task.TeamTask;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class App {
    public static Scanner scanner;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);

        MyCalendar<Task> myCalendar = new MyCalendar<>();

        myCalendar.addTask(new MyTask(Theme.HOME,
                        LocalDateTime.now(),
                        Priority.IMPORTANT),
                "Прорубить окно в Европу");

        myCalendar.addTask(new TeamTask(Theme.JOB,
                        LocalDateTime.now().plusDays(8),
                        Priority.IMPORTANT,
                        new Responsible("Петр I", "Романов")),
                "Построить Санкт-Петербург");

        myCalendar.addTask(new MyTask(Theme.HOME,
                        LocalDateTime.now().plusDays(5),
                        Priority.IMPORTANT),
                "Срубить бороды боярам");

        myCalendar.addTask(new MyTask(Theme.HOBBY,
                        LocalDateTime.now().plusDays(9),
                        Priority.USUAL),
                "Покататься на бриге");

        myCalendar.addTask(new MyTask(Theme.HOBBY,
                        LocalDateTime.now(),
                        Priority.USUAL),
                "Откушать сигару на голландский манер");

        myCalendar.addTask(new MyTask(Theme.JOB,
                        LocalDateTime.now(),
                        Priority.IMPORTANT),
                "Дать нагоняй графу Меншикову");

        scanner.close();


        System.out.println("Все задачи: " + myCalendar.getAllTasks());
        System.out.println("Все задачи за " + LocalDate.now().plusDays(8) + ": " + myCalendar.getTasksForTheDay(LocalDate.now().plusDays(8)));
        myCalendar.toDoFirstTask();
        System.out.println("Все задачи: " + myCalendar.getAllTasks());
        System.out.println("Запись задач, которым треубется оповещение");
        myCalendar.notificationAllTasks();
        System.out.println("Запись задач за " + LocalDate.now() + ", которым требуется оповещение");
        myCalendar.notificationDailyTasks(LocalDate.now());
        System.out.print("Все задачи на сегодня: " + myCalendar.getDailyTasks());
    }
}
