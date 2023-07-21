package core3;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        List<AbstractWorker> workers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            AbstractWorker temporaryWorker = new TemporaryWorker((int) (Math.random() * 90 + 10));
            workers.add(temporaryWorker);

            AbstractWorker permanentWorker = new PermanentWorker((int) (Math.random() * 19000 + 1000));
            workers.add(permanentWorker);
        }

        Collections.sort(workers);

        for(AbstractWorker worker : workers){
            System.out.println(worker.getAverageSalary());
        }

        WorkerStorage workerStorage = new WorkerStorage();

        workerStorage.setWorkers(workers);
        System.out.println("=====================");
        workerStorage.printWorkers();
    }
}
