package exception.hw3;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        String data = app.askData();

        try {
            String[] checked = app.checkData(data);
            app.validateData(checked);
            app.writeDataToFile(checked, checked[0]+".txt");
        } catch (IllegalStateException e){
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
