package core3;

import java.util.ArrayList;
import java.util.List;

public class WorkerStorage {

    private AbstractWorker[] workers;

    public WorkerStorage(int numOfWorkers){
        workers = new AbstractWorker[numOfWorkers];
    }

    public void printWorkers(){
        for(AbstractWorker worker:workers){
            System.out.println(worker);
        }
    }

    public void setWorkers(AbstractWorker[] workers){
        this.workers = workers;
    }
}
