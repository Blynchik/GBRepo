package OOP.hw3.model.supports;

import OOP.hw3.model.task.Task;

public enum Priority {

    IMPORTANT, USUAL;

    public <T extends Task> int compareTo() {
        if (this.equals(IMPORTANT)) {
            return 1;
        }
        if (this.equals(USUAL)) {
            return -1;
        }
        return 0;
    }
}
