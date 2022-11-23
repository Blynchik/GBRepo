// See https://aka.ms/new-console-template for more information

//Напишите программу, которая принимает на вход пятизначное число
//и проверяет, является ли оно палиндромом.

bool isPalindrome(int number)
{

    int number2 = number;
    int divider = 10000;
    bool isPalindrome = false;
    int count = 0;

    while (count < 2)
    {
        if (number2 % 10 == number / divider % 10)
        {
            isPalindrome = true;
        }
        else
        {
            isPalindrome = false;
            break;
        }
        divider = divider / 10;
        number2 = number2 / 10;
        count++;
    }

    return isPalindrome;
}


//Напишите программу, которая принимает на вход координаты 
//двух точек и находит расстояние между ними в 3D пространстве.

double distance(int Ax, int Ay, int Az, int Bx, int By, int Bz)
{

    double distance = Math.Sqrt(Math.Pow(Bx - Ax, 2) + Math.Pow(By - Ay, 2) + Math.Pow(Bz - Az, 2));

    return distance;
}


//Напишите программу, которая принимает на вход число (N) 
//и выдаёт таблицу кубов чисел от 1 до N.
void coubs(int N)
{
    int count = 1;

    while (count <= N)
    {
        System.Console.Write(Math.Pow(count, 3));
        if (count < N)
        {
            System.Console.Write(", ");
        }
        count++;
    }
}

System.Console.Write("Введите пятизначное число: ");
int num = int.Parse(Console.ReadLine());
System.Console.WriteLine("Это число палиндром? - " + isPalindrome(num));
System.Console.WriteLine("-----------------------");

System.Console.WriteLine("Введите 3 координаты для точки A");
System.Console.Write("x: ");
int Ax = int.Parse(Console.ReadLine());
System.Console.Write("y: ");
int Ay = int.Parse(Console.ReadLine());
System.Console.Write("z: ");
int Az = int.Parse(Console.ReadLine());
System.Console.WriteLine();

System.Console.WriteLine("Введите 3 координаты для точки B");
System.Console.Write("x: ");
int Bx = int.Parse(Console.ReadLine());
System.Console.Write("y: ");
int By = int.Parse(Console.ReadLine());
System.Console.Write("z: ");
int Bz = int.Parse(Console.ReadLine());

System.Console.WriteLine("Расстояние между точками: " + distance(Ax, Ay, Az, Bx, By, Bz));
System.Console.WriteLine("-----------------------");

System.Console.Write("Введите число: ");
int N = int.Parse(Console.ReadLine());
coubs(N);

