package core4;

public class MyArrayDataException extends Exception {
    int row;
    int column;

    public MyArrayDataException(int row, int column) {
        super("Не удалось преобразовать в число элемент в строке " + (row+1) + " в столбце " + (column+1));
        this.row = row;
        this.column = column;
    }
}
