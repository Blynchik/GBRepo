// See https://aka.ms/new-console-template for more information

//Задача 2:Напишите программу, которая на вход принимает два числа и выдаёт, какое число большее, а какое меньшее.
System.Console.WriteLine("Задача 2: Напишите программу, которая на вход принимает два числа и выдаёт, какое число большее, а какое меньшее.");
System.Console.WriteLine("Введите два числа.");
System.Console.Write("Первое число: ");
int a = int.Parse(Console.ReadLine());
System.Console.Write("Второе число: ");
int b = int.Parse(Console.ReadLine());

if (a > b)
{
    System.Console.WriteLine("Первое число больше второго " + a + " > " + b);
    System.Console.WriteLine("max = " + a);
}
else
{
    System.Console.WriteLine("Второе число больше первого " + b + ">" + a);
    System.Console.WriteLine("max = " + b);
}

System.Console.WriteLine("----------------------------------------");



//Задача 4: Напишите программу, которая принимает на вход три числа и выдаёт максимальное из этих чисел.
System.Console.WriteLine("Задача 4: Напишите программу, которая принимает на вход три числа и выдаёт максимальное из этих чисел.");
System.Console.WriteLine("Введите три числа.");
System.Console.Write("Первое число: ");
int first = int.Parse(Console.ReadLine());
System.Console.Write("Второе число: ");
int second = int.Parse(Console.ReadLine());
System.Console.Write("Третье число: ");
int third = int.Parse(Console.ReadLine());

int max = first;
if (max < second)
{
    max = second;
}
if (max < third)
{
    max = third;
}
System.Console.WriteLine("Самое большое число: " + max);


System.Console.WriteLine("----------------------------------------");



//Задача 6: Напишите программу, которая на вход принимает число и выдаёт, является ли число чётным (делится ли оно на два без остатка).
System.Console.WriteLine("Задача 6: Напишите программу, которая на вход принимает число и выдаёт, является ли число чётным (делится ли оно на два без остатка).");
System.Console.Write("Введите число: ");
int num = int.Parse(Console.ReadLine());

if (num % 2 == 0)
{
    System.Console.WriteLine(num + " - четное");
}
else
{
    System.Console.WriteLine(num + " - нечетное");
}

System.Console.WriteLine("----------------------------------------");



//Задача 8: Напишите программу, которая на вход принимает число (N), а на выходе показывает все чётные числа от 1 до N.
System.Console.WriteLine("Задача 8: Напишите программу, которая на вход принимает число (N), а на выходе показывает все чётные числа от 1 до N.");
System.Console.Write("Введите число: ");
int N = int.Parse(Console.ReadLine());

System.Console.Write("Все четные числа от 1 до " + N + ": ");
if (N % 2 != 0)
{
    N = N - 1;
}

int count = 2;
while (count <= N)
{
    System.Console.Write(count + " ");
    count = count + 2;
}



