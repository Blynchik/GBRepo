// See https://aka.ms/new-console-template for more information

//Задача 10: Напишите программу, которая принимает на вход 
//трёхзначное число и на выходе показывает вторую 
//цифру этого числа.
void solveTask10(int n)
{
    while (n / 100 < 1 || n / 100 > 9)
    {
        System.Console.WriteLine("Число " + n + " не трехзначное");
        System.Console.Write("Введите трехзначное число: ");
        n = int.Parse(Console.ReadLine());
    }

    n = n / 10 % 10;
    System.Console.WriteLine("Второе число: " + n);
    System.Console.WriteLine("------------------");
}

//Задача 13: Напишите программу, которая выводит 
//третью цифру заданного числа или сообщает, 
//что третьей цифры нет.
void solveTask13(int n)
{
    while (n / 100 < 1)
    {
        System.Console.WriteLine("У числа " + n + " нет третьего числа");
        System.Console.Write("Введите число: ");
        n = int.Parse(Console.ReadLine());
    }

    while (n / 100 < 1 || n / 100 > 9)
    {
        n = n / 10;
    }

    n = n % 10;
    System.Console.WriteLine("Третье число: " + n);
    System.Console.WriteLine("------------------");
}

//Задача 15: Напишите программу, которая принимает
//на вход цифру, обозначающую день недели, и проверяет,
//является ли этот день выходным.
void solveTask15(int n)
{
    while (n < 1 || n > 7)
    {
        System.Console.WriteLine(n + " - это не день недели.");
        System.Console.Write("Введите день недели:");
        n = int.Parse(Console.ReadLine());
    }

    if (n >= 1 && n <= 5)
    {
        System.Console.WriteLine("Слышь, работать!");
    }
    else if (n > 5)
    {
        System.Console.Write("Выходной: ");
        if (n == 6)
        {
            System.Console.Write("Суббота");
        }
        else
        {
            System.Console.WriteLine("Воскресенье");
        }
    }
    System.Console.WriteLine("------------------");
}

solveTask10(5);
solveTask13(99);
solveTask15(345);
