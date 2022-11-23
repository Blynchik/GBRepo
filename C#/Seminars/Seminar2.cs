class Seminar2
{
    public static void main(string[] args)
    {
        Seminar2 seminar2 = new Seminar2();
        seminar2.WriteTwo();
        seminar2.WriteHello("Vadim");
        int[] array = seminar2.arrayNumberCreator(6);
        seminar2.arrayPrinter(array); 
    }

    void WriteTwo()
    {
        System.Console.WriteLine(2);
    }

    void WriteHello(string name)
    {
        System.Console.WriteLine("Hello, " + name);
    }

    int[] arrayNumberCreator(int size)
    {
        int[] array = new int[size];
        for (int i = 0; i < size; i++)
        {
            array[i] = i;
        }
        return array;
    }

    void arrayPrinter(int[] array)
    {
        for(int i = 0; i<array.Length;i++)
        {
            System.Console.Write(i);
        }
    }
}