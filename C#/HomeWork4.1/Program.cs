// See https://aka.ms/new-console-template for more information

//Задача 27: Напишите программу, которая принимает на вход число и выдаёт сумму цифр в числе.
//* Сделать оценку времени алгоритма через вещественные числа и строки

string ReadData(string msg)
{
    System.Console.Write(msg);
    return Console.ReadLine();
}

void OutputData(string msg, string data)
{
    System.Console.Write(msg);
    System.Console.Write(data);
    System.Console.WriteLine();
}

int SumOfNums(long num)
{
    int addedNum = 0;
    int sum = 0;
    while (num >= 1)
    {
        addedNum = (int)num % 10;
        sum = sum + addedNum;
        num = num / 10;
    }
    return sum;
}

void Task27()
{
    long num = long.Parse(ReadData("Введите число: "));
    DateTime begin = DateTime.Now;
    int sum = SumOfNums(num);
    DateTime end = DateTime.Now;
    OutputData("Сумма чисел: ", sum.ToString());
    double time = ((double)end.Millisecond - (double)begin.Millisecond) / 1000.0;
    System.Console.WriteLine("Решение задачи 27 заняло: " + time + " секунды");
}

Task27();