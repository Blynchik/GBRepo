package jdk.hw4;

import java.util.ArrayList;
import java.util.List;

public class GuideBook {
    private List<Employee> employees;

    public GuideBook() {
        employees = new ArrayList<>();
        employees.add(new Employee(1L, "+7900...", "Вася", 10));
        employees.add(new Employee(2L, "+7901...", "Коля", 11));
        employees.add(new Employee(3L, "+7903...", "Светлана", 12));
        employees.add(new Employee(4L, "+7904...", "Коля", 10));
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployeesByExp(Integer exp) {
        List<Employee> result = new ArrayList<>();
        employees.forEach(e -> {
            Integer cur = e.getExp();
            if (cur.equals(exp)) {
                result.add(e);
            }
        });
        return result;
    }

    public List<String> getPhoneByName(String name) {
        List<String> result = new ArrayList<>();
        employees.forEach(e -> {
            String cur = e.getName();
            if (cur.equals(name)) {
                result.add(e.getPhone());
            }
        });
        return result;
    }

    public Employee getEmployeeByNum(Long num) {
        for (Employee e : employees) {
            if (e.getNum().equals(num)) {
                return e;
            }
        }
        return null;
    }

    public boolean addEmployee(Employee employee){
        return employees.add(employee);
    }
}
