package OOP.hw7.adapter;

public class Program {
    public static void main(String[] args) {
        BankAccount oceanBankAccount = new BankAccount();

        CoolHacker coolHacker = new CoolHacker(oceanBankAccount);
        coolHacker.hackBankAccount();
    }
}
