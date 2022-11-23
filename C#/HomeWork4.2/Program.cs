// See https://aka.ms/new-console-template for more information

//№29 Напишите программу, которая задаёт массив из 8 элементов и выводит их на экран.
//* Ввести с клавиатуры длину массива и диапазон значений элементов 
//*Дополнительно: Написать программу которая из имен через запятую выберет случайное
//имя и выведет в терминал

string ReadData(string msg)
{
    System.Console.Write(msg);
    return Console.ReadLine();
}

string[] CreateArray(int length)
{
    string[] friends = new string[length];
    for (int i = 0; i < length; i++)
    {
        friends[i] = ReadData("Введите имя: ");
    }
    return friends;
}

int GetRandomNum(int maxBorder)
{
    return new Random().Next(1, maxBorder);
}

void Task29 ()
{
    int length = int.Parse(ReadData("Сколько вас человек? "));
    string[] array = CreateArray(length);
    System.Console.WriteLine("За пивом пойдет " + array[GetRandomNum(length)]);
}

Task29();