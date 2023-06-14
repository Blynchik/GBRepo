package exception;

public class HW1 {
    public static void main(String[] args) {
        //1. Реализуйте 3 метода, чтобы в каждом
        // из них получить разные исключения
//        getException(5); //Arithmetic Exception
//        getException(new int[]{1,2,3}); //ArrayIndexOutOfBoundsException
//        getException(new Integer("String")); //NumberFormatException

        //2. Посмотрите на код,
        // и подумайте сколько разных типов
        // исключений вы тут сможете получить?
//         int a = sum2d(new String[3][3]); //NumberFormatException
//         sum2d(new String[][]{null}); //NullPointerException
//         sum2d(new String[][]{{"1"},{"1"}}); //ArrayIndexOutOfBoundsException

        //3.Реализуйте метод, принимающий в качестве
        // аргументов два целочисленных массива, и
        // возвращающий новый массив, каждый элемент
        // которого равен разности элементов двух
        // входящих массивов в той же ячейке. Если
        // длины массивов не равны, необходимо как-то
        // оповестить пользователя.
//         task3(new int[]{1}, new int[]{5,4});

        //* Реализуйте метод, принимающий в качестве
        // аргументов два целочисленных массива,
        // и возвращающий новый массив, каждый
        // элемент которого равен частному элементов
        // двух входящих массивов в той же ячейке.
        // Если длины массивов не равны, необходимо
        // как-то оповестить пользователя. Важно:
        // При выполнении метода единственное
        // исключение, которое пользователь может
        // увидеть - RuntimeException, т.е. ваше.
//       extraTask(new int[]{0,5}, new int[]{5,0});
    }

    public static void getException(int a) {
        int b = a / 0;
    }

    public static void getException(int[] array) {
        int i = array[array.length];
    }

    public static void getException(Integer i) {
        int b = i + 1;
    }

    public static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) {
                int val = Integer.parseInt(arr[i][j]);
                sum += val;
            }
        }
        return sum;
    }

    public static int[] task3(int[] a1, int[] a2) {
        if (a1.length != a2.length) {
            throw new RuntimeException("Array lengths should be equal");
        }

        int[] result = new int[a1.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = a1[i] - a2[i];
        }

        return result;
    }
    public static int[] extraTask(int[] a1, int[] a2){
        if (a1.length != a2.length) {
            throw new RuntimeException("Array lengths should be equal");
        }

        int[] result = new int[a1.length];

        for (int i = 0; i < result.length; i++) {
            if(a2[i]==0){
                throw new RuntimeException("Zero dividing");
            }
            result[i] = a1[i]/a2[i];
        }

        return result;
    }
}
