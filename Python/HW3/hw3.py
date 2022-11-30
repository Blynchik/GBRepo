#Задайте список из нескольких чисел. Напишите программу, 
#которая найдёт сумму элементов списка, стоящих на нечётной позиции.

nums = []
print('Введите числа, для выхода нажмите "q": ')
i = 0
num = input()
sum = 0
while num != 'q':
    nums.append(num)
    if i % 2 > 0:
        sum += int(num) 
    i += 1
    num = input()
else:
    print('Сумма чисел с нечетным индеком: ',sum)


#Напишите программу, которая найдёт произведение пар чисел списка. 
#Парой считаем первый и последний элемент, второй и предпоследний и т.д.
j = 0
if len(nums) % 2 > 0:
    iter = len(nums)//2 + 1
else:
    iter = len(nums)/2 

while j < iter:
    print(int(nums[0 + j]) * int(nums[len(nums) - j - 1]))
    j += 1

#Задайте список из вещественных чисел.
#Напишите программу, которая найдёт разницу между 
#максимальным и минимальным значением дробной части элементов.
floats = []
print('Введите вещественные числа, для выхода нажмите "q": ')
floatNum = input()
max = 0
min = 1

while floatNum != 'q':
    floats.append(floatNum)

    residue = float(floatNum) - int(float(floatNum))

    if residue > max:
        max = residue

    if residue < min:
        min = residue

    floatNum = input()
else:
    print('Разница между масимальным и минимальным остатками: ', max-min)

#Напишите программу, 
#которая будет преобразовывать десятичное число в двоичное.
toBin = int(input('Введите десятичное число: '))
residues = []
while True:
    residues.append(str(toBin%2))
    toBin = toBin//2

    if (toBin/1 - 0) < 1:
        break

bin = reversed(residues)

print('Двоичное представление:',''.join(bin))

#Задайте число. Составьте список чисел Фибоначчи, 
#в том числе для отрицательных индексов.
element = int(input('Введите число: '))
elements = [0,1]

while i < element*2 - 1:

    if i < element - 1:
        elements.append(elements[i] + elements[i+1])
    else:
        elements.insert(0, elements[1]-elements[0]) 
    i += 1
print('Числа Фибоначчи:',elements)