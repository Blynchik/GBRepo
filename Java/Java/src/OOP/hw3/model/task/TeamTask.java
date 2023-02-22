package OOP.hw3.model.task;

import OOP.hw3.model.supports.Priority;
import OOP.hw3.model.supports.Responsible;
import OOP.hw3.model.supports.Theme;

import java.time.LocalDateTime;

public class TeamTask extends Task {

    private Responsible responsible;

    public TeamTask(Theme theme, LocalDateTime deadline, Priority priority, Responsible responsible) {
        super(theme, deadline, priority);
        this.responsible = responsible;
    }

    public Responsible getResponsible() {
        return responsible;
    }

    public void setResponsible(Responsible responsible) {
        this.responsible = responsible;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", responsible=" + responsible;
    }
}
