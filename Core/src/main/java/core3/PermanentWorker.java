package core3;

public class PermanentWorker extends AbstractWorker {
    private int salary;

    public PermanentWorker(int salary) {
        super(salary);
        this.salary = salary;
    }

    @Override
    public double getAverageSalary() {
        return this.salary;
    }
}
