// See https://aka.ms/new-console-template for more information

//Задача 47. Задайте двумерный массив размером m×n, 
//заполненный случайными вещественными числами.

string Read(string msg)
{
    System.Console.WriteLine(msg);
    return Console.ReadLine();
}

double[,] fillArray(int m, int n)
{
    double[,] array = new double[m, n];

    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            array[i, j] = new Random().NextDouble() * 20 - 10;
        }
    }

    return array;
}

void showArray(double[,] array)
{
    for (int i = 0; i < array.GetLength(0); i++)
    {
        for (int j = 0; j < array.GetLength(1); j++)
        {
            System.Console.Write(array[i, j] + " ");
        }
        System.Console.WriteLine();
    }
}

void Task47()
{
    int m = int.Parse(Read("Введите количество строк: "));
    int n = int.Parse(Read("Введите количество столбцов: "));
    showArray(fillArray(m, n));
}

//Задача 50. Напишите программу, которая на вход принимает позиции элемента 
//в двумерном массиве, и возвращает значение этого элемента или же указание,
//что такого элемента нет.

double returnValue(int y, int x)
{
    double[,] array = fillArray(5, 5);
    showArray(array);

    if (y <= array.GetLength(0) && x <= array.GetLength(1) && y > 0 && x > 0)
    {
        System.Console.Write("Искомое число: ");
        return array[y - 1, x - 1];
    }

    System.Console.WriteLine("Такого элемента не существует");
    return 0.0;
}

void Task50()
{
    System.Console.WriteLine(
    returnValue(int.Parse(Read("Введите строку: ")),
        int.Parse(Read("Введите столбец: "))));
}

//Задача 52. Задайте двумерный массив из целых чисел. 
//Найдите среднее арифметическое элементов в каждом столбце.

int[,] fillIntArray(int m, int n)
{
    int[,] array = new int[m, n];

    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            array[i, j] = new Random().Next(-9, 10);
            System.Console.Write(array[i, j] + " ");
        }
        System.Console.WriteLine();
    }

    System.Console.WriteLine("-----");

    return array;
}

void calculateMAInColumns(int[,] array)
{
    for (int k = 0; k < array.GetLength(1); k++)
    {
        int sum = 0;

        for (int i = 0; i < array.GetLength(0); i++)
        {

            for (int j = 0; j < array.GetLength(1); j++)
            {
                if (j == k)
                {
                    sum += array[i, k];
                }
            }
        }
        System.Console.Write(sum + " ");
    }
}

void Task52()
{
    calculateMAInColumns(fillIntArray(5, 5));
}

Task47();
System.Console.WriteLine("------------------------");
Task50();
System.Console.WriteLine("------------------------");
Task52();



