package OOP.hw7.adapter;

public class CoolHacker implements HackTool{

    private BankAccount bankAccount;

    public CoolHacker(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void hackBankAccount() {
        System.out.println("Дело сделано, в кармане " + this.bankAccount.getMoney());
    }
}
