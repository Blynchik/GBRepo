package core3;

import java.util.Comparator;

public abstract class AbstractWorker implements Comparable<AbstractWorker> {
    protected int payment;

    public AbstractWorker(int payment){
        this.payment = payment;
    }

    public abstract double getAverageSalary();

    @Override
    public int compareTo(AbstractWorker o) {
        if (this.getAverageSalary() > o.getAverageSalary()) {
            return 1;
        }

        if (this.getAverageSalary() < o.getAverageSalary()) {
            return -1;
        }
//        return Double.compare(this.getAverageSalary(), o2.getAverageSalary());
        return 0;
    }

    @Override
    public String toString() {
        return "AbstractWorker{" +
                "payment=" + payment +
                '}';
    }
}
