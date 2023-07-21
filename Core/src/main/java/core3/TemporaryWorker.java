package core3;

public class TemporaryWorker extends AbstractWorker {
    private int hourPayment;

    public TemporaryWorker(int hourPayment) {
        super(hourPayment);
        this.hourPayment = hourPayment;
    }

    @Override
    public double getAverageSalary() {
        return 20.8 * 8 * hourPayment;
    }
}
