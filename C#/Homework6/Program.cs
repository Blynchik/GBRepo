// See https://aka.ms/new-console-template for more information

//Задача 41: Пользователь вводит с клавиатуры M чисел. 
//Посчитайте, сколько чисел больше 0 ввёл пользователь.

string ReadLine(string msg)
{
    System.Console.Write(msg);
    return Console.ReadLine();
}

int InsertStr(int startToCountFrom)
{
    string str = ReadLine("Введите число(q - выход): ");

    if (str != "q")
    {
        if (int.Parse(str) > 0)
        {
            return InsertStr(++startToCountFrom);
        }
        else
        {
            return InsertStr(startToCountFrom);
        }
    }
    return startToCountFrom;
}

void Task41()
{
    System.Console.WriteLine("Положительных чисел: " + InsertStr(0));
}

//Задача 43: Напишите программу, которая найдёт точку пересечения двух прямых, 
//заданных уравнениями y = k1 * x + b1,  y = k1 * x + b1; значения b1, k1, b2 и k2 задаются пользователем.

void Task43()
{
    double k1 = double.Parse(ReadLine("Введите k1: "));
    double b1 = double.Parse(ReadLine("Введите b1: "));
    double k2 = double.Parse(ReadLine("Введите k2: "));
    double b2 = double.Parse(ReadLine("Введите b2: "));

    if (k1 == k2)
    {
        System.Console.WriteLine("Прямые паралельны, точек пересечения нет.");
        return;
    }

    //y1 = k1 * x + b1;
    //y2 = k2 * x + b2;

    //k1*x+b1 = k2*x+b2;
    //k1*x-k2*x = b2-b1;
    //x(k1-k2) = b2-b1;
    //x = (b2-b1)/(k1-k2);

    double x = (b2 - b1) / (k1 - k2);

    double y = k1 * x + b1;

    System.Console.WriteLine("Точка пересечения: " + "[" + x + ";" + y + "]");


}

Task41();
System.Console.WriteLine("---------------");
Task43();