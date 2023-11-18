package jdk.hw4;

public class Employee {

    private Long num;
    private String phone;
    private String name;
    private Integer exp;

    public Employee(Long num,
                    String phone,
                    String name,
                    Integer exp){
        this.num = num;
        this.phone = phone;
        this.name = name;
        this.exp = exp;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "num=" + num +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", exp=" + exp +
                '}';
    }
}
