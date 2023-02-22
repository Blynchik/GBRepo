package OOP.hw3.model.task;

import OOP.hw3.model.supports.Priority;
import OOP.hw3.model.supports.Theme;

import java.time.LocalDateTime;

public abstract class Task {

    private static int seq;

    private final int id;
    private Theme theme;
    private LocalDateTime deadline;
    private Priority priority;
    private String description;
    private boolean notification;
    private LocalDateTime addedAt;

    public Task(Theme theme, LocalDateTime deadline, Priority priority) {
        this.theme = theme;
        this.deadline = deadline;
        this.priority = priority;
        seq += 1;
        this.id = seq;
        this.notification = true;
        this.addedAt = LocalDateTime.now();
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public int getId() {
        return id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isNotification() {
        return notification;
    }

    public void switchNotification() {
        this.notification = !notification;
    }

    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDateTime addedAt) {
        this.addedAt = addedAt;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", theme=" + theme +
                ", deadline=" + deadline +
                ", priority=" + priority +
                ", description='" + description + '\'' +
                ", notification=" + notification +
                ", addedAt=" + addedAt +
                '}';
    }
}
