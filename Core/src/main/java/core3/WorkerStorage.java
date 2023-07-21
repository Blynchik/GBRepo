package core3;

import java.util.ArrayList;
import java.util.List;

public class WorkerStorage {

    private List<AbstractWorker> workers;

    public WorkerStorage(){
        workers = new ArrayList<>();
    }

    public void printWorkers(){
        for(AbstractWorker worker:workers){
            System.out.println(worker);
        }
    }

    public void setWorkers(List<AbstractWorker> workers){
        this.workers = workers;
    }
}
