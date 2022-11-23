// See https://aka.ms/new-console-template for more information

//Задача 54: Задайте двумерный массив. Напишите программу, 
//которая упорядочит по убыванию элементы каждой строки двумерного массива.


int[,] makeArray()
{
    int x = new Random().Next(2, 11);
    int y = new Random().Next(2, 11);
    int[,] array = new int[y, x];

    for (int i = 0; i < y; i++)
    {
        for (int j = 0; j < x; j++)
        {
            array[i, j] = new Random().Next(-10, 11);
        }
    }

    return array;
}

int[,] makeOrderInStroke(int[,] array)
{
    for (int i = 0; i < array.GetLength(0); i++)
    {
        for (int j = 0; j < array.GetLength(1); j++)
        {
            for (int k = 0; k < array.GetLength(1); k++)
            {
                if (k != array.GetLength(1) - 1)
                {
                    if (array[i, k] < array[i, k + 1] && k + 1 <= array.GetLength(1) - 1)
                    {
                        int temp = array[i, k + 1];
                        array[i, k + 1] = array[i, k];
                        array[i, k] = temp;
                    }
                }
            }
        }
    }

    return array;
}

void showArray(int[,] array)
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

void Task54()
{
    System.Console.WriteLine("Задача 54: Задайте двумерный массив. Напишите программу, которая упорядочит по убыванию элементы каждой строки двумерного массива.");
    int[,] array = makeArray();
    System.Console.WriteLine("Первоначальный массив");
    showArray(array);
    System.Console.WriteLine();
    System.Console.WriteLine("Конечный массив");
    showArray(makeOrderInStroke(array));
}

//Задача 56: Задайте прямоугольный двумерный массив.
//Напишите программу, которая будет находить строку с наименьшей суммой элементов.

int[,] makeRectangleArray()
{
    int x;
    int y;

    do
    {
        x = new Random().Next(2, 11);
        y = new Random().Next(2, 11);
    }
    while (x == y);

    int[,] array = new int[y, x];

    for (int i = 0; i < y; i++)
    {
        for (int j = 0; j < x; j++)
        {
            array[i, j] = new Random().Next(-10, 11);
        }
    }

    return array;
}

int countSumInStroke(int[,] array)
{
    int min = int.MaxValue;
    int stroke = -1;
    for (int i = 0; i < array.GetLength(0); i++)
    {
        int sum = 0;
        for (int j = 0; j < array.GetLength(1); j++)
        {
            sum += array[i, j];
            if (min > sum)
            {
                min = sum;
                stroke = i;
            }
        }
        System.Console.WriteLine("Сумма: " + sum);
    }

    return stroke + 1;
}

void Task56()
{
    System.Console.WriteLine("Задача 56: Задайте прямоугольный двумерный массив.Напишите программу, которая будет находить строку с наименьшей суммой элементов.");
    int[,] array = makeRectangleArray();
    showArray(array);
    System.Console.WriteLine();
    System.Console.WriteLine("Наименьшая сумма чисел в " +
    countSumInStroke(array) + " строке");
}

//Задача 58: Задайте две матрицы. Напишите программу,
//которая будет находить произведение двух матриц.

int[,] matrixProduct(int[,] arrayA, int[,] arrayB)
{
    int[,] arrayC = new int[arrayA.GetLength(0), arrayB.GetLength(1)];

    for (int i = 0; i < arrayC.GetLength(0); i++)
    {
        for (int j = 0; j < arrayC.GetLength(1); j++)
        {
            for (int k = 0; k < arrayA.GetLength(1); k++)
            {
                arrayC[i, j] += arrayA[i, k] * arrayB[k, j];
            }
        }
    }
    return arrayC;
}

void Task58()
{
    System.Console.WriteLine("Задача 58: Задайте две матрицы. Напишите программу,которая будет находить произведение двух матриц.");
    int[,] arrayA;
    int[,] arrayB;

    do
    {
        arrayA = makeRectangleArray();
        arrayB = makeRectangleArray();
    }
    while (arrayA.GetLength(0) != arrayB.GetLength(1) || arrayA.GetLength(1) != arrayB.GetLength(0));

    System.Console.WriteLine("Первый массив");
    showArray(arrayA);
    System.Console.WriteLine();

    System.Console.WriteLine("Второй массив");
    showArray(arrayB);
    System.Console.WriteLine();

    System.Console.WriteLine("Их произведение");
    showArray(matrixProduct(arrayA, arrayB));
}

//Задача 60. ...Сформируйте трёхмерный массив из неповторяющихся двузначных чисел. 
//Напишите программу, которая будет построчно выводить массив, добавляя индексы каждого элемента.
//Массив размером 2 x 2 x 2

int[] makeNums()
{
    int[] nums = new int[8];
    int num;

    for (int i = 0; i < 8; i++)
    {
        num = new Random().Next(10, 100);
        nums[i] = num;
    }
    return nums;
}

bool checkNums(int[] nums)
{
    bool repeat = false;

    for (int i = 0; i < nums.Length; i++)
    {
        for (int j = 0; j < nums.Length; j++)
        {
            if (nums[i] == nums[j] && i != j)
            {
                repeat = true;
            }
        }
    }
    return repeat;
}

int[,,] makeReapeatless3xArray(int[] nums)
{
    int[,,] array = new int[2, 2, 2];
    int l = 0;
    System.Console.WriteLine("Элементы трехмерного массива: ");
    for (int i = 0; i < array.GetLength(0); i++)
    {
        for (int j = 0; j < array.GetLength(1); j++)
        {
            for (int k = 0; k < array.GetLength(2); k++)
            {
                array[i, j, k] = nums[l];
                System.Console.Write(nums[l] + "(" + i + "," + k + "," + j + ")" + " ");
                l++;
            }
            System.Console.WriteLine();
        }
    }
    return array;
}

void Task60()
{
    int[] nums = makeNums();
    bool repeats = checkNums(nums);

    if (repeats)
    {
        Task60();
    }
    else
    {
        System.Console.WriteLine("Задача 60.Сформируйте трёхмерный массив из неповторяющихся двузначных чисел.");
        System.Console.WriteLine("Напишите программу, которая будет построчно выводить массив, добавляя индексы каждого элемента.Массив размером 2 x 2 x 2");
        makeReapeatless3xArray(nums);
    }
}

//Задача 62. Напишите программу, которая заполнит спирально массив 4 на 4.

int[,] fillArray4x4()
{
    int[,] array = new int[4, 4];
    int count = 0;
    int i = 0;
    int circles = 0;
    while(count != 4*4)
    {
        if(circles == 4)
        {
            i++;
            array = turnLeft(array);
        }

        for (int j = 0; j < 4; j++)
        {
            if(array[i,j]==0)
            {
            count++;
            array[i, j] = count;
            }
        }
        array = turnLeft(array);
        circles++;
    }

    return array;
}

int[,] turnLeft(int[,] array)
{
    int[,] result = new int[4, 4];
    for (int y = 0; y < 4; y++)
    {
        for (int x = 0; x < 4; x++)
        {
            result[y, x] = array[x, 4 - y - 1];
        }
    }
    return result;
}

void Task62()
{
    System.Console.WriteLine("Задача 62. Напишите программу, которая заполнит спирально массив 4 на 4.");
    showArray(fillArray4x4());
}

Task54();
System.Console.WriteLine("-------------");
Task56();
System.Console.WriteLine("-------------");
Task58();
System.Console.WriteLine("-------------");
Task60();
System.Console.WriteLine("-------------");
Task62();
