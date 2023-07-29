package core4;

public class ArrayExecutor {

    public int executeArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        int row = 0;
        int column = 0;
        try {
            for (int i = 0; i < array.length; i++) {
                String[] inner = array[i];
                row = i;
                for (int j = 0; j < inner.length; j++) {
                    column = j;
                    sum+=Integer.parseInt(array[i][j]);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e){
            throw new MyArraySizeException();
        } catch (NumberFormatException e){
            throw new MyArrayDataException(row, column);
        }
        return sum;
    }
}
