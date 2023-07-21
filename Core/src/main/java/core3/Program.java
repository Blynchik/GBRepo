package core3;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        AbstractWorker[] workers = new AbstractWorker[10];

        for (int i = 0; i < 10; i += 2) {
            AbstractWorker temporaryWorker = new TemporaryWorker((int) (Math.random() * 90 + 10));
            workers[i] = temporaryWorker;

            AbstractWorker permanentWorker = new PermanentWorker((int) (Math.random() * 19000 + 1000));
            workers[i + 1] = permanentWorker;
        }

        for (AbstractWorker worker : workers) {
            System.out.println(worker);
        }

        for (int i = 0; i < workers.length - 1; i++) {
            for (int j = 0; j < workers.length - i - 1; j++) {
                if (workers[j].compareTo(workers[j + 1]) > 0) {
                    AbstractWorker temp = workers[j];
                    workers[j] = workers[j + 1];
                    workers[j + 1] = temp;
                }
            }
        }

        for (AbstractWorker worker : workers) {
            System.out.println(worker.getAverageSalary());
        }

        WorkerStorage workerStorage = new WorkerStorage(10);

        workerStorage.setWorkers(workers);
        System.out.println("=====================");
        workerStorage.printWorkers();
    }
}
