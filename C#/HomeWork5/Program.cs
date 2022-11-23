// See https://aka.ms/new-console-template for more information

//Задача 34: Задайте массив заполненный случайными положительными 
//трёхзначными числами. Напишите программу, которая покажет 
//количество чётных чисел в массиве.

int[] CreateArray(int length)
{
    int[] array = new int[length];

    System.Console.Write("Массив: ");
    for (int i = 0; i < array.Length; i++)
    {
        array[i] = new Random().Next(100, 1000);
        System.Console.Write(array[i] + " ");
    }
    System.Console.WriteLine();

    return array;
}

int CountEven(int[] array)
{
    int count = 0;

    for (int i = 0; i < array.Length; i++)
    {
        if (array[i] % 2 == 0)
        {
            count++;
        }
    }
    return count;
}

string AskData(string msg)
{
    System.Console.Write(msg);
    return Console.ReadLine();
}

void Task34()
{
    System.Console.WriteLine("Создаем массив из случайных трехзначных чисел....");
    int[] array = CreateArray(int.Parse(AskData("Введите размер массива: ")));
    int count = CountEven(array);
    System.Console.WriteLine("В нем " + count + " четных чисел.");
}

System.Console.WriteLine();
Task34();

//Задача 36: Задайте одномерный массив, заполненный случайными числами. 
//Найдите сумму элементов, стоящих на нечётных позициях.

int SumOfNumsOnOddPositions(int[] array)
{
    int sum = 0;

    for (int i = 0; i < array.Length; i++)
    {
        if (i % 2 != 0)
        {
            sum = sum + array[i];
        }
    }

    return sum;
}

void Task36()
{
    System.Console.WriteLine("Создаем массив из случайных чисел....");
    int[] array = CreateArray(int.Parse(AskData("Введите размер массива: ")));
    int sum = SumOfNumsOnOddPositions(array);
    System.Console.WriteLine("Сумма чисел на нечетных позициях: " + sum);
}

System.Console.WriteLine();
Task36();

//Задача 38: Задайте массив вещественных чисел. 
//Найдите разницу между максимальным и минимальным элементов массива.

double[] CreateArrayWithDouble(int length)
{
    double[] array = new double[length];

    System.Console.Write("Массив: ");
    for (int i = 0; i < array.Length; i++)
    {
        array[i] = new Random().NextDouble() * 100.0;
        System.Console.Write(array[i] + " ");
    }
    System.Console.WriteLine();

    return array;
}

double FindDifferenceBetweenMaxAndMin(double[] array)
{
    double max = array[0];
    double min = array[0];

    for (int i = 0; i < array.Length; i++)
    {
        if (array[i] < min)
        {
            min = array[i];
        }

        if (array[i] > max)
        {
            max = array[i];
        }
    }

    System.Console.WriteLine("Максимальное: " + max);
    System.Console.WriteLine("Минимальное: " + min);

    return max - min;
}

void Task38()
{
    System.Console.WriteLine("Создаем массив из случайных вещественных чисел....");
    double[] array = CreateArrayWithDouble(int.Parse(AskData("Введите размер массива: ")));
    double difference = FindDifferenceBetweenMaxAndMin(array);
    System.Console.WriteLine("Разница между максимальным и миниальным: " + difference);
}

System.Console.WriteLine();
Task38();
