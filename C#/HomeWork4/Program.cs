// See https://aka.ms/new-console-template for more information

//Задача 25: Напишите цикл, который принимает на вход два числа (A и B) и возводит число A в натуральную степень B.
//* Написать калькулятор с операциями +, -, /, * и возведение в степень


string ReadData(string msg)
{
    System.Console.Write(msg);
    return Console.ReadLine();
}

long ToPower(int num, int power)
{
    long inPower = num;
    for (int i = 0; i < power; i++)
    {
        inPower = inPower * num;
    }
    return inPower;
}

long Add(int num1, int num2)
{
    return num1 + num2;
}

long Subtract(int num1, int num2)
{
    return num1 - num2;
}

long Multiply(int num1, int num2)
{
    return num1 * num2;
}

long Divide(int num1, int num2)
{
    return num1 / num2;
}

void OutputData(string msg, string data)
{
    System.Console.Write(msg);
    System.Console.Write(data);
}

string AskedOperation()
{
    System.Console.Write("Введите операцию (+, -, /, *, ^): ");
    string operation = Console.ReadLine();

    if (operation.Equals("+") ||
    operation.Equals("-") ||
    operation.Equals("/") ||
    operation.Equals("*") ||
    operation.Equals("^"))
    {
        return operation;
    }
    return "Ошибка";
}

void Task25()
{
    int num1;
    int num2;

    if (AskedOperation().Equals("+"))
    {
        num1 = int.Parse(ReadData("Введите первое число: "));
        num2 = int.Parse(ReadData("Введите второе число: "));
        OutputData(num1 + " + " + num2 + " = ", (Add(num1, num2).ToString()));
        System.Console.WriteLine();
    }

    if (AskedOperation().Equals("-"))
    {
        num1 = int.Parse(ReadData("Введите первое число: "));
        num2 = int.Parse(ReadData("Введите второе число: "));
        OutputData(num1 + " - " + num2 + " = ", (Subtract(num1, num2).ToString()));
        System.Console.WriteLine();
    }

    if (AskedOperation().Equals("/"))
    {
        num1 = int.Parse(ReadData("Введите делимое: "));
        num2 = int.Parse(ReadData("Введите делитель: "));
        OutputData(num1 + " / " + num2 + " = ", (Divide(num1, num2).ToString()));
        System.Console.WriteLine();
    }

    if (AskedOperation().Equals("*"))
    {
        num1 = int.Parse(ReadData("Введите множитель: "));
        num2 = int.Parse(ReadData("Введите множитель: "));
        OutputData(num1 + " * " + num2 + " = ", (Multiply(num1, num2).ToString()));
        System.Console.WriteLine();
    }

    if (AskedOperation().Equals("^"))
    {
        num1 = int.Parse(ReadData("Введите число: "));
        num2 = int.Parse(ReadData("Введите степень: "));
        OutputData(num1 + " ^ " + num2 + " = ", (ToPower(num1, num2).ToString()));
        System.Console.WriteLine();
    }

    if (AskedOperation().Equals("Ошибка"))
    {
        System.Console.WriteLine(AskedOperation());
        return;
    }
}

Task25();