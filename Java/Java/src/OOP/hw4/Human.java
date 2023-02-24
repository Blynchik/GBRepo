package OOP.hw4;

public class Human {

    private static int seq;

    private int id;
    private String name;
    private String surname;
    private int age;
    private String profession;

    public Human(String name, String surname, int age, String profession) {
        seq +=1;
        this.id = seq;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.profession = profession;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "\nid:" + id +
                ", " + name +
                " " + surname +
                ", age:" + age +
                ", " + profession;
    }
}
