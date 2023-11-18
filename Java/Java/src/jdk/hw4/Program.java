package jdk.hw4;

public class Program {
    public static void main(String[] args) {
        GuideBook guideBook = new GuideBook();
        System.out.println(guideBook.getEmployeesByExp(10));
        System.out.println(guideBook.getPhoneByName("Коля"));
        System.out.println(guideBook.getEmployeeByNum(1L));
        guideBook.addEmployee(new Employee(6L, "+7910...", "Игорь", 15));
        System.out.println(guideBook.getEmployees());
    }
}
