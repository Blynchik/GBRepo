package junior.hw3;

import java.io.*;

public class Student implements Serializable {
    private String name;
    private int age;
    private transient double GPA;

    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    public static void packStudent(Student student) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream("box.bin");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(student);
            System.out.println(student.getName() + " сериализован.");
        }
    }

    public static Student unpackStudent() throws IOException, ClassNotFoundException {
        try (FileInputStream fileInputStream = new FileInputStream("box.bin");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Student student = (Student) objectInputStream.readObject();
            System.out.println(student.getName() + " десериализован.");
            return student;
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", GPA=" + GPA +
                '}';
    }
}
