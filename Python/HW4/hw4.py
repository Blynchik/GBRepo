import math

# Вычислить число pi c заданной точностью d
def task1():
    d = float(input('Введите точность (0.001): '))
    cycles = 0

    while d <= 1 :
        d *= 10
        cycles += 1
        
    print(f"{math.pi:.{cycles}}")

# Задайте натуральное число N. Напишите программу, 
# которая составит список простых множителей числа N.
def task2():
    d = int(input('Введите натуральное число: '))
    list = []
    num = 2

    while d != 1:
        if d % num == 0:
            d = d / num

            if not num in list:
                list.append()

        else:
            num += 1

    print('Простые множители числа:', list)  

# Задайте последовательность чисел. 
# Напишите программу, которая выведет список неповторяющихся 
# элементов исходной последовательности.
def task3():
    # d = input('Вводите числа (для выхода нажмите q): ')
    # list = []
    # list2=[]


    # while d != 'q':
    #     list.append(int(d))

    #     if not int(d) in list2:
    #         list2.append(int(d))

    #     d = input()
    
    # print(list)
    # print(list2)

    list = [1,2,3,1,2,3,123,3,2,1,6,10,4]
    list2 =[]

    for i in range(0,len(list)):
        repeats = 0

        for j in range(0,len(list)):
            if list[i] == list[j]:
                repeats += 1

        if repeats == 1:
            list2.append(list[i])
            
    print(list2)

task3()


