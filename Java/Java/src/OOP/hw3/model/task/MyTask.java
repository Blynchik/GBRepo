package OOP.hw3.model.task;

import OOP.hw3.model.supports.Priority;
import OOP.hw3.model.supports.Theme;

import java.time.LocalDateTime;

public class MyTask extends Task {

    public MyTask(Theme theme, LocalDateTime deadline, Priority priority) {
        super(theme, deadline, priority);
    }
}
