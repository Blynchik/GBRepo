package junior.hw3;

import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student("Вася", 18, 4.20 );
        Student.packStudent(student);
        Student des = Student.unpackStudent();
        System.out.println(des);
    }
}
