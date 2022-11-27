#Напишите программу, которая принимает на вход вещественное число 
#и показывает сумму его цифр.
a = float(input('Введите число: '))
sum = 0
str = str(a)

for i in str:
    if i != '.':
        sum +=int(i)

print('Сумма:',sum)

#Напишите программу, которая принимает на вход число N 
#и выдает набор произведений чисел от 1 до N.
b = int(input('Введите целое число: '))
list = [1]
mult = 1

while mult != b:
    mult += 1
    list.append(mult*list[len(list)-1])
else:
    print(list)

#Задайте список из n чисел последовательности 
#(1 + 1 / n) ** n и выведите на экран их сумму.
c = int(input('Введите цело число: '))
list = []
inc = 1
sum = 0
while inc <= c:
    list.append((1+1/inc)**inc)
    sum += list[inc-1]
    inc += 1
else:
    print(list)
    print('Сумма:', sum)

#Реализуйте алгоритм перемешивания списка.
import random
list = [1,2,3,4,5,6,7,8,9,10]
print(list)
random.shuffle(list)
print(list)
