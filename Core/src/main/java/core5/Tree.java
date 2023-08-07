package core5;

import java.io.File;

/**
 * TODO: Доработать метод print, необходимо распечатать директории и файлы на экран
 */
public class Tree {

    public static void print(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());


        File[] files = file.listFiles();

        int subDirTotal = 0;
        int subFileTotal = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                subDirTotal++;
            }

            if (files[i].isFile()) {
                subFileTotal++;
            }
        }

        int subDirCounter = 0;
        int subFileCounter = 0;
        for (File value : files) {
            if (value.isDirectory()) {
                subDirCounter++;
                print(value, indent, subDirCounter == subDirTotal);
            } else {
                subFileCounter++;
                printFile(value, indent, subFileCounter == subFileTotal);
            }
        }
    }

    private static void printFile(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());
    }
}
