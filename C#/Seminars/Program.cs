// See https://aka.ms/new-console-template for more information
int number = 5;
string name1 = "Name";
float x = 2.45f;
bool flag = true;
double x2 = 5.4525223d;
char c = 'A';
var r = "T";

//cw - System.Console.WriteLine();
//dotnet new console - new project
//dotnet run - run
//shift+alt+f - tab

int months = 12;
System.Console.WriteLine("Месяцев в году " + months);
string n = months.ToString();
System.Console.WriteLine("Введите ваше имя");
//string name = Console.ReadLine();
//Console.WriteLine("Привет, "+ name+" !");
System.Console.WriteLine("Сколько вам лет?");
//int age = int.Parse(Console.ReadLine());
//System.Console.WriteLine("Вам "+ age + " лет");
System.Console.WriteLine("Введите число A");
//string cA = Console.ReadLine();
//string bA = Console.ReadLine();
//System.Console.WriteLine(cA)+(bA);
//System.Console.WriteLine(A);
int a = 5;
int b = 6;

if (a > b)
{
    System.Console.WriteLine("Число a больше b ");
}
else if (b > a)
{
    System.Console.WriteLine("Число b больше a");
}

System.Console.WriteLine("Угадай число");
int tries = 3;
int random = new Random().Next(1, 11);
Boolean win = false;
while (tries > 0)
{
    System.Console.WriteLine("Осталось попыток " + tries);
    System.Console.WriteLine("Введите число от 1 до 10");
    int userNumber = int.Parse(Console.ReadLine());
    if (userNumber == random)
    {
        win = true;
        System.Console.WriteLine("Вы угадали!");
        break;
    }
    else if (userNumber<random)
    {
        System.Console.WriteLine("Число больше");
    } 
    else if (userNumber > random)
    {
        System.Console.WriteLine("Число меньше");
    }
    System.Console.WriteLine();
    tries--;
}
if (win == false)
{
    System.Console.WriteLine("Вы проиграли!");
}
