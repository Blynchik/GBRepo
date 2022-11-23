// See https://aka.ms/new-console-template for more information
//Задача 64: Задайте значение N. Напишите программу, которая выведет
//все натуральные числа в промежутке от N до 1. Выполнить с помощью рекурсии.

string getNum(string msg)
{
    System.Console.Write(msg);
    return Console.ReadLine();
}

void Nplus1(int n)
{
    if (n > 0)
    {
        System.Console.Write(n + " ");
        n--;
        Nplus1(n);
    }
    return;
}

void Task64()
{
    System.Console.WriteLine("Задача 64: Задайте значение N. Напишите программу, которая выведет");
    System.Console.WriteLine("все натуральные числа в промежутке от N до 1. Выполнить с помощью рекурсии.");
    int n = int.Parse(getNum("Введите число: "));
    Nplus1(n);
    System.Console.WriteLine();
}

//Задача 66: Задайте значения M и N. Напишите программу, которая найдёт сумму натуральных элементов в промежутке от M до N.

bool checkNums(int m, int n)
{
    if (m < n)
    {
        return true;
    }
    System.Console.WriteLine("Число M должно быть меньше N ");
    return false;
}

void Task66()
{
    int m = int.Parse(getNum("Введите число M: "));
    int n = int.Parse(getNum("Введите число N: "));
    if(checkNums(m,n))
    {
        int sum = 0;
        do{
           sum+=m;
            m++; 
        }
        while(m <= n);
        System.Console.WriteLine("Сумма натуральных чисел между M и N: " + sum);
    }
}

//Задача 68: Напишите программу вычисления функции Аккермана с помощью рекурсии. Даны два неотрицательных числа m и n.

int A (int m, int n)
{
   if (m == 0)
    return n + 1;
  else
    if ((m != 0) && (n == 0)){
      return A(m - 1, 1);
    }
    else
      return A(m - 1, A(m, n - 1));
}

void Task68()
{
    int m = int.Parse(getNum("Введите число M: "));
    int n = int.Parse(getNum("Введите число N: "));
    int a = A(m,n);
    System.Console.WriteLine("Число: "+ a);
}

Task64();
System.Console.WriteLine("-----------");
Task66();
System.Console.WriteLine("-----------");
Task68();

