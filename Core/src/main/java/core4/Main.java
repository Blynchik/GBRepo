package core4;

public class Main {
    public static void main(String[] args) {
        ArrayExecutor arrayExecutor = new ArrayExecutor();
        String[][] array = {{"1", "2", "3", "4"},
                {"5", "6", "l", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"},
                {"13", "14", "15", "16"}};

        try {
            System.out.println(arrayExecutor.executeArray(array));
        } catch (MyArraySizeException | MyArrayDataException e){
            System.out.println(e.getMessage());
        }
    }
}
